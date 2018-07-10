package com.capgemini.walletapp.service;

import com.capgemini.walletapp.bean.WalletDetails;

public interface IWalletService {

	public boolean createAccount(WalletDetails details);
	public int withdraw();
	public boolean deposit(WalletDetails details);
	public int showBal(long accNum);
	public int fundTransfer();
	public int printTransaction();
}
