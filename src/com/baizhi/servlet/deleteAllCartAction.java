package com.baizhi.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.baizhi.service.CartService;
import com.baizhi.service.CartServiceImpl;

public class deleteAllCartAction extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String[] ids = request.getParameterValues("ids");
		List<Integer> list=new ArrayList();
		if(ids!=null){
			for(String strId:ids){
				Integer id=Integer.valueOf(strId);
				list.add(id);
			}
		}
		CartService service=new CartServiceImpl();
		service.deletAllCart(list, request);
		response.sendRedirect("/shopping/view/ShopCarView.jsp");
	}
}
