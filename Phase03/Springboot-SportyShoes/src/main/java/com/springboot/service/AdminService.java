package com.springboot.service;

import com.springboot.pojo.Admin;

public interface AdminService {

	public Admin getAdminPassword();
	public void changePassword(String password);
	
}
