package com.capg.wallet.dao;

import java.util.List;

import com.capg.wallet.bean.CustomerDetails;



public interface IWalletDAO {
	public int createAccount(CustomerDetails details);
	public int withdraw(double balance);
	public int deposit(double balance);
	public double showBal();
	public int fundTransfer(long accNum,double amount);
	public boolean login(String username,String password);
	public void printTrans();

}
 