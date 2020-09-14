package com.baizhi.servlet;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import com.baizhi.service.UserServiceImpl;

public class AddProductAction extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String pass1 = request.getParameter("pass1");
		String pass2 = request.getParameter("pass2");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String strz = request.getParameter("zip");
		Integer zip=Integer.valueOf(strz);
		User user=new User(username,pass1,name,zip,address);
		UserService service=new UserServiceImpl();
		service.insertUser(user);
		if(pass1.equals(pass2)){
			response.sendRedirect("/shopping/view/LoginView.jsp");
		}else{
			String encode=URLEncoder.encode("ÃÜÂë²»Ò»ÖÂ£¡","UTF-8");
			response.sendRedirect("/shopping/view/CreateUserView.jsp?errorMsg="+encode);
		}
	}
}
