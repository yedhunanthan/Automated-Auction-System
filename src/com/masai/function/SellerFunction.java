package com.masai.function;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.masai.Main.Main;
import com.masai.been.Products;
import com.masai.been.Seller;
import com.masai.dao.SellerDoa;
import com.masai.dao.SellerDoaImpl;

public class SellerFunction {

	static Scanner sc = new Scanner(System.in);
	static SellerDoa se  = new SellerDoaImpl();

	
	private static String update(Seller seller) {
		
		System.out.println("press one to update name");
		System.out.println("press two to update Quantity");
		System.out.println("press three to update price");
		System.out.println("Enter your choice");
		System.out.println("Enter your choice");
		int x1 = sc.nextInt();
		if(x1 == 1) {
			System.out.println("Enter the product id");
			int p_id = sc.nextInt(); 
			System.out.println("Enter the new name for the product");
			String p_na = sc.next();
			String msg = se.update_name(seller.getId(), p_id, p_na);
			return msg;
		}else if(x1 == 2) {
			System.out.println("Enter the product id");
			int p_id = sc.nextInt(); 
			System.out.println("Enter the new Quantity of the product.");
			int p_qa = sc.nextInt();
			String msg = se.update_quantity(seller.getId(), p_id, p_qa);
			return msg;
		}else if(x1 == 3) {
			System.out.println("Enter the product id");
			int p_id = sc.nextInt(); 
			System.out.println("Enter the new price of the product.");
			int p_pa = sc.nextInt();
			String msg = se.update_quantity(seller.getId(), p_id, p_pa);
			return msg;
		}else {
			System.out.println("Wrong input..!");
			return "#";
		}
		
	}
	
	private static String remove(Seller seller) {
		
		System.out.println("Enter the product id");
		int p_id = sc.nextInt();
		String msg = se.remove(seller.getId(), p_id);
		return msg;
	}
	
	private static void insert_products(Seller seller) {
		
		Products products = new Products();
		System.out.println("Enter the details of the products");
		System.out.println("Name");
		products.setName(sc.next());
		System.out.println("Quantity");
		products.setQuantity(sc.nextInt());
		System.out.println("Price");
		products.setPrice(sc.nextInt());
		products.setSellerid(seller.getId());
		System.out.println("category");
		products.setCategory(sc.next());
		String msg = se.insretinto(products);
		System.out.println(msg);
	}
	private static void see_all_products(List<Products> prl) {
		
		System.out.println("-----------------------------------------------------------------------------");
        System.out.printf("%5s %8s %15s %10s %15s", "ID", "NAME", "Quantity", "price", "Entry date");
        System.out.println();
        System.out.println("-----------------------------------------------------------------------------");
        for(Products pr: prl){
            System.out.format("%5s %13s %5s %15s %15s",
                    pr.getId(), pr.getName(), pr.getQuantity(), pr.getPrice(), pr.getIndate());
            System.out.println();
        }
        System.out.println("-----------------------------------------------------------------------------");
        
	}
	public static void main(Seller seller) {

		System.out.println("welcome "+ seller.getName());
		System.out.println("your Id "+seller.getId());
		int a = 0;
		while (a == 0) {
			System.out.println("press one to update existing products");
			System.out.println("press two to remove a products");
			System.out.println("press three to Add a products");
			System.out.println("press four to see all products");
			System.out.println("press five to Exit");
			System.out.println("Enter your choice");
			int ch = sc.nextInt();
			if(ch == 1) {
				String msg = update(seller);
				if(msg == "#")
					update(seller);
				else
					System.out.println(msg);
			}else if(ch == 2) {
				String msg = remove(seller);
				System.out.println(msg);
			}else if(ch == 3) {
				insert_products(seller);
			}else if(ch == 5) {
				a++;
			}else if(ch == 4) {
				
				List<Products> prl =  new ArrayList<>();
				prl = se.all(seller.getId());
				if(prl.size() == 0)
					System.out.println("zero products under your name...!!");
				else
					see_all_products(prl);
			}else {
				System.out.println("Wrong input..!");
				
			}
		}
		Main.main(null);
		
	}
}
