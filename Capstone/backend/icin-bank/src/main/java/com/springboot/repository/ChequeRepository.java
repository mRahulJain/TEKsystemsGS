package com.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.pojo.Cheque;

@Repository(value = "chequeRepository")
public interface ChequeRepository extends JpaRepository<Cheque, String> {

}
