package com.capgemini.walletapp.service;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import com.capgemini.walletapp.bean.WalletDetails;

public class WalletServiceTest {
	WalletService service;
	WalletDetails details;
	@Test
	public void testCreateAccount() {
		Assert.assertNotSame(2, service.createAccount(details));
	}

	@Test
	public void testWithdraw() {
		Assert.assertNotSame(1, service.withdraw(12312));
	}

	@Test
	public void testFundTransfer() {
		Assert.assertNotSame(1, service.fundTransfer(231, 231230));
	}

	@Test
	public void testPrintTransaction() {
		Assert.assertNotSame(2, service.printTransaction());
	}

	@Test
	public void testShowBal() {
		Assert.assertNotSame(1, service.showBal());
	}

	@Test
	public void testDeposit() {
		Assert.assertNotSame(1, service.deposit(1213));
	}

}
