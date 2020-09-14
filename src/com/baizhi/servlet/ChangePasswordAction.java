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

public class ChangePasswordAction extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session=request.getSession();
		User user1 = (User) session.getAttribute("user");
		String oldPass = request.getParameter("oldPass");
		String newPass1 = request.getParameter("newPass1");
		String newPass2 = request.getParameter("newPass2");
		User user=new User(user1.getUsername(),newPass1,user1.getName(),user1.getZip(),user1.getAddress());
		UserService service=new UserServiceImpl();
		service.updateByUser(user);
		if(newPass1.equals(newPass2)){
			response.sendRedirect("/shopping/view/ChangePasswordSuccess.jsp");
		}else{
			String encode = URLEncoder.encode("两次密码不一致！","UTF-8");
			response.sendRedirect("/shopping/view/ChangePasswordView.jsp?errorMsg="+encode);
		}
	}
}
