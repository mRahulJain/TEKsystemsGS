package com.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.pojo.Admin;
import com.springboot.repository.AdminRepository;

@Service("adminService")
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepository adminRepository;

	@Override
	public Admin getAdminPassword() {
		return this.adminRepository.findAll().get(0);
	}

	@Override
	public void changePassword(String password) {
		this.adminRepository.deleteAll();
		Admin admin = new Admin();
		admin.setPassword(password);
		this.adminRepository.saveAndFlush(admin);
	}
	
}
