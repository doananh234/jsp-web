package com.filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

import facetory.ProductFactory;
import facetory.UserFactory;
import shopdemo.User;


/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/LoginFilter")
public class LoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		String user = request.getParameter("username");
		String pass = request.getParameter("pass");
		System.out.println(pass );
//		ProductFactory pf = new ProductFactory();
//		Product p = pf.getById(2);
//		System.out.println(p.getName());
		UserFactory uf = new UserFactory();
		User _u = new User();
		HttpServletResponse res = (HttpServletResponse)response; 
		
		try {
			_u = uf.login(user, pass);
//			try {
//				if (_u == null) 
//			} catch (Exception e) {
//				// TODO: handle exception
//				res.sendRedirect("error.jsp");
//			}
			if (("null").equals(_u.toString().trim())) {
				res.sendRedirect("error.jsp");
				return;
			}
			if (_u.getRole().getId() == 3) {
				res.sendRedirect("adminPage.jsp");
			} else {
				res.sendRedirect("userPage.jsp");
			}
			return;
		} catch (Exception e) {
			// TODO: handle exception
			res.sendRedirect("error.jsp");
			return;
			
		}
		
//		 pass the request along the filter chain
//		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
//		System.out.println(fConfig.getInitParameter("username") );
	}

}
