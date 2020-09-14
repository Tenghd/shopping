package com.baizhi.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import com.baizhi.service.UserServiceImpl;

public class ChangeUserMessageAction extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String strzip = request.getParameter("zip");
		Integer zip =Integer.valueOf(strzip);
		UserService service=new UserServiceImpl();
		User user=new User(username,password,name,zip,address);
		service.updateByUser(user);
		response.sendRedirect("/shopping/view/ChangeUserMessageSuccess.jsp");
		
	}
}
