package com.capgemini.walletapp.service;

import com.capgemini.walletapp.bean.WalletDetails;

public class WalletDataValidate {
WalletDetails details = new WalletDetails();	
	public boolean validateName(String firstName,String lastname) {
		if(firstName.length()>0&&lastname.length()>0)
		{
			return true;
		}
		else
		return false;
		
	}
	public boolean validateUsername(String username) {
		if(username.length()>4)
			return true;
		else {
		return false;
	}
}
	public boolean validateEmail(String email)
	{
		if(!email.isEmpty())
			return true;
		return false;
		
	}
public boolean validateMobNum(String mobileNum) {
	if(mobileNum.length()==10)
		return true;
	else
		return false;
} 

public boolean validateGender(String gender)
{
	if(gender.equalsIgnoreCase("male")||gender.equalsIgnoreCase("female"))
		return true;
	else
		return false;
	}
public boolean validateAge(int age)
{
	if(age>0)
		return true;
	else
	return false;
}
public boolean validateBalance(double amount) {
	if(amount>0)
		return true;
	return false;
	
}
	
	}

