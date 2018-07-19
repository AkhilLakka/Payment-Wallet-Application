package com.capg.wallet.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.capg.wallet.bean.CustomerDetails;
import com.capg.wallet.bean.WalletDetails;
import com.capg.wallet.exception.UserNotFound;
import com.capg.wallet.service.WalletDataValidate;
import com.capg.wallet.service.WalletService;


public class Customer {
	static int choice = 0;
	static int b = 0;
	static int key=0;
	public static void createAccount() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		WalletService service = new WalletService();
		try {

			System.out.println("enter name");
			String custName = br.readLine();
			 
			System.out.println("enter email id");
			String email = br.readLine();			
			System.out.println("enter your mobile number");
			String mobileNum = br.readLine();
			System.out.println("Enter your gender");
			String gender = br.readLine();
			System.out.println("enter your username");
			String username = br.readLine();
			System.out.println("enter your password");
			String password = br.readLine();
			
			System.out.println("enter your balance");
			double balance = Double.parseDouble(br.readLine());
			System.out.println("enter your account type");
			String accType = br.readLine();
			System.out.println("enter your branch");
			String branch = br.readLine();
			System.out.println("enter your aadhar number");
			long aadharNum = Long.parseLong(br.readLine());
			System.out.println("enter your age");
			int age = br.read();
			
			WalletDetails details = new WalletDetails();
			CustomerDetails data=new CustomerDetails();
			long accNum = br.read();
			accNum = (long) (Math.random() * 1234 + 9999);
			System.out.println("your account number is" + accNum);
			LocalDate date = LocalDate.now();
			
		

			
			data.setCustomerName(custName);
			data.setUsername(username);
			data.setPassword(password);
			data.setGender(gender);
			data.setAge(age);
			data.setEmail(email);
			data.setMobileNum(mobileNum);
			data.setAadharNum(aadharNum);
			
			
			details.setAccNum(accNum);
			details.setDate(date);
			details.setBalance(balance);
			System.out.println(details.getBalance());
			details.setAccType(accType);
			details.setBranch(branch);
			details.setAadharNum(aadharNum);
			
			data.setWallet(details);

			WalletDataValidate validate = new WalletDataValidate();
			boolean isValidUsername = validate.validateUsername(username);
			boolean isValidEmail = validate.validateEmail(email);
			boolean isValidGender = validate.validateGender(gender);
			boolean isvalidAge = validate.validateAge(age);
			
			boolean isvalidMobileNum = validate.validateMobNum(mobileNum);

			if (isValidUsername && isValidEmail && isValidGender && isvalidAge  && isvalidMobileNum) {
				b = service.createAccount(data);
				System.out.println(b);
			} else {
				System.out.println("Enter valid details");
			}

			if (b==1)

				System.out.println("account created successfull with account number" + accNum);

			else {

				System.out.println("fail");
			}
		}

		catch (IOException e) {

			e.printStackTrace();
		}
	}

	public static void depositAmount() {
		WalletDetails details = new WalletDetails();
		WalletService service = new WalletService();
		System.out.println("enter amount to deposit");
		WalletDataValidate validate = new WalletDataValidate();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		double balance;
		try {
			balance = Double.parseDouble(br.readLine());
			boolean isValidBalance = validate.validateBalance(balance);
			service.deposit(balance);
		} catch (NumberFormatException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

	public static void login() {
		WalletService service = new WalletService();
		WalletDetails details = new WalletDetails();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("enter username");
		String uname = null;
		try {
			uname = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("enter password");
		String pass = null;
		try {
			pass = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(service.login(uname, pass))
		{
			System.out.println("login successful");
			do {
				System.out.println("1. show balance");
				System.out.println("2.deposit");
				System.out.println("3.withdraw");
				System.out.println("4.fund transfer");
				System.out.println("5.print transaction");
				System.out.println("6.exit");
				System.out.println("enter your choice");
				try {
					key=Integer.parseInt(br.readLine());
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				switch(key) {
				case 1:
					showBal();
					break;
				case 2:
					depositAmount();
					break;
				case 3:
					withdraw();
					break;
				case 4:
					fundTransfer();
					break;
				case 5:
					printTransaction();
					break;
				case 6:
					System.out.println("thank you");
					break;
				
				}
			
		}while(key!=6);
		}
		else {
			try {
				throw new UserNotFound();
			}catch(Exception e)
			{
				System.out.println("Login failed");
				e.printStackTrace();
			}
		
		}

	}
	public static void printTransaction() {
		
		WalletService service = new WalletService();
		
		
		service.printTransaction();
		
	}


	public static void showBal() {
		
		WalletService service = new WalletService();	
		System.out.println(service.showBal()+"\n");

	}

	
	public static void fundTransfer() {
		WalletService service= new WalletService();
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		System.out.println("enter receivers accnum");
		try {
			long accNum = Long.parseLong(br.readLine());
			System.out.println("enter amount to transfer ");
			double amount = Double.parseDouble(br.readLine());
			int trans=service.fundTransfer(accNum,amount);
			if(trans==1) {
				System.out.println("Fundtransfer successful");
			}
			else
				System.out.println("Enter valid account number");
		} 
		 catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void  withdraw() {
		WalletService service = new WalletService();
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		WalletDataValidate validate = new WalletDataValidate();
		System.out.println("enter amount to withdraw");
		double amount;
		try {
			amount= Double.parseDouble(br.readLine());
			boolean isValidBalance=validate.validateBalance(amount);
			service.withdraw(amount);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	} 

	public static void main(String[] args) {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		WalletService service = new WalletService();
		do {

			System.out.println("1.To create account");
			System.out.println("2.To login");
			System.out.println("3.To exit");

			try {
				choice = Integer.parseInt(br.readLine());
			} catch (IOException e1) {

				e1.printStackTrace();
			}

			switch (choice) {

			case 1:
				createAccount();
				break;

			case 2:
				login();
				break;
			case 3:
				System.out.println("Thank you");
				System.exit(0);
				break;
			default:
				System.out.println("enter valid choice");
				break;

			}
		} while (choice != 3);
	
	}

}
