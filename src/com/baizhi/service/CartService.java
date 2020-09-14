package com.baizhi.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

public interface CartService {
	void addCart(Integer id,HttpServletRequest request);
	
	void deletCart(Integer id,HttpServletRequest request);
	
	void deletAllCart(List<Integer> ids,HttpServletRequest request);
}
