package com.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.pojo.Users;

@Repository(value = "usersRepository")
public interface UsersRepository extends JpaRepository<Users, String>{

}
