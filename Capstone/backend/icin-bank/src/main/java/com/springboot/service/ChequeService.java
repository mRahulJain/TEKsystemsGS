package com.springboot.service;

public interface ChequeService {

	public String generateChequeBookRequest(String accountNumber);
	public int getChequeBookCount(String accountNumber);
	public String isSomeChequeBookRequested(String accountNumber);
	public String changeChequeBookStatus(String chequeBookNumber);
	
}
