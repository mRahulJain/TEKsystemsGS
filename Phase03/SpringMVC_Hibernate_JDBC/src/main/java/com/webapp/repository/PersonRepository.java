package com.webapp.repository;

import com.webapp.pojo.Person;

public interface PersonRepository {

	public Person fetchPerson(int id);
	
	public boolean updatePerson(Person person);
	
}
