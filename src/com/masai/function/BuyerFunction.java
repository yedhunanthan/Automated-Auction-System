package com.masai.function;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.masai.Main.Main;
import com.masai.been.Buyer;
import com.masai.been.Products;
import com.masai.been.Seller;
import com.masai.dao.BuyerDoa;
import com.masai.dao.BuyerDoaImpl;

public class BuyerFunction {

	static Scanner sc = new Scanner(System.in);
	static BuyerDoa buy = new BuyerDoaImpl();
	static int id =0;
	
	private static void see_all(List<Products> prl) {
		
		System.out.println("-----------------------------------------------------------------------------");
        System.out.printf("%5s %20s %15s %10s", "NAME", "Quantity", "price", "category");
        System.out.println();
        System.out.println("-----------------------------------------------------------------------------");
        for(Products pr: prl){
            System.out.format("%5s %20s %10s %15s",
            			pr.getName(), pr.getQuantity(), pr.getPrice(), pr.getCategory());
            System.out.println();
        }
        System.out.println("-----------------------------------------------------------------------------");
        
	}
	
	public static void main(Buyer buyer) {
		
		System.out.println("welcome "+ buyer.getName());
		int a = 0;
		while (a == 0) {
			System.out.println("press one to sort products by category");
			System.out.println("press two to sort products by seller");
			System.out.println("press three to see all products");
			System.out.println("press four to Exit");
			System.out.println("Enter your choice");
			int ch = sc.nextInt();
			if(ch == 1) {
				List<Products> prl = new ArrayList<>();
				prl = buy.all_category();
				prl.forEach(p ->{
					System.out.println("--"+p.getCategory());
				});
				System.out.println("Enter category");
				String category = sc.next();
				List<Products> prl1 = new ArrayList<>();
				prl1 = buy.sort_by_category(category);
				see_all(prl1);
				int a1 = 0;
				while(a1 == 0) {
					
					System.out.println("press one to Buy");
					System.out.println("press two to Exit");
					int b = sc.nextInt();
					if(b == 1) {
						System.out.println("Enter the product name");
						String p = sc.next();
						System.out.println("Enter the quantity of purchase");
						int q = sc.nextInt();
						String msg = buy.buy(p, q, buyer);
						System.out.println(msg);
					}else if(b == 2) {
						a1++;
					}else {
						System.out.println("Wrong input..!");
					}
				}
				
			}else if(ch == 2) {
				
				List<Seller> prl = new ArrayList<>();
				prl = buy.all_seller();
				prl.forEach(p ->{
					System.out.println("--"+p.getName());
				});
				System.out.println("Enter seller name");
				String name = sc.next();
				prl.forEach( p ->{
					if(name.equals(p.getName())) {
						 id = p.getId();
					}
				});
				List<Products> prl1 = new ArrayList<>();
				prl1 = buy.sort_by_seller(id);
				see_all(prl1);
				int a1 = 0;
				while(a1 == 0) {
					
					System.out.println("press one to Buy");
					System.out.println("press two to Exit");
					int b = sc.nextInt();
					if(b == 1) {
						System.out.println("Enter the product name");
						String p = sc.next();
						System.out.println("Enter the quantity of purchase");
						int q = sc.nextInt();
						String msg = buy.buy(p, q, buyer);
						System.out.println(msg);
					}else if(b == 2) {
						a1++;
					}else {
						System.out.println("Wrong input..!");
					}
				}
			}else if(ch == 3) {
				List<Products> prl1 = new ArrayList<>();
				prl1 = buy.all();
				see_all(prl1);
				int a1 = 0;
				while(a1 == 0) {
					
					System.out.println("press one to Buy");
					System.out.println("press two to Exit");
					int b = sc.nextInt();
					if(b == 1) {
						System.out.println("Enter the product name");
						String p = sc.next();
						System.out.println("Enter the quantity of purchase");
						int q = sc.nextInt();
						String msg = buy.buy(p, q, buyer);
						System.out.println(msg);
					}else if(b == 2) {
						a1++;
					}else {
						System.out.println("Wrong input..!");
					}
				}
			}else if(ch == 4) {
				a++;
			}else {
				System.out.println("Wrong input..!");
			}
		}
		Main.main(null);
	}
}
