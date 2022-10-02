package com.masai.function;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.masai.been.Buyer;
import com.masai.been.Seller;
import com.masai.utility.Myutil;

public class Login {

	private static Seller ligin_as_seller(String username, String password) {
		
		Seller se = new Seller();
		try (Connection con = Myutil.make_connection()){
			
			PreparedStatement p1 = con.prepareStatement("select * from seller where seller_username = ? and seller_password = ? ;");
			p1.setString(1, username);
			p1.setString(2, password);
			ResultSet rs = p1.executeQuery();
			if(rs.next()) {
				se.setId(rs.getInt("seller_id"));
				se.setName(rs.getString("seller_name"));
				se.setAddress(rs.getString("seller_address"));
				se.setMobile(rs.getString("seller_mobile"));
				se.setEmail(rs.getString("seller_email"));
				se.setUsername(rs.getString("seller_username"));
				se.setPassword(rs.getString("seller_password"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return se;
		
	}
	private static Buyer ligin_as_buyer(String username, String password) {
		
		Buyer by = new Buyer();
		try (Connection con = Myutil.make_connection()){
			
			PreparedStatement p1 = con.prepareStatement("select * from buyer where buyer_username = ? and buyer_password = ? ;");
			p1.setString(1, username);
			p1.setString(2, password);
			ResultSet rs = p1.executeQuery();
			if(rs.next()) {
				by.setId(rs.getInt("buyer_id"));
				by.setName(rs.getString("buyer_name"));
				by.setAddress(rs.getString("buyer_address"));
				by.setMobile(rs.getString("buyer_mobile"));
				by.setEmail(rs.getString("buyer_email"));
				by.setUsername(rs.getString("buyer_username"));
				by.setPassword(rs.getString("buyer_password"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return by;
		
	}
	
	@SuppressWarnings("resource")
	public static Object login() {
		
		Object obj = new Object();
		Scanner sc = new Scanner(System.in);
		System.out.println("Press one to login as Seller.");
		System.out.println("Press two to login as Buyer.");
		System.out.println("Press three to go back");
		System.out.println("Enter your choice");
		int x = sc.nextInt();
		if(x == 1) {
			System.out.println("Enter the username");
			String n = sc.next();
			System.out.println("Enter the password.");
			String p = sc.next();
			obj = ligin_as_seller(n, p);
		}else if (x == 2) {
			System.out.println("Enter the username");
			String n = sc.next();
			System.out.println("Enter the password.");
			String p = sc.next();
			obj = ligin_as_buyer(n, p);
		}else if(x == 3) {
			return null;
		}else {
			System.out.println("Wrong input..!");
			login();
		}
		return obj;
	}
}
