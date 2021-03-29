package com.webapp.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.webapp.pojo.Person;

@Repository(value = "personRepository")
public class PersonRepositoryImpl implements PersonRepository {

	@Autowired
	private DataSource dataSource;
	
	@Override
	public Person fetchPerson(int id) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String query = "select * from Person where USER_ID="+id;
		@SuppressWarnings("unchecked")
		List<Person> list = jdbcTemplate.query(query, new PersonMapper());
		if(list.isEmpty()) {
			
		}
		return list.get(0);
	}

	@Override
	public boolean updatePerson(Person person) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String query = "update Person set USER_NAME=?, USER_EMAIL=?, USER_PASSWORD=?, USER_AGE=? where USER_ID=?";
		jdbcTemplate.update(
				query,
				person.getUsername(),
				person.getEmail(),
				person.getPassword(),
				person.getAge(),
				person.getId()
		);
		return true;
	}

}

class PersonMapper implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		Person p = new Person();
		p.setId(rs.getInt("USER_ID"));
		p.setUsername(rs.getString("USER_NAME"));
		p.setEmail(rs.getString("USER_EMAIL"));
		p.setPassword(rs.getString("USER_PASSWORD"));
		p.setAge(rs.getInt("USER_AGE"));
		return p;
	}
	
}
