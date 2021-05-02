package com.springboot.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Cheque {

	@Id
	@Column(name = "CHEQUE_BOOK_NUMBER")
	private String chequeBookNumber;
	
	@Column(name = "ACCOUNT_NUMBER")
	private String accountNumber;
	
	@Column(name = "CHEQUE_BOOK_ISSUE_DATE")
	private Date chequeBookIssueDate;
	
	@Column(name = "CHEQUE_BOOK_STATUS ")
	private int chequeBookStatus;

	@Override
	public String toString() {
		return "Cheque [chequeBookNumber=" + chequeBookNumber + ", accountNumber=" + accountNumber
				+ ", chequeBookIssueDate=" + chequeBookIssueDate + ", chequeBookStatus=" + chequeBookStatus + "]";
	}
	
	public Cheque(String chequeBookNumber, String accountNumber, Date chequeBookIssueDate, int chequeBookStatus) {
		super();
		this.chequeBookNumber = chequeBookNumber;
		this.accountNumber = accountNumber;
		this.chequeBookIssueDate = chequeBookIssueDate;
		this.chequeBookStatus = chequeBookStatus;
	}

	public Cheque() {
		super();
	}

	public String getChequeBookNumber() {
		return chequeBookNumber;
	}

	public void setChequeBookNumber(String chequeBookNumber) {
		this.chequeBookNumber = chequeBookNumber;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Date getChequeBookIssueDate() {
		return chequeBookIssueDate;
	}

	public void setChequeBookIssueDate(Date chequeBookIssueDate) {
		this.chequeBookIssueDate = chequeBookIssueDate;
	}

	public int getChequeBookStatus() {
		return chequeBookStatus;
	}

	public void setChequeBookStatus(int chequeBookStatus) {
		this.chequeBookStatus = chequeBookStatus;
	}
	
}