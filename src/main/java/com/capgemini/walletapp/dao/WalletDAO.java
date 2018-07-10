
package com.capgemini.walletapp.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.capgemini.walletapp.bean.WalletDetails;

public class WalletDAO implements IWalletDAO {
	WalletDetails details = new WalletDetails();
	boolean flag = false;
	List<WalletDetails> list = new ArrayList<WalletDetails>();

	
	public boolean createAccount(WalletDetails details) {
		
		flag = list.add(details);
		System.out.println(flag);
		return flag;
	
	}
	public void login() {
		
		
		
	}
	public List displayDetails(long accNum) {

		Iterator<WalletDetails> it = list.iterator();
		
		return list;

	}
	public int withdraw(long accNum) {
		System.out.println("enter amount to withdraw:");
		
		return 0;
	}

	

	public boolean deposit(WalletDetails details) {
		flag = list.add(details);
		System.out.println(flag);
		return flag;
	
	}

	public int showBal(long accNum) {

		return 0;
	}

	public int fundTransfer() {

		return 0;
	}

	public int printTransaction() {

		return 0;
	}
	public boolean deposit() {
		// TODO Auto-generated method stub
		return false;
	}

	


}
