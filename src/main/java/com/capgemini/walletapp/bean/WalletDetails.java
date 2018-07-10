package com.capgemini.walletapp.bean;

import java.sql.Date;

public class WalletDetails {
	private String firstName;
	private String lastname;
	private long accNum;
	private long tId;
	
	private String gender;
	private String email;
	private String mobileNum;
	private String username;
	private String password;
	private String amount;
	private int age;
	private Date Localdate;
	
	@Override
	public String toString() {
		return "WalletDetails [firstName=" + firstName + ", lastname=" + lastname + ", accNum=" + accNum + ", gender="
				+ gender + ", email=" + email + ", mobileNum=" + mobileNum + ", username=" + username + ", password="
				+ password + ", amount=" + amount + ", age=" + age + ", Localdate=" + Localdate + "]";
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public long getAccNum() {
		return accNum;
	}
	public void setAccNum(long accNum) {
		this.accNum = accNum;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
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
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getLocaldate() {
		return Localdate;
	}
	public void setLocaldate(Date localdate) {
		Localdate = localdate;
	}public long gettId() {
		return tId;
	}
	public void settId(long tId) {
		this.tId = tId;
	}

}
