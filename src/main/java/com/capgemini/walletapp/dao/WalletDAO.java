
package com.capgemini.walletapp.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import com.capgemini.walletapp.bean.WalletDetails;
import com.capgemini.walletapp.service.WalletDataValidate;
import com.capgemini.walletapp.service.WalletService;

public class WalletDAO implements IWalletDAO {
	int x = 0;
	static double d;
	WalletDetails details = new WalletDetails();
	WalletDetails temp    = new WalletDetails();
	boolean flag = false;

	static List<WalletDetails> list = new ArrayList<WalletDetails>();

	public boolean createAccount(WalletDetails details) {

		flag = list.add(details);
		System.out.println(flag);
		System.out.println(list);
		return flag;
	}

	public boolean login(String username, String password) {

		Iterator<WalletDetails> it = list.iterator();

		while (it.hasNext()) {
			WalletDetails rec = it.next();

			String u = rec.getUsername();
			String p = rec.getPassword();

			if (username.equals(u) && password.equals(p)) {
				temp= rec;
				return true;

			} else {
				System.out.println("login failed");
				return false;
			}

		}
		return false;
	}

	public int deposit(double balance) {

		 temp.setBalance(temp.getBalance() + balance);
		
		System.out.println("amount deposited ..present balance is" + temp.getBalance());
		System.out.println(temp.getBalance());
		return 1;
	}

	public int withdraw(double balance) {
		if (balance < temp.getBalance()) {
			double bal = temp.getBalance() - balance;
			System.out.println("amount withdrawn ...present bal" + bal);
			return 1;
		} else {
			System.out.println("insufficient balance");
		}
		return 0;
	}

	public int fundTransfer(long accNum, double balance) {

		Iterator<WalletDetails> it = list.iterator();
		while (it.hasNext()) {
			WalletDetails rec = it.next();
			if (rec.getAccNum() == accNum) {
				rec.setBalance(rec.getBalance() +balance);
				temp.setBalance(temp.getBalance() - balance);
				temp.settId((long) (Math.random() * 1234 + 9999));
				System.out.println("Fundtransfer successful with ID" + temp.gettId());
				System.out.println("Balance after transfering in" + temp.getCust().getFirstName() + "" + temp.getCust().getLastname() + "is"
						+ temp.getBalance());
				System.out.println("Balance after receiving amount in" + rec.getCust().getFirstName() + "" + rec.getCust().getLastname()
						+ "is" + rec.getBalance());

			} 
		}
		return 1;
	}

	
	public List printTrans() {
		
		Iterator<WalletDetails> it = list.iterator();
		while(it.hasNext())
		{
			WalletDetails rec= it.next();
			if(rec.getUsername().equals(temp.getUsername())) {
				return rec.getTrans();
			}			
		}return null;	
	}

		
	
	public double showBal() {
		
		d=temp.getBalance();	
		return d;
	}

}
