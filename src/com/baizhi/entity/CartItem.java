package com.baizhi.entity;

import java.io.Serializable;

public class CartItem implements Serializable{
	private Product product;
	private Integer num;//商品数量
	private Double totalPrice;//商品总价
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public Double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public CartItem(Product product, Integer num, Double totalPrice) {
		super();
		this.product = product;
		this.num = num;
		this.totalPrice = totalPrice;
	}
	public CartItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "CartItem [product=" + product + ", num=" + num
				+ ", totalPrice=" + totalPrice + "]";
	}
	
}
