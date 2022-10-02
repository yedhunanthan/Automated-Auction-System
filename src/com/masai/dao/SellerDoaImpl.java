package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masai.been.Products;
import com.masai.utility.Myutil;

public class SellerDoaImpl implements SellerDoa{

	
	@Override
	public List<Products> all(int id) {
		List<Products> prl = new ArrayList<>();
		try (Connection con = Myutil.make_connection()){
		
			PreparedStatement p1 = con.prepareStatement("select * from products where product_sellerid = ?");
			p1.setInt(1, id);
			ResultSet rs = p1.executeQuery();
			while(rs.next()) {
				prl.add(new Products(
						rs.getInt("product_id"), 
						rs.getString("product_name"),
						rs.getInt("product_quantity"),
						rs.getInt("product_price"),
						rs.getDate("product_indate"),
						rs.getInt("product_sellerid"),
						rs.getString("category")
						));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return prl;
	}
	@Override
	public String insretinto(Products products) {
		
		String msg = "insertion failed...!";
		try (Connection con = Myutil.make_connection()){
			
			PreparedStatement p1 = con.prepareStatement
			("insert into products(product_name,product_quantity,product_price,product_indate,product_sellerid,category) values(?,?,?,CURDATE(),?,?)");
			p1.setString(1, products.getName());
			p1.setInt(2, products.getQuantity());
			p1.setInt(3, products.getPrice());
			p1.setInt(4, products.getSellerid());
			p1.setString(5, products.getCategory());
			int x = p1.executeUpdate();
			if(x > 0)
				msg = "insertion successful...!";
			
		} catch (SQLException e) {
			msg = e.getMessage();
		}
		
		
		return msg;
	}

	@Override
	public String update_name(int Seller_id, int product_id, String name) {
		String msg = "Update failed...!";
		try (Connection con = Myutil.make_connection()){
			
			PreparedStatement p1 = con.prepareStatement("UPDATE products SET product_name = ? WHERE product_sellerid = ? and product_id = ?;");
			p1.setString(1, name);
			p1.setInt(2, Seller_id);
			p1.setInt(3, product_id);
			int x = p1.executeUpdate();
			if(x > 0)
				msg = "Update successful...!";
		} catch (SQLException e) {
			msg = e.getMessage();
		}
		return msg;
	}

	@Override
	public String update_quantity(int Seller_id, int product_id, int quantity) {
		String msg = "Update failed...!";
		try (Connection con = Myutil.make_connection()){
			
			PreparedStatement p1 = con.prepareStatement("UPDATE products SET product_quantity = ? WHERE product_sellerid = ? and product_id = ?;");
			p1.setInt(1, quantity);
			p1.setInt(2, Seller_id);
			p1.setInt(3, product_id);
			int x = p1.executeUpdate();
			if(x > 0)
				msg = "Update successful...!";
		} catch (SQLException e) {
			msg = e.getMessage();
		}
		return msg;
	}

	@Override
	public String update_price(int Seller_id, int product_id, int price) {
		String msg = "Update failed...!";
		try (Connection con = Myutil.make_connection()){
			
			PreparedStatement p1 = con.prepareStatement("UPDATE products SET product_price = ? WHERE product_sellerid = ? and product_id = ?;");
			p1.setInt(1, price);
			p1.setInt(2, Seller_id);
			p1.setInt(3, product_id);
			int x = p1.executeUpdate();
			if(x > 0)
				msg = "Update successful...!";
		} catch (SQLException e) {
			msg = e.getMessage();
		}
		return msg;
	}

	@Override
	public String remove(int Seller_id, int product_id) {
		String msg = "remove failed...!";
try (Connection con = Myutil.make_connection()){
			
			PreparedStatement p1 = con.prepareStatement("DELETE FROM products WHERE product_sellerid = ? and product_id = ?;");
			p1.setInt(1, Seller_id);
			p1.setInt(2, product_id);
			int x = p1.executeUpdate();
			if(x > 0)
				msg = "remove successful...!";
		} catch (SQLException e) {
			msg = e.getMessage();
		}
		return msg;
	}

}
