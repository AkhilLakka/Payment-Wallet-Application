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
		Assert.assertNotSame(1, dao.deposit(231231));
	}

	@Test
	public void testShowBal() {
		Assert.assertNotSame(2, dao.showBal());
	}

	@Test
	public void testFundTransfer() {
		Assert.assertNotSame(2, dao.fundTransfer(21, 4450));
	}

	@Test
	public void testPrintTransaction() {
		Assert.assertNotSame(2, dao.printTrans());
	}

}
