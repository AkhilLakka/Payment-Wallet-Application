package com.capgemini.walletapp.test;

import org.junit.Test;

import com.capgemini.walletapp.bean.WalletDetails;

import junit.framework.Assert;

public class WalletDetailsTest {

	WalletDetails details;
	@Test
	public void testGetFirstName() {
		Assert.assertEquals("akhil", details.getFirstName());
		Assert.assertNotSame("xyz", details.getFirstName());
		Assert.assertNotNull(details);

	}

	@Test
	public void testGetLastname() {
		Assert.assertEquals("lakka", details.getLastname());
		Assert.assertNotSame("lakka", details.getLastname());
	}

	@Test
	public void testGetAccNum() {
		Assert.assertEquals("2102532012154", details.getAccNum());
		Assert.assertNotSame("   ", details.getAccNum());
		Assert.assertNotSame("Account number should be greater than 12 digits", "2541369875214", details.getAccNum());
	}

	@Test
	public void testGetGender() {
		Assert.assertEquals("male", details.getGender());
		Assert.assertNotSame("others", details.getGender());
		Assert.assertNotNull(details);

	}

	@Test
	public void testGetEmail() {
		Assert.assertEquals("akhil.lakka@capgemini.com", details.getEmail());
		Assert.assertNotSame(" ", details.getEmail());
		Assert.assertNotSame("akhil lakka@capgemini.com", details.getEmail());
		Assert.assertNotNull(details);
		

	}

	@Test
	public void testGetMobileNum() {
		Assert.assertEquals("9989941244", details.getMobileNum());
		Assert.assertNotSame(" ", details.getMobileNum());
		Assert.assertNotSame("998994124", details.getMobileNum());

	}

	@Test
	public void testGetUsername() {
		Assert.assertEquals("akhillakka", details.getUsername());
		Assert.assertNotSame(" ", details.getUsername());
		Assert.assertNotSame("$abcd", details.getUsername());
		Assert.assertNotSame("akhil lakka", details.getUsername());
	}

	@Test
	public void testGetPassword() {
		Assert.assertEquals("A$kh12@l", details.getPassword());
		Assert.assertNotSame("passowrd should contains special characters and numbers too", "password", details.getPassword());
		Assert.assertNotSame("password cannot be empty", "  ", details.getPassword());
	}

	@Test
	public void testGetAmount() {
		Assert.assertEquals("35000", details.getAmount());
		Assert.assertNotSame("please enter the amount", " ", details.getAmount());
	}

	@Test
	public void testGetAge() {
		Assert.assertEquals(21, 21);
		Assert.assertEquals("age field cannot be empty", 21, details.getAge());
		Assert.assertNotSame("enter your age accoding to your dob", 30,details.getAge());
	}

	@Test
	public void testGetLocaldate() {
		Assert.assertEquals(22 / 07 / 18, details.getLocaldate());
		Assert.assertNotSame("dob should not be empty", " ",details.getLocaldate());
	}

	@Test
	public void testGettId() {
		Assert.assertEquals(121, 121);
		Assert.assertNotSame("enter a valid emp Id", 102, details.gettId());
		Assert.assertNotSame("Please fill the empID field", 0, details.gettId());

	}

}
