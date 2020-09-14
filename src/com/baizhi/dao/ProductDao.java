package com.baizhi.dao;

import java.util.List;

import com.baizhi.entity.Product;

public interface ProductDao {
	
	List<Product> selectByPage(Integer begin,Integer end);
	
	Integer totalPage();
	
	List<Product> selectByName(String productName);
	
	List<Product> selectByNameAndPriceD(String productName,Double priceD);
	
	List<Product> selectByNameAndPriceX(String productName,Double priceX);
	
	List<Product> selectByPriceD(Double priceD);
	
	List<Product> selectByPriceX(Double priceX);
	
	Product selectById(Integer id);
	
	
}
