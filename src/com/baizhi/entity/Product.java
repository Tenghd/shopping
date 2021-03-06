package com.baizhi.entity;

import java.io.Serializable;

public class Product implements Serializable{
	private Integer id;
	private String productName; //not null
	private Double price;//number(7,2)
	private String picpath;
	private String discription;
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(Integer id, String productName, Double price,
			String picpath, String discription) {
		super();
		this.id = id;
		this.productName = productName;
		this.price = price;
		this.picpath = picpath;
		this.discription = discription;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getPicpath() {
		return picpath;
	}
	public void setPicpath(String picpath) {
		this.picpath = picpath;
	}
	public String getDiscription() {
		return discription;
	}
	public void setDiscription(String discription) {
		this.discription = discription;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", productName=" + productName
				+ ", price=" + price + ", picpath=" + picpath
				+ ", discription=" + discription + "]";
	}
	
}
