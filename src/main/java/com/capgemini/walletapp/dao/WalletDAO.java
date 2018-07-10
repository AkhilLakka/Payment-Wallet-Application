
package com.capgemini.walletapp.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
	public void login(String username,String password) {
		
		
		
		
	}
	public List displayDetails(long accNum) {

		Iterator<WalletDetails> it = list.iterator();
		
		return list;

	}
	public int withdraw(long accNum) {
		System.out.println("enter amount to withdraw:");
		BufferedReader br= new BufferedReader( new InputStreamReader(System.in));
		try {
			String amount = br.readLine();
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		
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
