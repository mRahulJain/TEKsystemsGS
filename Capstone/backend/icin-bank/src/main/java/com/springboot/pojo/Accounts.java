package com.springboot.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Accounts {

	@Id
	@Column(name = "ACCOUNT_NUMBER")
	private String accountNumber;
	
	@Column(name = "ACCOUNT_HOLDER_NAME")
	private String accountHolderName;
	
	@Column(name = "ACCOUNT_TYPE")
	private String accountType;
	
	@Column(name = "ACCOUNT_CIF_NUMBER")
	private String accountCIFNumber;
	
	@Column(name = "ACCOUNT_BRANCH")
	private String accountBranch;
	
	@Column(name = "ACCOUNT_BALANCE")
	private double accountBalance;
	
	@Column(name = "ACCOUNT_IS_NET_BANKING_REG")
	private int accountIsNetBankingReg;

	@Override
	public String toString() {
		return "Accounts [accountNumber=" + accountNumber + ", accountHolderName=" + accountHolderName
				+ ", accountType=" + accountType + ", accountCIFNumber=" + accountCIFNumber + ", accountBranch="
				+ accountBranch + ", accountBalance=" + accountBalance + ", accountIsNetBankingReg="
				+ accountIsNetBankingReg + "]";
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getAccountCIFNumber() {
		return accountCIFNumber;
	}

	public void setAccountCIFNumber(String accountCIFNumber) {
		this.accountCIFNumber = accountCIFNumber;
	}

	public String getAccountBranch() {
		return accountBranch;
	}

	public void setAccountBranch(String accountBranch) {
		this.accountBranch = accountBranch;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}
	
	public int getAccountIsNetBankingReg() {
		return accountIsNetBankingReg;
	}

	public void setAccountIsNetBankingReg(int accountIsNetBankingReg) {
		this.accountIsNetBankingReg = accountIsNetBankingReg;
	}
	
	public Accounts(String accountNumber, String accountHolderName, String accountType, String accountCIFNumber,
			String accountBranch, double accountBalance, int accountIsNetBankingReg) {
		super();
		this.accountNumber = accountNumber;
		this.accountHolderName = accountHolderName;
		this.accountType = accountType;
		this.accountCIFNumber = accountCIFNumber;
		this.accountBranch = accountBranch;
		this.accountBalance = accountBalance;
		this.accountIsNetBankingReg = accountIsNetBankingReg;
	}

	public Accounts() {
		super();
	}
	
}
