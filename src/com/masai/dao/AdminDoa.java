package com.masai.dao;

import java.util.List;

import com.masai.been.Admin;
import com.masai.been.Buyer;
import com.masai.been.Seller;

public interface AdminDoa {

	public Admin login(String n , String p);
	public List<Buyer> all_buyer();
	public List<Seller> all_seller();
	public void daily_selling();

}
