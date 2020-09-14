
package com.baizhi.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SafeFilter implements Filter {
	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {
		HttpServletRequest hq = (HttpServletRequest) request;
		HttpServletResponse hp = (HttpServletResponse) response;
		HttpSession session = hq.getSession();
		Object flag = session.getAttribute("user");
		if (flag != null) {
			// 让请求继续向下执行
			filterChain.doFilter(request, response);
		} else {
			hp.sendRedirect("/shopping/view/LoginView.jsp");
		}

	}

	@Override
	public void init(FilterConfig config) throws ServletException {
	
	}

}
