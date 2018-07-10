package com.capgemini.walletapp.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import com.capgemini.walletapp.bean.WalletDetails;
import com.capgemini.walletapp.service.WalletService;


public class Customer {
	static int choice=0;
	static boolean b=false;

	public static void m1() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		WalletService service = new WalletService();
		try {

			
			System.out.println("enter firstname");
			String firstName = br.readLine();
			System.out.println("enter lastname");
			String lastname = br.readLine();
			System.out.println("enter email id");
			String email = br.readLine();
			System.out.println("enter your age");
			String age = br.readLine();
					System.out.println("enter your mobile number");
			String mobileNum = br.readLine();
			System.out.println("enter your username");
			String username = br.readLine();
			System.out.println("enter your password");
			String password = br.readLine();

			WalletDetails details = new WalletDetails();
			long accNum = br.read();
			accNum = (long) (Math.random() * 1234 + 9999);
			System.out.println("your account number is"+accNum);

			
			details.setFirstName(firstName);
			details.setLastname(lastname);
			details.setEmail(email);
			details.setMobileNum(mobileNum);
			details.setAccNum(accNum);
			details.setAge(Integer.parseInt(age));
			details.setUsername(username);
			details.setPassword(password);
			

//			WalletDataValidate validate = new WalletDataValidate();
//			boolean isValidUsername = validate.validateUsername(username);
//			boolean isValidAccNum = validate.validateAccNum(accNum);
//			boolean isvalidMobileNum = validate.validateMobileNum(mobileNum);
			

			//if (isValidUsername && isValidAccNum && isvalidMobileNum ) {
				b = service.createAccount(details);
				System.out.println(b);
			//} else {
			//	System.out.println("Enter valid details");
			//}
			System.out.println(b);
			if (b)

				System.out.println("account created successfull with account number" +accNum );

			else {
				
					System.out.println("fail");
				}
		}	
		
		 catch (IOException e) {
			
			e.printStackTrace();
		}
	}

	public static void m3() {
		System.out.println("Deposit your amount");
		WalletService service = new WalletService();
		WalletDetails details = new WalletDetails() ;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String amount;
		try {
			amount = br.readLine();
			service.deposit(details);
			System.out.println("amount deposited successfully");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void m2() {
	
		
	}

	

	

	public static void main(String[] args) {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		WalletService service = new WalletService();
		do {
			
			System.out.println("1.To create account");
			System.out.println("2.To login");
			System.out.println("3.To deposit");
			System.out.println("4.to withdraw");
			System.out.println("5.Transfer amount");
			System.out.println("6. to print transaction");
			System.out.println("7.to show balance");
			

			try {
				choice = Integer.parseInt(br.readLine());
			} catch (IOException e1) {

				e1.printStackTrace();
			}

			switch (choice) {

			case 1:
				m1();
				break;

			case 2:
				m2();
				break;
			case 3:
				m3();
				break;

			
			}
		} while (choice != 6);
		System.out.println("exit");
	}

}