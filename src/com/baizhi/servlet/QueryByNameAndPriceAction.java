package com.baizhi.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.baizhi.entity.Product;
import com.baizhi.service.ProductService;
import com.baizhi.service.ProductServiceImpl;

public class QueryByNameAndPriceAction extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String productName = request.getParameter("productName");
		
		String opt = request.getParameter("opt");
	
		String strprice = request.getParameter("price");

		ProductService service=new ProductServiceImpl();
	
		List<Product> list=new ArrayList<Product>();
		
		if(strprice==null && productName!=null){
			if(!(productName.isEmpty())){
				List<Product> listN = service.queryByName(productName);
				for(Product p:listN){
					list.add(p);
				}
			}
		}
		else if(strprice!=null && productName==null){
			if(!(strprice.isEmpty())){
				Double price=Double.valueOf(strprice);
				if(opt.equals("1")){
					List<Product> listX = service.queryByPriceX(price);
					for(Product p:listX){
						list.add(p);
					}
				}else if(opt.equals("2")){
					List<Product> listD = service.queryByPriceD(price);
					for(Product p:listD){
						list.add(p);
					}
				}
			}
		}
		else if(strprice!=null && productName!=null){
			if(!(strprice.isEmpty())){
				Double price=Double.valueOf(strprice);
				if(opt.equals("1")){
					List<Product> listN = service.queryByNameAndPriceX(productName, price);
					for(Product p:listN){
						list.add(p);
					}
				}else if(opt.equals("2")){
					List<Product> listN = service.queryByNameAndPriceD(productName, price);
					for(Product p:listN){
						list.add(p);
					}
				}
			}
		}
		request.setAttribute("list", list);
		request.getRequestDispatcher("/view/QueryProductView.jsp").forward(request, response);

	}
}
