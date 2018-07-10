package com.capgemini.walletapp.dao;

import static org.junit.Assert.*;

import org.junit.Test;

import com.capgemini.walletapp.bean.WalletDetails;

import junit.framework.Assert;

public class WalletDAOTest {

	
	WalletDAO dao = new WalletDAO();
	WalletDetails details ;
	@Test
	public void testCreateAccount() {
		
		Assert.assertNotNull(dao);
		Assert.assertNotSame(2, dao.createAccount(details));
	}

	@Test
	public void testDisplayDetails() {
		
	}

	@Test
	public void testWithdraw() {
		Assert.assertNotSame(1, dao.withdraw(1546587));
	}

	@Test
	public void testDeposit() {
		Assert.assertNotSame(1, dao.deposit(details));
	}

	@Test
	public void testShowBal() {
		Assert.assertNotSame(2, dao.showBal(54213657));
	}

	@Test
	public void testFundTransfer() {
		Assert.assertNotSame(2, dao.fundTransfer());
	}

	@Test
	public void testPrintTransaction() {
		Assert.assertNotSame(2, dao.printTransaction());
	}

}
