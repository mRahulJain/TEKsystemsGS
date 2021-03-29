package com.webapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webapp.pojo.Person;
import com.webapp.repository.PersonRepository;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonRepository personRepository;

	@Override
	public Person getPerson(int id) {
		return this.personRepository.fetchPerson(id);
	}

	@Override
	public boolean updatePerson(Person person) {
		return this.personRepository.updatePerson(person);
	}
	
	
}
