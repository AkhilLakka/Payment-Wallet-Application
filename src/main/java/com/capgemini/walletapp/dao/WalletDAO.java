
package com.capgemini.walletapp.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
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
	static WalletDetails temp = new WalletDetails();
	long tId;
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
				temp = rec;
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

		return 1;
	}

	public int withdraw(double balance) {

		Iterator<WalletDetails> it = list.iterator();
		while (it.hasNext()) {
			WalletDetails rec = it.next();
			if (rec.getUsername().equals(temp.getUsername())) {

				if (balance < temp.getBalance()) {
					rec.setBalance(rec.getBalance() - balance);
					System.out.println("amount withdrawn ...present bal" + rec.getBalance());
					tId = ((long) (Math.random() * 1234 + 9999));
					LocalDateTime d = LocalDateTime.now();
					String s = "TransactionID" + Long.toString(tId) + "at" + d.toString()
							+ "and transferred amount is :" + Double.toString(balance);

					rec.getTrans().add(s);

					return 1;
				}
			} else {
				System.out.println("insufficient balance");
			}
		}
		return 0;
	}

	public int fundTransfer(long accNum, double balance) {

		Iterator<WalletDetails> it = list.iterator();
		Iterator<WalletDetails> it1 = list.iterator();

		while (it.hasNext()) {
			WalletDetails rec = it.next();
			if (rec.getUsername().equals(temp.getUsername())) {
				while (it1.hasNext()) {
					WalletDetails rec1 = it1.next();

					if (rec1.getAccNum() == accNum) {
						rec1.setBalance(rec1.getBalance() + balance);
						// temp.setBalance(temp.getBalance() - balance);
						rec.setBalance(rec.getBalance() - balance);

						tId = ((long) (Math.random() * 1234 + 9999));
						LocalDateTime d = LocalDateTime.now();
						String s = "TransactionID" + Long.toString(tId) + "at" + d.toString()
								+ "and transferred amount is :" + Double.toString(balance);
						rec.getTrans().add(s);
						System.out.println("Fundtransfer successful with ID" + temp.gettId());
						System.out.println("Balance after transfering in  :" + rec.getCust().getFirstName() + ""
								+ rec.getCust().getLastname() + "is" + rec.getBalance());
						System.out.println("Balance after receiving amount in   :" + rec1.getCust().getFirstName() + ""
								+ rec1.getCust().getLastname() + "is" + rec1.getBalance());
						return 1;

					} else {
						System.out.println("enter valid account");
					}
				}
			} else {
				System.out.println("Account number not found");
			}
		}
		return 0;
	}

	public List printTrans() {

		Iterator<WalletDetails> it = list.iterator();
		while (it.hasNext()) {
			WalletDetails rec = it.next();
			if (rec.getUsername().equals(temp.getUsername())) {
				return rec.getTrans();
			}
		}
		return null;
	}

	public double showBal() {

		d = temp.getBalance();
		return d;
	}

}
