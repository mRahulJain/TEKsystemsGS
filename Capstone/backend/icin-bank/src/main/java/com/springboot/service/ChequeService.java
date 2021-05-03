package com.springboot.service;

import java.util.List;

import com.springboot.pojo.Cheque;

public interface ChequeService {

	public List<Cheque> getAllChequeBookIssued(String accountNumber);
	public String generateChequeBookRequest(String accountNumber);
	public int getChequeBookCount(String accountNumber);
	public String isSomeChequeBookRequested(String accountNumber);
	public String changeChequeBookStatus(String chequeBookNumber);
	public List<Cheque> getAllPendingChequeBookRequests();
	
}
