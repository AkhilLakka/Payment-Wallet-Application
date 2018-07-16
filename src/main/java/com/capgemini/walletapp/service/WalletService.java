package com.capgemini.walletapp.service;

import java.util.List;

import com.capgemini.walletapp.bean.WalletDetails;
import com.capgemini.walletapp.dao.WalletDAO;

public class WalletService implements IWalletService {

	WalletDAO dao = new WalletDAO();

	public boolean createAccount(WalletDetails details) {
		// TODO Auto-generated method stub
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

	public List printTransaction() {
		return dao.printTrans();
	}

	public double showBal() {
		return dao.showBal();
	}

	public int deposit(double balance) {
		return dao.deposit(balance);
	}

}
