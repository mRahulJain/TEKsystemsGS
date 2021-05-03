package com.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.springboot.pojo.Transactions;

@Repository(value = "transactionsRepository")
public interface TransactionsRepository extends JpaRepository<Transactions, Integer> {

	@Query(
			value = "SELECT * from Transactions where FROM_ACCOUNT_NUMBER like ?1 OR TO_ACCOUNT_NUMBER like ?1 order by TRANSFER_DATE desc",
			nativeQuery = true)
	List<Transactions> getTransactionsForAccountNumber(String accountNumber);
	
	@Query(
			value = "SELECT * from Transactions where FROM_ACCOUNT_NUMBER like ?1 order by TRANSFER_DATE desc",
			nativeQuery = true)
	List<Transactions> getTransactionsByAccountNumber(String accountNumber);
	
	@Query(
			value = "SELECT * from Transactions where TRANSFER_STATUS like ?1 order by TRANSFER_DATE",
			nativeQuery = true)
	List<Transactions> getPendingTransactions(int status);
	
}
