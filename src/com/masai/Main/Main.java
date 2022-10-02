package com.masai.Main;

import java.util.Scanner;

import com.masai.been.Buyer;
import com.masai.been.Seller;
import com.masai.function.AdminFunction;
import com.masai.function.BuyerFunction;
import com.masai.function.Login;
import com.masai.function.SellerFunction;
import com.masai.function.Signup;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("            Welcome to My_Auction.      ");
		System.out.println("Press one to log in.");
		System.out.println("Press two to signup.");
		System.out.println("Press three if you are an administrator.");
		System.out.println("Enter your choice");
		int x = sc.nextInt();
		if(x == 1) {
			Object obj =  Login.login();
			if(obj instanceof Seller) {
				Seller se = (Seller)obj;
				SellerFunction.main(se);
			}else if(obj instanceof Buyer) {
				Buyer by = (Buyer)obj;
				BuyerFunction.main(by);
			}else {
				Main.main(null);
			}
		}
		else if (x == 2) {
			Signup.signup();
		}
		else if(x == 3) {
			AdminFunction.main();	
		}
		sc.close();
	}
}
