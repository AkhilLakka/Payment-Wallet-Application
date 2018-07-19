package com.capg.wallet.bean;

public class CustomerDetails {
	
	
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
	public long getAadharNum() {
		return aadharNum;
	}
	public void setAadharNum(long aadharNum) {
		this.aadharNum = aadharNum;
	}
	private String customerName;
	private String username;
	private String password;
	private String gender;
	private int age;
	private String email;
	private String mobileNum;
	private long aadharNum;
	private WalletDetails wallet;
	
	
	public WalletDetails getWallet() {
		return wallet;
	}
	public void setWallet(WalletDetails wallet) {
		this.wallet = wallet;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getGender() {
		return gender;
	} 
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobileNum() {
		return mobileNum;
	}
	public void setMobileNum(String mobileNum) {
		this.mobileNum = mobileNum;
	}

}
