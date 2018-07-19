package com.capgemini.walletapp.bean;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class WalletDetails {
	
	private long accNum;
	private long tId;
	private double balance;	
	private String username;
	private String password;
	private Date Localdate;
	
	
	
	private CustomerDetails cust;
	private List<String> trans = new ArrayList<String>();
	
 

	public List<String> getTrans() {
		return trans;
	}
	public void setTrans(List<String> trans) {
		this.trans = trans;
	}
	public CustomerDetails getCust() {
		return cust;
	}
	public void setCust(CustomerDetails cust) {
		this.cust = cust;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public long getAccNum() {
		return accNum;
	}
	public void setAccNum(long accNum) {
		this.accNum = accNum;
	}
	public long gettId() {
		return tId;
	}
	public void settId(long tId) {
		this.tId = tId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Date getLocaldate() {
		return Localdate;
	}
	public void setLocaldate(Date localdate) {
		Localdate = localdate;
	}
	
}
