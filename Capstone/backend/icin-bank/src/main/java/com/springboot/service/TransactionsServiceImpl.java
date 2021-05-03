package com.springboot.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springboot.pojo.Accounts;
import com.springboot.pojo.FrontendTransaction;
import com.springboot.pojo.Transactions;
import com.springboot.repository.AccountsRepository;
import com.springboot.repository.TransactionsRepository;

@Service(value = "transactionsService")
public class TransactionsServiceImpl implements TransactionsService {

	@Autowired
	private TransactionsRepository transactionsRepository;
	@Autowired
	private AccountsRepository accountsRepository;

	@Override
	public String addTransaction(Transactions transactions) {
		List<Transactions> list = this.transactionsRepository.getTransactionsByAccountNumber(transactions.getFromAccountNumber());
		double amountPrimary = 0;
		double amountSavings = 0;
		for(Transactions temp : list) {
			if(temp.getTransferStatus() == 0) {
				if(temp.getFromAccountType().equals("Primary")) {
					amountPrimary += temp.getTransferAmount();
				} else {
					amountSavings += temp.getTransferAmount();
				}
			}
		}
		
		boolean check = false;
		List<Accounts> accountsList = this.accountsRepository.findAll();
		for(Accounts temp : accountsList) {
			if(temp.getAccountNumber().equals(transactions.getToAccountNumber())) {
				check = true;
			}
		}
		if(!check) {
			return "Transfer bank account does not exists!";
		}
		
		Accounts myAccount = this.accountsRepository.getOne(transactions.getFromAccountNumber());
		if(transactions.getFromAccountType().equals("Primary")) {
			if(myAccount.getAccountBalancePrimary()-amountPrimary < transactions.getTransferAmount()) {
				return "You already have some pending transactions!\nYour primary account would not have that much balance if these transactions are permitted!";
			}
		} else {
			if(myAccount.getAccountBalanceSavings()-amountSavings < transactions.getTransferAmount()) {
				return "You already have some pending transactions!\nYour savings account would not have that much balance if these transactions are permitted!";
			}
		}
		
		Transactions finalTransaction = new Transactions(
					transactions.getFromAccountNumber(),
					transactions.getToAccountNumber(),
					transactions.getFromAccountType(),
					transactions.getToAccountType(),
					transactions.getTransferAmount(),
					new Date(),
					transactions.getTransferStatus()
				);
		
		this.transactionsRepository.save(finalTransaction);
		return "Transfer initiated.\nCheck the status in the transactions tab!";
	}

	@Override
	public String updateTransaction(int id) {
		Transactions transaction = this.transactionsRepository.getOne(id);
		this.transactionsRepository.delete(transaction);
		
		Accounts receiverAccount = this.accountsRepository.getOne(transaction.getToAccountNumber());
		Accounts senderAccount = this.accountsRepository.getOne(transaction.getFromAccountNumber());
		
		this.accountsRepository.delete(receiverAccount);
		this.accountsRepository.delete(senderAccount);
		
		if(transaction.getFromAccountType().equals("Primary")) {
			if(transaction.getToAccountType().equals("Primary")) {
				receiverAccount.setAccountBalancePrimary(receiverAccount.getAccountBalancePrimary()+transaction.getTransferAmount());
				senderAccount.setAccountBalancePrimary(senderAccount.getAccountBalancePrimary()-transaction.getTransferAmount());
			} else {
				receiverAccount.setAccountBalanceSavings(receiverAccount.getAccountBalanceSavings()+transaction.getTransferAmount());
				senderAccount.setAccountBalancePrimary(senderAccount.getAccountBalancePrimary()-transaction.getTransferAmount());
			}
		} else {
			if(transaction.getToAccountType().equals("Primary")) {
				receiverAccount.setAccountBalancePrimary(receiverAccount.getAccountBalancePrimary()+transaction.getTransferAmount());
				senderAccount.setAccountBalanceSavings(senderAccount.getAccountBalanceSavings()-transaction.getTransferAmount());
			} else {
				receiverAccount.setAccountBalanceSavings(receiverAccount.getAccountBalanceSavings()+transaction.getTransferAmount());
				senderAccount.setAccountBalanceSavings(senderAccount.getAccountBalanceSavings()-transaction.getTransferAmount());
			}
		}
		
		this.accountsRepository.save(senderAccount);
		this.accountsRepository.save(receiverAccount);
		transaction.setTransferStatus(1);
		this.transactionsRepository.save(transaction);
		return "Transaction Permitted!";
	}

	@Override
	public List<FrontendTransaction> getTransactionsForAccountNumber(String accountNumber) {
		List<Transactions> mainList = this.transactionsRepository.getTransactionsForAccountNumber(accountNumber);
		List<FrontendTransaction> toReturnList = new ArrayList<FrontendTransaction>();
		for(Transactions temp : mainList) {
			FrontendTransaction tempTransaction = new FrontendTransaction();
			tempTransaction.setId(temp.getId());
			tempTransaction.setFromAccountNumber(temp.getFromAccountNumber());
			tempTransaction.setToAccountNumber(temp.getToAccountNumber());
			tempTransaction.setFromAccountType(temp.getFromAccountType());
			tempTransaction.setToAccountType(temp.getToAccountType());
			tempTransaction.setTransferAmount(temp.getTransferAmount());
			tempTransaction.setTransferDate(temp.getTransferDate());
			tempTransaction.setTransferStatus(temp.getTransferStatus());
			if(temp.getFromAccountNumber().equals(accountNumber)) {
				tempTransaction.setTransferType("Debited");
			} else {
				tempTransaction.setTransferType("Credited");
			}
			toReturnList.add(tempTransaction);
		}
		return toReturnList;
	}

	@Override
	public List<Transactions> getAllPendingTransactions() {
		return this.transactionsRepository.getPendingTransactions(0);
	}
}
