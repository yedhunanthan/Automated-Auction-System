package com.masai.dao;

import java.util.List;
import com.masai.been.Products;

public interface SellerDoa {

	public List<Products> all(int Seller_id);
	public String insretinto(Products products);
	public String update_name(int Seller_id,int product_id, String name);
	public String update_quantity(int Seller_id,int product_id,int quantity);
	public String update_price(int Seller_id,int product_id,int price);
	public String remove(int Seller_id, int product_id);

}