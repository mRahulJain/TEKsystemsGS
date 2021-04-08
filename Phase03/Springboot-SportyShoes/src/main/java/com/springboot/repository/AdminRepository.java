package com.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springboot.pojo.Admin;
import com.springboot.pojo.Purchase;

@Repository("adminRepository")
public interface AdminRepository extends JpaRepository<Admin, Integer> {
	
}
