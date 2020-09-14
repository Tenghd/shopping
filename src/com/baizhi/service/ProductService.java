package com.baizhi.service;

import java.util.List;

import com.baizhi.entity.Product;

public interface ProductService {
	
	List<Product> queryByPage(Integer currentPage,Integer pageSize);
	
	Integer totalPageService(Integer pageSize);
	
	List<Product> queryByName(String productName);
	
	List<Product> queryByNameAndPriceD(String productName,Double priceD);
	
	List<Product> queryByNameAndPriceX(String productName,Double priceX);
	
	List<Product> queryByPriceD(Double priceD);
	
	List<Product> queryByPriceX(Double priceX);
	
	Product queryById(Integer id);
}
