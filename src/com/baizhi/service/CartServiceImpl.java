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
		//��ȡ��Ʒ��Ϣ
		ProductDao dao=new ProductDaoImpl();
		Product product =dao.selectById(id);
		//��session�л�ȡһ�µ�ǰ�û��Ĺ��ﳵ
		HttpSession session =request.getSession();
		Map<Integer,CartItem> cart= (Map<Integer, CartItem>) session.getAttribute("cart");
		
		if(cart==null){//˵��û�е�ǰ�Ĺ���⳵����Ҫ�´���һ�����ﳵ���������Ʒ
			cart=new HashMap<Integer,CartItem>();
			//�齨���ﳵ��
			CartItem cartItem=new CartItem();
			cartItem.setProduct(product);
			cartItem.setNum(1);//Ĭ�ϵ�һ�������Ʒ����Ϊ1
			cartItem.setTotalPrice(1*product.getPrice());
			//��Ʒ���빺�ﳵ
			cart.put(product.getId(), cartItem);
			session.setAttribute("cart", cart);
			
		}else{
			//����Ѿ����˹��ﳵ�������ж��ǲ��ǵ�һ�����ﳵ�����Ʒ
			boolean b = cart.containsKey(product.getId());
			if(b){//����У�����ԭ�е���Ʒ���ﳵ�������ϼ�1
				CartItem cartItem=cart.get(product.getId());
				cartItem.setNum(cartItem.getNum()+1);
				cartItem.setTotalPrice((cartItem.getNum()+1)*product.getPrice());
				
			}else{//���û�У����һ���µĹ��ﳵ��
				//�齨���ﳵ��
				CartItem cartItem=new CartItem();
				cartItem.setProduct(product);
				cartItem.setNum(1);//Ĭ�ϵ�һ�������Ʒ����Ϊ1
				cartItem.setTotalPrice(1*product.getPrice());
				//��Ʒ���빺�ﳵ
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
