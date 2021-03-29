package com.webapp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.webapp.pojo.Person;
import com.webapp.service.PersonService;

@Controller
public class PersonController {
	
	@Autowired
	private PersonService personService;
	
	@RequestMapping(path = "/search", method = RequestMethod.POST)
	public String getData(HttpServletRequest request, Model model) {
		Person person = this.personService.getPerson(Integer.parseInt(request.getParameter("userID")));
		model.addAttribute("person", person);
		model.addAttribute("type", false);
		return "show-person";
	}
	
	@RequestMapping(path = "/update", method = RequestMethod.POST)
	public String updatePerson(HttpServletRequest request, Model model) throws IOException {
		String username = request.getParameter("userName");
		String email = request.getParameter("userEmail");
		String password = request.getParameter("userPassword");
		int age = Integer.parseInt(request.getParameter("userAge"));
		int id = Integer.parseInt(request.getParameter("userID"));
		Person person = new Person();
		person.setUsername(username);
		person.setEmail(email);
		person.setPassword(password);
		person.setAge(age);
		person.setId(id);
		personService.updatePerson(person);
		model.addAttribute("person", person);
		model.addAttribute("type", true);
		return "show-person";
	}
	
}
