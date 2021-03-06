package com.baizhi.entity;

import java.io.Serializable;

public class User implements Serializable{
	private String username;
	private String password;//not null
	private String name;//not null
	private Integer zip;//number(6)
	private String address;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String username, String password, String name, Integer zip,
			String address) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
		this.zip = zip;
		this.address = address;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getZip() {
		return zip;
	}
	public void setZip(Integer zip) {
		this.zip = zip;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password
				+ ", name=" + name + ", zip=" + zip + ", address=" + address
				+ "]";
	}
	
}
