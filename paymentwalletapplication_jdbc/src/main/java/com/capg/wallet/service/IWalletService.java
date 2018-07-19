package com.capg.wallet.service;

import java.util.List;

import com.capg.wallet.bean.CustomerDetails;



public interface IWalletService {

	public int createAccount(CustomerDetails details);
	public int withdraw(double balance);
	public int deposit(double amount);
	public double showBal();
	public int fundTransfer(long accNum,double balance);
	public void printTransaction();
	public boolean login(String username,String password);
}
 