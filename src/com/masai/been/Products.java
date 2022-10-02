package com.masai.been;

import java.util.Date;

public class Products {

	private int id;
	private String name;
	private int quantity;
	private int price;
	private Date indate;
	private int sellerid;
	private String category;
	public Products() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Products(int id, String name, int quantity, int price, Date indate, int sellerid, String category) {
		super();
		this.id = id;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		this.indate = indate;
		this.sellerid = sellerid;
		this.category = category;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Date getIndate() {
		return indate;
	}
	public void setIndate(Date localDate) {
		this.indate = localDate;
	}
	public int getSellerid() {
		return sellerid;
	}
	public void setSellerid(int sellerid) {
		this.sellerid = sellerid;
	}
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Products [id=" + id + ", name=" + name + ", quantity=" + quantity + ", price=" + price + ", indate="
				+ indate + ", sellerid=" + sellerid + ", category=" + category + "]";
	}


	
}
