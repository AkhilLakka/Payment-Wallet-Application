package com.capgemini.walletapp.service;

import com.capgemini.walletapp.bean.WalletDetails;
import com.capgemini.walletapp.dao.WalletDAO;

public class WalletService implements IWalletService {

	WalletDAO dao= new WalletDAO();

	public boolean createAccount(WalletDetails details) {
		// TODO Auto-generated method stub
		return dao.createAccount(details);
	}

	public int withdraw() {
		// TODO Auto-generated method stub
		return 0;
	}

	

	public int fundTransfer() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int printTransaction() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int showBal(long accNum) {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean deposit(WalletDetails details) {
		return false;
		// TODO Auto-generated method stub
		
	}

	

}
