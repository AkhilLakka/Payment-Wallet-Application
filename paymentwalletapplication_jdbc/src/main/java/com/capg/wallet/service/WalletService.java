package com.capg.wallet.service;

import java.util.List;

import com.capg.wallet.bean.CustomerDetails;
import com.capg.wallet.dao.WalletDAO;



public class WalletService implements IWalletService {

	WalletDAO dao = new WalletDAO();

	public int createAccount(CustomerDetails details) {
		
		return dao.createAccount(details);
		 
	}

	public int withdraw(double balance) {
		return dao.withdraw(balance);

	}
  
	public int fundTransfer(long accNum, double balance) {

		return dao.fundTransfer(accNum, balance);
	}

	public boolean login(String uname, String pass) {
		return dao.login(uname, pass);
	}

	public void printTransaction() {
		dao.printTrans();
	}

	public double showBal() {
		return dao.showBal();
	}

	public int deposit(double balance) {
		return dao.deposit(balance);
	}

}
