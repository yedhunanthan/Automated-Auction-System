package com.masai.been;

public class Buyer {

	private int id ;
	private String name;
	private String address;
	private String mobile;
	private String email;
	private String username;
	private String password;
	public Buyer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Buyer(int id, String name, String address, String mobile, String email, String username, String password) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.mobile = mobile;
		this.email = email;
		this.username = username;
		this.password = password;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Buyer [id=" + id + ", name=" + name + ", address=" + address + ", mobile=" + mobile + ", email=" + email
				+ ", username=" + username + ", password=" + password + "]";
	}
	
}
