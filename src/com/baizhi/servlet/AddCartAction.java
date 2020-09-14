package com.baizhi.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.baizhi.service.CartService;
import com.baizhi.service.CartServiceImpl;

public class AddCartAction extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String strId = request.getParameter("id");
		Integer id=Integer.valueOf(strId);
		CartService service=new CartServiceImpl();
		service.addCart(id, request);
		
		response.sendRedirect("/shopping/view/AddCarSuccess.jsp");
		
	}
}
