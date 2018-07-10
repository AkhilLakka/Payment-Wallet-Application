package com.capgemini.walletapp.dao;

import com.capgemini.walletapp.bean.WalletDetails;

public interface IWalletDAO {
	public boolean createAccount(WalletDetails details);
	public int withdraw(long accNum);
	public boolean deposit();
	public int showBal(long accNum);
	public int fundTransfer();
	public int printTransaction();

}
