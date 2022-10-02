package com.masai.dao;

import java.util.List;

import com.masai.been.Buyer;
import com.masai.been.Products;
import com.masai.been.Seller;

public interface BuyerDoa {

	public String insretinto(Buyer buyer);
	public List<Products> sort_by_category(String category);
	public List<Products> sort_by_seller(int seller_id);
	public String buy(String product_name,int product_quantity,Buyer buyer);
	public List<Products> all_category();
	public List<Seller> all_seller();
	public List<Products> all();
}
