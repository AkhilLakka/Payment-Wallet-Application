package com.capgemini.walletapp.service;

import java.util.List;

import com.capgemini.walletapp.bean.WalletDetails;

public interface IWalletService {

	public boolean createAccount(WalletDetails details);
	public int withdraw(double balance);
	public int deposit(double amount);
	public double showBal();
	public int fundTransfer(long accNum,double balance);
	public List printTransaction();
	public boolean login(String username,String password);
}
 