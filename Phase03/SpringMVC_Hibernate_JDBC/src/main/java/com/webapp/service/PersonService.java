package com.webapp.service;

import com.webapp.pojo.Person;

public interface PersonService {

	public Person getPerson(int id);
	public boolean updatePerson(Person person);
	
}
