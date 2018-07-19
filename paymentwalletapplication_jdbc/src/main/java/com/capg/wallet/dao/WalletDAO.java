
package com.capg.wallet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import com.capg.wallet.bean.CustomerDetails;
import com.capg.wallet.service.Util;


public class WalletDAO implements IWalletDAO {
	static ResultSet rs1,rs2,rs3;
	static long tId;
	double bal=0.0;

	public int createAccount(CustomerDetails bean) {
		try {
			Connection con = Util.getConnection();
			String insert ="insert into customer values(?,?,?,?,?,?,?,?)";
			PreparedStatement stmt = con.prepareStatement(insert);
			stmt.setString(1, bean.getCustomerName());
			stmt.setLong(2, bean.getAadharNum());
			stmt.setString(3, bean.getUsername());
			stmt.setString(4, bean.getPassword());
			stmt.setString(5, bean.getGender());
			stmt.setInt(6, bean.getAge());
			stmt.setString(7, bean.getMobileNum());
			stmt.setString(8, bean.getEmail());
			int n1=stmt.executeUpdate();
			
			String insert2 ="insert into wallet values(?,curdate(),?,?,?,?)";
			PreparedStatement stmt1 = con.prepareStatement(insert2);
			stmt1.setLong(1, bean.getWallet().getAccNum());
			stmt1.setDouble(2, bean.getWallet().getBalance());
			stmt1.setString(3, bean.getWallet().getBranch());
			stmt1.setString(4, bean.getWallet().getAccType());
			stmt1.setLong(5, bean.getWallet().getAadharNum());
			int n2=stmt1.executeUpdate();
			if(n1==1&& n2==1)
			{
				return 1;
			}
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e)
		{
			e.printStackTrace();
		}
		return 0;
		}

	
	
		
	

	public boolean login(String username, String password) {

		try {
			Connection con = Util.getConnection();
			String select ="select * from customer where username='"+username+"'and password ='"+password+"'";
	
			PreparedStatement stmt = con.prepareStatement(select);
			rs1=stmt.executeQuery();
	
			if(rs1.first()) {
				int d= rs1.getInt(2);
				System.out.println(d);
				System.out.println(rs1.getString(3));
			String select2 ="select * from wallet where adharNo="+d;
			PreparedStatement stmt1 = con.prepareStatement(select2);
			rs2=stmt1.executeQuery();
			
			
		}
			
			if(rs2.first()) {
				return true;
			}
	}catch(ClassNotFoundException e) {
		
		e.printStackTrace();
			
		
	}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public int deposit(double balance) {

		try {
		Connection con = Util.getConnection();
		if(rs2.first()) {
			double d=rs2.getDouble(3)+balance;
			System.out.println(d);
			String update = "update wallet set initial_balance='"+d+"' where adharNo ='"+rs2.getLong(6)+"'";
			System.out.println(update);
			PreparedStatement stmt = con.prepareStatement(update);
			if(stmt.executeUpdate()==1)
			{
				tId=((long)(Math.random()*1234+9999));
				LocalDateTime date = LocalDateTime.now();
				String s = "TransactionID "+Long.toString(tId)+"at"+date.toString()+"and tranferred amount is:"+Double.toString(balance);
				String insert="insert into transactions values("+rs2.getInt(6)+",'"+s+"')";
				PreparedStatement pst = con.prepareStatement(insert);
				pst.executeUpdate();
				int b = rs1.getInt(2);
				String select2 = "select * from wallet where adharNo="+b;
				PreparedStatement stmt1 = con.prepareStatement(select2);
				rs2=stmt1.executeQuery();
				return 1;
			}
		}
	}catch(ClassNotFoundException e) {
		e.printStackTrace();
	}catch(SQLException e) {
		e.printStackTrace();
	}
		return 0;
	}
		

	public int withdraw(double balance) {

		try {
			Connection con = Util.getConnection();
			if(rs2.first()) {
				double d = rs2.getDouble(3)-balance;
				String update="update wallet set initial_balance"+d+"where adharNo="+rs2.getLong(6)+",";
				PreparedStatement stmt = con.prepareStatement(update);
				if(stmt.executeUpdate()==1) {
					tId=((long)(Math.random()*1234+9999));
					LocalDateTime date = LocalDateTime.now();
					String s = "TransactionID "+Long.toString(tId)+"at"+date.toString()+"and tranferred amount is:"+Double.toString(balance) ;
					String insert="insert into transactions values("+rs2.getInt(6)+",'"+s+"')";
					PreparedStatement pst = con.prepareStatement(insert);
					pst.executeUpdate();
					System.out.println("amount withdrawn successfully");
					int b = rs1.getInt(2);
					String select2 = "select * from wallet where adharNo="+b;
					PreparedStatement stmt1 = con.prepareStatement(select2);
					rs2=stmt1.executeQuery();
					return 1;
					
				}
				
				
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public int fundTransfer(long accNum, double balance) {
		
		try {
			Connection con = Util.getConnection();
			if(rs2.first()) {
				double d = rs2.getDouble(3)-balance;
				String update1 ="update wallet set initial_balance="+d+"where adharNo='"+rs2.getLong(6)+"'";
				PreparedStatement stmt11 = con.prepareStatement(update1);
				String select ="select *from wallet where accountNo="+accNum;
				PreparedStatement stmt1 = con.prepareStatement(select);
				rs3=stmt1.executeQuery();
				if(rs3.first()) {
					double d1 = rs3.getDouble(3)+balance;
					String update ="update wallet set initial_balance= "+d1+"where adharNo='"+rs3.getLong(6)+"'";
					PreparedStatement stmt = con.prepareStatement(update);
					if(stmt11.executeUpdate()==1) {
						tId=((long)(Math.random()*1234+9999));
						LocalDateTime date = LocalDateTime.now();
						String s = "TransactionID "+Long.toString(tId)+"at"+date.toString()+"and tranferred amount is:"+Double.toString(balance)+"to accountNumber"+accNum;
						String insert="insert into transactions values("+rs2.getInt(6)+",'"+s+"')";
						PreparedStatement pst = con.prepareStatement(insert);
						pst.executeUpdate();
					System.out.println(balance+"amount debited from your account");	
					int b= rs1.getInt(2);
					String select2="select * from wallet where adharNo="+b;
					PreparedStatement stmt2 = con.prepareStatement(select2);
					rs2=stmt2.executeQuery();
					return 1;
					}
					}
				}
				
				
			}catch (ClassNotFoundException e) {
				// TODO: handle exception
				e.printStackTrace();
			} catch(SQLException e)
		{
				e.printStackTrace();
		}return 0;
		

	}

	public void printTrans() {
		
		try {
			Connection con;
			try {
				con = Util.getConnection();
				String select ="select * from transactions where adharNO="+rs2.getInt(6);
				PreparedStatement pst = con.prepareStatement(select);
				ResultSet rs4 = pst.executeQuery();
				while(rs4.next()) {
					System.out.println(rs4.getString(2));
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}

	public double showBal() {

		try {
			Connection con = Util.getConnection();
			System.out.println(rs2.first());
			System.out.println(rs1.getString(3));
			if(rs2.first()) {
				bal= rs2.getDouble(3);
				System.out.println("balance"+bal);
				return bal;
			}
		}catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}return bal;
		
	}
	
}
















