package com.baizhi.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.baizhi.entity.Product;
import com.baizhi.service.ProductService;
import com.baizhi.service.ProductServiceImpl;

public class FindByPageAction extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String strc = request.getParameter("currentPage");
		Integer currentPage =Integer.valueOf(strc);
		
		String strs = request.getParameter("pageSize");
		Integer pageSize =Integer.valueOf(strs);
		
		ProductService service=new ProductServiceImpl();
		List<Product> list = service.queryByPage(currentPage, pageSize);
		Integer totalPage=service.totalPageService(pageSize);
		
		request.setAttribute("list", list);
		request.setAttribute("totalPage", totalPage);
		request.getRequestDispatcher("/view/QueryProductView.jsp").forward(request, response);
	}
}
