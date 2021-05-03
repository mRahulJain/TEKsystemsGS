package com.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.springboot.pojo.Cheque;

@Repository(value = "chequeRepository")
public interface ChequeRepository extends JpaRepository<Cheque, String> {

	@Query(
			value = "SELECT * from Cheque where ACCOUNT_NUMBER like ?1 order by CHEQUE_BOOK_ISSUE_DATE desc",
			nativeQuery = true)
	List<Cheque> getChequeBookIssuedByAccountNumber(String accountNumber);
	
	@Query(
			value = "SELECT * from Cheque where CHEQUE_BOOK_STATUS like ?1 order by CHEQUE_BOOK_ISSUE_DATE",
			nativeQuery = true)
	List<Cheque> getAllPendingChequeBookRequests(int status);
	
}
