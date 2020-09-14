package com.baizhi.test;

import java.util.List;

import org.junit.Test;

import com.baizhi.entity.Product;
import com.baizhi.entity.User;
import com.baizhi.service.ProductService;
import com.baizhi.service.ProductServiceImpl;
import com.baizhi.service.UserService;
import com.baizhi.service.UserServiceImpl;

public class TestService {
	private ProductService service=new ProductServiceImpl();
	@Test
	public void test0(){
		List<Product> list = service.queryByPage(1, 2);
		for(Product p:list){
			System.out.println(p);
		}
	}
	@Test
	public void test1(){
		Integer t = service.totalPageService(2);
		System.out.println(t);
	}
	@Test
	public void test5(){
		Product p = service.queryById(5);
		
		System.out.println(p);
			
	}
	@Test
	public void test6(){
		UserService service=new UserServiceImpl();
		User user = service.selectUser("luxw", "1234");
		System.out.println(user);
	}
	
	@Test
	public void test7(){
		UserService service=new UserServiceImpl();
		User user=new User("luxw","1234","ÀîËÄ",100000,"Çàµº");
		service.updateByUser(user);
	}
}


