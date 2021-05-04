package com.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.pojo.Accounts;
import com.springboot.pojo.Users;
import com.springboot.repository.AccountsRepository;
import com.springboot.repository.UsersRepository;

@Service(value = "usersService")
public class UsersServiceImpl implements UsersService {

	@Autowired
	private UsersRepository usersRepository;
	@Autowired
	private AccountsRepository accountsRepository;
	
	@Override
	public String putUser(Users user) {
		List<Accounts> accounts = this.accountsRepository.findAll();
		Accounts account = null;
		for(Accounts temp : accounts) {
			if(temp.getAccountNumber().equals(user.getAccountNumber())) {
				account = temp;
				break;
			}
		}
		if(account == null) {
			return "No such account exist!";
		}
		if(!account.getAccountHolderName().equals(user.getAccountHolderName())) {
			return "Name does not match with the database!";
		}
		if(account.getAccountIsNetBankingReg() == 1) {
			return "Account already registered!";
		}
		this.accountsRepository.delete(account);
		account.setAccountIsNetBankingReg(1);
		this.accountsRepository.save(account);
		this.usersRepository.save(user);
		return "Successfully registered!";
	}

	@Override
	public String checkUserByIdAndPassword(String loginUserId, String loginUserPassword) {
		List<Users> list = this.usersRepository.findAll();
		for(Users user : list) {
			if(user.getAccountLoginUserId().equals(loginUserId)) {
				if(user.getAccountIsBlocked() == 1) {
					return "failure";
				}
				if(user.getAccountLoginPassword().equals(loginUserPassword)) {
					return "success";
				} else {
					return "Password entered is wrong!";
				}
			}
		}
		return "No such user id exist in our database!";
	}

	@Override
	public Users getUserViaUserId(String loginUserId) {
		List<Users> list = this.usersRepository.findAll();
		for(Users user : list) {
			if(user.getAccountLoginUserId().equals(loginUserId)) {
				return user;
			}
		}
		return null;
	}

	@Override
	public String updateLoginPassword(String newPassword, String accountNumber) {
		Users user = this.usersRepository.getOne(accountNumber);
		this.usersRepository.delete(user);
		user.setAccountLoginPassword(newPassword);
		this.usersRepository.save(user);
		return "Successfully changed login password!";
	}

	@Override
	public String blockUser(String loginUserId) {
		Users user = this.usersRepository.getUserByLoginUserID(loginUserId).get(0);
		this.usersRepository.delete(user);
		user.setAccountIsBlocked(1);
		this.usersRepository.save(user);
		return "You account has been blocked!\nPlease contact your nearest ICIN bank!";
	}

	@Override
	public String unblockUser(String loginUserId) {
		Users user = this.usersRepository.getUserByLoginUserID(loginUserId).get(0);
		this.usersRepository.delete(user);
		user.setAccountIsBlocked(0);
		this.usersRepository.save(user);
		return "Account Unblocked";
	}

	@Override
	public List<Users> getAllBlockedUser() {
		return this.usersRepository.getAllBlockedUser(1);
	}

}
