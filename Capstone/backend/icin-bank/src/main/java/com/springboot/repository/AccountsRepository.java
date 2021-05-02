package com.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.springboot.pojo.Accounts;

@Repository(value = "accountsRepository")
public interface AccountsRepository extends JpaRepository<Accounts, String> {

	@Query(
			value = "SELECT * from Accounts where ACCOUNT_NUMBER like ?1",
			nativeQuery = true)
	List<Accounts> getAccountByAccountNumber(String accountNumber);
	
}
