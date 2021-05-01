package com.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.pojo.Message;
import com.springboot.pojo.Users;
import com.springboot.service.UsersService;

@CrossOrigin
@RestController
public class UsersController {

	@Autowired
	private UsersService usersService;
	
	@GetMapping("/users/{loginUserId}")
	public Users getUserViaUserId(@PathVariable String loginUserId) {
		return this.usersService.getUserViaUserId(loginUserId);
	}
	
	@PostMapping("/users/check/{loginUserId}/{loginUserPassword}")
	public String checkUserByIdAndPassword(@PathVariable String loginUserId, @PathVariable String loginUserPassword) {
		return this.usersService.checkUserByIdAndPassword(loginUserId, loginUserPassword);
	}
	
	@PostMapping("/users/addUser")
	public Message putUser(@RequestBody Users user) {
		Message message = new Message(this.usersService.putUser(user));
		return message;
	}
	
}
