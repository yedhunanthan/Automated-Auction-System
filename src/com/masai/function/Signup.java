package com.masai.function;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.masai.Main.Main;
import com.masai.been.Buyer;
import com.masai.been.Seller;
import com.masai.dao.BuyerDoa;
import com.masai.dao.BuyerDoaImpl;
import com.masai.utility.Myutil;


public class Signup {

	private static String signup_as_sellsr(Seller seller){
		
		String msg = "insertion failed...!";
		try (Connection con = Myutil.make_connection()){
			
			PreparedStatement p1 = con.prepareStatement
			("insert into seller(seller_name,seller_address,seller_mobile,seller_email,seller_username,seller_password) values(?,?,?,?,?,?)");
			p1.setString(1, seller.getName());
			p1.setString(2, seller.getAddress());
			p1.setString(3, seller.getMobile());
			p1.setString(4, seller.getEmail());
			p1.setString(5, seller.getUsername());
			p1.setString(6, seller.getPassword());
			int x = p1.executeUpdate();
			if(x > 0)
				msg ="insertion successful...!";
			
		} catch (SQLException e) {
			msg = e.getMessage();
		}
		return msg;
	}
	
	@SuppressWarnings("resource")
	public static void signup(){
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Press one to signup as Seller.");
		System.out.println("Press two to signup as Buyer.");
		System.out.println("Press three to go back");
		System.out.println("Enter your choice");
		int x = sc.nextInt();
		if(x ==1) {
			
			Seller seller = new Seller();
			System.out.println("Enter the details of the Seller");
			System.out.println("Name");
			seller.setName(sc.next());
			System.out.println("Address");
			seller.setAddress(sc.next());
			System.out.println("Monile number");
			seller.setMobile(sc.next());
			System.out.println("Emain id");
			seller.setEmail(sc.next());
			System.out.println("User name");
			seller.setUsername(sc.next());
			System.out.println("password");
			seller.setPassword(sc.next());
			String msg = signup_as_sellsr(seller);
			System.out.println(msg);
			SellerFunction.main(seller);
		}else if(x == 2) {
			
			Buyer buyer = new Buyer();
			System.out.println("Enter the details of the products");
			System.out.println("Name");
			buyer.setName(sc.next());
			System.out.println("Address");
			buyer.setAddress(sc.next());
			System.out.println("Mobile number");
			buyer.setMobile(sc.next());
			System.out.println("Email id");
			buyer.setEmail(sc.next());
			System.out.println("User name");
			buyer.setUsername(sc.next());
			System.out.println("Password");
			buyer.setPassword(sc.next());
			BuyerDoa by = new BuyerDoaImpl();
			String msg = by.insretinto(buyer);
			System.out.println(msg);
			BuyerFunction.main(buyer);
		}else if(x == 3) {
			Main.main(null);
		}else {
			signup();
		}
	}
}