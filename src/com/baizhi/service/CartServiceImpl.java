package com.baizhi.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.baizhi.dao.ProductDao;
import com.baizhi.dao.ProductDaoImpl;
import com.baizhi.entity.CartItem;
import com.baizhi.entity.Product;

public class CartServiceImpl implements CartService{

	@Override
	public void addCart(Integer id, HttpServletRequest request) {
		//获取商品信息
		ProductDao dao=new ProductDaoImpl();
		Product product =dao.selectById(id);
		//从session中获取一下当前用户的购物车
		HttpSession session =request.getSession();
		Map<Integer,CartItem> cart= (Map<Integer, CartItem>) session.getAttribute("cart");
		
		if(cart==null){//说明没有当前的购物测车，需要新创建一个购物车，并添加商品
			cart=new HashMap<Integer,CartItem>();
			//组建购物车项
			CartItem cartItem=new CartItem();
			cartItem.setProduct(product);
			cartItem.setNum(1);//默认第一次添加商品数量为1
			cartItem.setTotalPrice(1*product.getPrice());
			//商品加入购物车
			cart.put(product.getId(), cartItem);
			session.setAttribute("cart", cart);
			
		}else{
			//如果已经有了购物车，则先判断是不是第一次向购物车添加商品
			boolean b = cart.containsKey(product.getId());
			if(b){//如果有，则在原有的商品购物车的数量上加1
				CartItem cartItem=cart.get(product.getId());
				cartItem.setNum(cartItem.getNum()+1);
				cartItem.setTotalPrice((cartItem.getNum()+1)*product.getPrice());
				
			}else{//如果没有，添加一个新的购物车项
				//组建购物车项
				CartItem cartItem=new CartItem();
				cartItem.setProduct(product);
				cartItem.setNum(1);//默认第一次添加商品数量为1
				cartItem.setTotalPrice(1*product.getPrice());
				//商品加入购物车
				cart.put(product.getId(), cartItem);
			}
			
		}
		
	}

	@Override
	public void deletCart(Integer id, HttpServletRequest request) {
		HttpSession session = request.getSession();
		Map<Integer,CartItem> cart = (Map<Integer, CartItem>) session.getAttribute("cart");
		if(cart!=null){
			cart.remove(id);
		}
	}
	@Override
	public void deletAllCart(List<Integer> ids, HttpServletRequest request) {
		HttpSession session = request.getSession();
		Map<Integer,CartItem> cart = (Map<Integer, CartItem>) session.getAttribute("cart");
		if(cart!=null){
			for(Integer id:ids){
				cart.remove(id);
			}
		}
	}

}
