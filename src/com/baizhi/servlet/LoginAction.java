package com.baizhi.servlet;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import com.baizhi.service.UserServiceImpl;

public class LoginAction extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		UserService service= new UserServiceImpl();
		User user = service.selectUser(username, password);
		//模拟用户登陆成功，获取session标记
		HttpSession session=request.getSession();
		if(user!=null){
			session.setAttribute("user", user);
			response.sendRedirect("/shopping/a/FindByPageAction?currentPage=1&pageSize=2");
		}else{
			String encode = URLEncoder.encode("用户名或密码错误！","UTF-8");
			response.sendRedirect("/shopping/view/LoginView.jsp?errorMsg="+encode);
		}
	}
}
