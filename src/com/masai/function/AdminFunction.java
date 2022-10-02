package com.masai.function;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.masai.been.Admin;
import com.masai.been.Buyer;
import com.masai.been.Seller;
import com.masai.dao.AdminDoa;
import com.masai.dao.AdminDoaimpl;

public class AdminFunction {

	static Scanner sc = new Scanner(System.in);
	static AdminDoa ad = new AdminDoaimpl();
	
	public static void main() {
		
		Admin am = new Admin();
		am = ligin();
		System.out.println("welcome "+ am.getName());
		int a = 0;
		while (a == 0) {
			System.out.println("press one to all buyers");
			System.out.println("press two to all sellers");
			System.out.println("press three to daily selling report");
			System.out.println("press four to daily disput");
			System.out.println("press five to solve disput");
			System.out.println("press six to Exit");
			System.out.println("Enter your choice");
			int ch = sc.nextInt();
			if(ch ==1) {
				List<Buyer> byl = new ArrayList<>();
				byl = ad.all_buyer();
				System.out.println("-----------------------------------------------------------------------------");
		        System.out.printf("%5s %10s %10s %10s %10s %10s", "id","name","address","mobile","email","username");
		        System.out.println();
		        System.out.println("-----------------------------------------------------------------------------");
		        for(Buyer pr: byl){
		            System.out.format("%5s %10s %10s %10s %10s %10s",
		            			pr.getId(), pr.getName(), pr.getAddress(), pr.getMobile(),pr.getMobile(),pr.getEmail(),pr.getUsername());
		            System.out.println();
		        }
		        System.out.println("-----------------------------------------------------------------------------");
			}else if(ch ==2) {
				List<Seller> byl = new ArrayList<>();
				byl = ad.all_seller();
				System.out.println("-----------------------------------------------------------------------------");
		        System.out.printf("%5s %10s %10s %10s %10s %10s", "id","name","address","mobile","email","username");
		        System.out.println();
		        System.out.println("-----------------------------------------------------------------------------");
		        for(Seller pr: byl){
		            System.out.format("%5s %10s %10s %10s %10s %10s",
		            			pr.getId(), pr.getName(), pr.getAddress(), pr.getMobile(),pr.getMobile(),pr.getEmail(),pr.getUsername());
		            System.out.println();
		        }
		        System.out.println("-----------------------------------------------------------------------------");
			}else if(ch ==3) {
				ad.daily_selling();
			}else if(ch == 6) {
				a++;
			}else {
				System.out.println("Wrong input..!");
			}
			
		}
	}
	private static Admin ligin() {
		
		System.out.println("Enter the username");
		String n = sc.next();
		System.out.println("Enter the password.");
		String p = sc.next();
		Admin am = new Admin();
		am = ad.login(n, p);
		return am;
	}
}
