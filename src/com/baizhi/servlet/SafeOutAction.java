package com.baizhi.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SafeOutAction extends HttpServlet{
	public void service(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
		HttpSession session=request.getSession(true);
		session.invalidate();
		response.sendRedirect("/shopping/view/LoginView.jsp");
	}
}
