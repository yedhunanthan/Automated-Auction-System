package com.masai.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masai.been.Buyer;
import com.masai.been.Products;
import com.masai.been.Seller;
import com.masai.utility.Myutil;

public class BuyerDoaImpl implements BuyerDoa{

	@Override
	public String insretinto(Buyer buyer) {
		String msg = "insertion failed...!";
		try (Connection con = Myutil.make_connection()){
			
			PreparedStatement p1 = con.prepareStatement
			("insert into buyer(buyer_name,buyer_address,buyer_mobile,buyer_email,buyer_username,buyer_password) values(?,?,?,?,?,?)");
			p1.setString(1, buyer.getName());
			p1.setString(2, buyer.getAddress());
			p1.setString(3, buyer.getMobile());
			p1.setString(4, buyer.getEmail());
			p1.setString(5, buyer.getUsername());
			p1.setString(6, buyer.getPassword());
			int x = p1.executeUpdate();
			if(x > 0)
				msg = "insertion successful...!";
			
		} catch (SQLException e) {
			msg = e.getMessage();
		}
		
		
		return msg;
	}

	@Override
	public List<Products> sort_by_category(String category) {
		List<Products> prl = new ArrayList<>();
		try (Connection con = Myutil.make_connection()){
			
			PreparedStatement p1 = con.prepareStatement("select product_id,product_name,product_quantity,product_price,category,product_sellerid from products where category = ?;");
			p1.setString(1, category);
			ResultSet re = p1.executeQuery();
			while (re.next()) {
				Products pro = new Products();
				pro.setId(re.getInt("product_id"));
				pro.setName(re.getString("product_name"));
				pro.setQuantity(re.getInt("product_quantity"));
				pro.setPrice(re.getInt("product_price"));
				pro.setCategory(re.getString("category"));
				pro.setSellerid(re.getInt("product_sellerid"));
				prl.add(pro);
			}
			return prl;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return prl;
	}

	@Override
	public List<Products> sort_by_seller(int seller_id) {
		List<Products> prl = new ArrayList<>();
		try (Connection con = Myutil.make_connection()){
			
			PreparedStatement p1 = con.prepareStatement("select product_id,product_name,product_quantity,product_price,category,product_sellerid from products where product_sellerid = ? ORDER BY category");
			p1.setInt(1, seller_id);
			ResultSet re = p1.executeQuery();
			while (re.next()) {
				Products pro = new Products();
				pro.setId(re.getInt("product_id"));
				pro.setName(re.getString("product_name"));
				pro.setQuantity(re.getInt("product_quantity"));
				pro.setPrice(re.getInt("product_price"));
				pro.setCategory(re.getString("category"));
				pro.setSellerid(re.getInt("product_sellerid"));
				prl.add(pro);
			}
			return prl;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return prl;
	}

	@Override
	public String buy(String product_name, int product_quantity,Buyer buyer) {
		String msg = "purchase failed..";
		try (Connection con = Myutil.make_connection()){
			
			PreparedStatement p1 = con.prepareStatement("select * from products where product_name = ?;");
			p1.setString(1, product_name);
			ResultSet re = p1.executeQuery();
			if(re.next()) {
				Products pr = new Products(
						re.getInt("product_id"), 
						re.getString("product_name"),
						re.getInt("product_quantity"),
						re.getInt("product_price"),
						re.getDate("product_indate"),
						re.getInt("product_sellerid"),
						re.getString("category")
						);
				pr.setQuantity(pr.getQuantity() - product_quantity);
				PreparedStatement p2 = con.prepareStatement("UPDATE products SET product_quantity = ? WHERE product_sellerid = ? and product_id = ?;");
				p2.setInt(1, pr.getQuantity());
				p2.setInt(2, pr.getSellerid());
				p2.setInt(3, pr.getId());
				p2.executeUpdate();
				PreparedStatement p3 = con.prepareStatement("insert into sold_products values(?,?,"+product_quantity+",?,?,CURDATE(),?,?,?)");
				p3.setInt(1, pr.getId());
				p3.setString(2, pr.getName());
				p3.setInt(3, pr.getPrice());
				p3.setDate(4,(Date) pr.getIndate());
				p3.setInt(5, pr.getSellerid());
				p3.setInt(6, buyer.getId());
				p3.setString(7, pr.getCategory());
				int x = p3.executeUpdate();
				if(x>0)
					msg ="purchase successful...";
				return msg;
			}

		}catch (SQLException e) {
			e.printStackTrace();
			msg = e.getMessage();
		}
		return msg;
		
	}

	@Override
	public List<Products> all_category() {
		
		List<Products> prl = new ArrayList<>();
		try (Connection con = Myutil.make_connection()){
			
			PreparedStatement p1 = con.prepareStatement("select DISTINCT(category) FROM products ;");
			ResultSet re = p1.executeQuery();
			while(re.next()) {
				Products pro =  new Products();
				pro.setCategory(re.getString("category"));
				prl.add(pro);
			}
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return prl;
	}

	@Override
	public List<Seller> all_seller() {
		List<Seller> prl = new ArrayList<>();
		try (Connection con = Myutil.make_connection()){
			
			PreparedStatement p1 = con.prepareStatement("select seller_name,seller_id FROM seller;");
			ResultSet re = p1.executeQuery();
			while(re.next()) {
				Seller se =  new Seller();
				se.setName(re.getString("seller_name"));
				se.setId(re.getInt("seller_id"));
				prl.add(se);
			}
			
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return prl;
	}

	@Override
	public List<Products> all() {
		List<Products> prl = new ArrayList<>();
		try (Connection con = Myutil.make_connection()){
			
			PreparedStatement p1 = con.prepareStatement("select product_id,product_name,product_quantity,product_price,category,product_sellerid from products");
			ResultSet re = p1.executeQuery();
			while (re.next()) {
				Products pro = new Products();
				pro.setId(re.getInt("product_id"));
				pro.setName(re.getString("product_name"));
				pro.setQuantity(re.getInt("product_quantity"));
				pro.setPrice(re.getInt("product_price"));
				pro.setCategory(re.getString("category"));
				pro.setSellerid(re.getInt("product_sellerid"));
				prl.add(pro);
			}
			return prl;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return prl;
	}
}
