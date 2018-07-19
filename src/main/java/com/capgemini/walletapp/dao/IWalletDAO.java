package com.capgemini.walletapp.dao;

import java.util.List;

import com.capgemini.walletapp.bean.WalletDetails;

public interface IWalletDAO {
	public boolean createAccount(WalletDetails details);
	public int withdraw(double balance);
	public int deposit(double balance);
	public double showBal();
	public int fundTransfer(long accNum,double amount);
	public boolean login(String username,String password);
	public List printTrans();

}
 