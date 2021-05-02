package com.springboot.service;

import org.apache.catalina.User;

import com.springboot.pojo.Users;

public interface UsersService {

	public Users getUserViaUserId(String loginUserId);
	public String putUser(Users user);
	public String updateLoginPassword(String newPassword, String accountNumber);
	public String checkUserByIdAndPassword(String loginUserId, String loginUserPassword);
	
}
