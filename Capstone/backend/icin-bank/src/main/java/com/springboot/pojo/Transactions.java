package com.springboot.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Transactions {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private int id;
	
	@Column(name = "FROM_ACCOUNT_NUMBER")
	private String fromAccountNumber;
	
	@Column(name = "TO_ACCOUNT_NUMBER")
	private String toAccountNumber;
	
	@Column(name = "FROM_ACCOUNT_TYPE")
	private String fromAccountType;
	
	@Column(name = "TO_ACCOUNT_TYPE")
	private String toAccountType;
	
	@Column(name = "TRANSFER_AMOUNT")
	private double transferAmount;
	
	@Column(name = "TRANSFER_DATE")
	private Date transferDate;
	
	@Column(name = "TRANSFER_STATUS")
	private int transferStatus;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFromAccountNumber() {
		return fromAccountNumber;
	}

	public void setFromAccountNumber(String fromAccountNumber) {
		this.fromAccountNumber = fromAccountNumber;
	}

	public String getToAccountNumber() {
		return toAccountNumber;
	}

	public void setToAccountNumber(String toAccountNumber) {
		this.toAccountNumber = toAccountNumber;
	}

	public String getFromAccountType() {
		return fromAccountType;
	}

	public void setFromAccountType(String fromAccountType) {
		this.fromAccountType = fromAccountType;
	}

	public String getToAccountType() {
		return toAccountType;
	}

	public void setToAccountType(String toAccountType) {
		this.toAccountType = toAccountType;
	}

	public double getTransferAmount() {
		return transferAmount;
	}

	public void setTransferAmount(double transferAmount) {
		this.transferAmount = transferAmount;
	}

	public Date getTransferDate() {
		return transferDate;
	}

	public void setTransferDate(Date transferDate) {
		this.transferDate = transferDate;
	}

	public int getTransferStatus() {
		return transferStatus;
	}

	public void setTransferStatus(int transferStatus) {
		this.transferStatus = transferStatus;
	}
	
	@Override
	public String toString() {
		return "Transactions [id=" + id + ", fromAccountNumber=" + fromAccountNumber + ", toAccountNumber="
				+ toAccountNumber + ", fromAccountType=" + fromAccountType + ", toAccountType=" + toAccountType
				+ ", transferAmount=" + transferAmount + ", transferDate=" + transferDate + ", transferStatus="
				+ transferStatus + "]";
	}

	public Transactions(String fromAccountNumber, String toAccountNumber, String fromAccountType, String toAccountType,
			double transferAmount, Date transferDate, int transferStatus) {
		super();
		this.fromAccountNumber = fromAccountNumber;
		this.toAccountNumber = toAccountNumber;
		this.fromAccountType = fromAccountType;
		this.toAccountType = toAccountType;
		this.transferAmount = transferAmount;
		this.transferDate = transferDate;
		this.transferStatus = transferStatus;
	}

	public Transactions() {
		super();
	}
	
	
}
