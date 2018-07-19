package com.capg.wallet.bean;

import java.time.LocalDate;

public class WalletDetails {
	
	private long accNum;
	public long getAccNum() {
		return accNum;
	}
	public void setAccNum(long accNum) {
		this.accNum = accNum;
	}
	private double balance;	
	private String accType;
	private String branch;
	private LocalDate date;
	private long AadharNum;
	
	
	

	
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public String getAccType() {
		return accType;
	}
	public void setAccType(String accType) {
		this.accType = accType;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public long getAadharNum() {
		return AadharNum;
	}
	public void setAadharNum(long aadharNum) {
		AadharNum = aadharNum;
	}

}
