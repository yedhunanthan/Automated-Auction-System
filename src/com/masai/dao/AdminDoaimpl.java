package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masai.been.Admin;
import com.masai.been.Buyer;
import com.masai.been.Seller;
import com.masai.utility.Myutil;

public class AdminDoaimpl implements AdminDoa{

	@Override
	public Admin login(String n, String p) {

		Admin admin = new Admin();
		try (Connection con = Myutil.make_connection()){
			
			PreparedStatement p1 = con.prepareStatement("select * from admin where admin_username = ? and admin_password = ? ;");
			p1.setString(1, n);
			p1.setString(2, p);
			ResultSet rs = p1.executeQuery();
			if(rs.next()) {
				admin.setId(rs.getInt("admin_id"));
				admin.setName(rs.getString("admin_name"));
				admin.setUsername(rs.getString("admin_username"));
				admin.setPassword(rs.getString("admin_password"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return admin;
	}

	@Override
	public List<Buyer> all_buyer() {
		List<Buyer> by = new ArrayList<>();
		try (Connection con = Myutil.make_connection()){
			
			PreparedStatement p1 = con.prepareStatement("select * from buyer;");
			ResultSet rs = p1.executeQuery();
			while(rs.next()) {
				Buyer b = new Buyer(
						rs.getInt("buyer_id"),
						rs.getString("buyer_name"),
						rs.getString("buyer_address"),
						rs.getString("buyer_mobile"),
						rs.getString("buyer_email"),
						rs.getString("buyer_username"),
						rs.getString("buyer_password")
						);
				by.add(b);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return by;
	}

	@Override
	public List<Seller> all_seller() {
		List<Seller> by = new ArrayList<>();
		try (Connection con = Myutil.make_connection()){
			
			PreparedStatement p1 = con.prepareStatement("select * from seller;");
			ResultSet rs = p1.executeQuery();
			while(rs.next()) {
				Seller b = new Seller(
						rs.getInt("seller_id"),
						rs.getString("seller_name"),
						rs.getString("seller_address"),
						rs.getString("seller_mobile"),
						rs.getString("seller_email"),
						rs.getString("seller_username"),
						rs.getString("seller_password")
						);
				by.add(b);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return by;
	}

	@Override
	public void daily_selling() {
	
try (Connection con = Myutil.make_connection()){
			
			PreparedStatement p1 = con.prepareStatement("select * from sold_products order by product_outdate;");
			ResultSet rs = p1.executeQuery();
			System.out.println("-----------------------------------------------------------------------------");
	        System.out.printf("%5s %10s %10s %10s %10s %10s %10s %10s %10s", "id","name","quantity","price","inserted date","sold date","sellerid","buyerid","category");
	        System.out.println();
	        System.out.println("-----------------------------------------------------------------------------");
			while(rs.next()) {
				System.out.format("%5s %10s %10s %10s %10s %10s %10s %10s %10s",
            			rs.getInt("product_id"),rs.getString("product_name"),rs.getInt("product_quantity"),rs.getInt("product_price"),rs.getDate("product_indate"),rs.getDate("product_outdate"),rs.getInt("product_sellerid"),rs.getInt("product_buyerid"),rs.getString("category"));
            System.out.println();
			}
			System.out.println("-----------------------------------------------------------------------------");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
