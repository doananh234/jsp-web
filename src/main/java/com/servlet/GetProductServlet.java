package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import facetory.ProductFactory;
import shopdemo.Product;

/**
 * Servlet implementation class GetProductServlet
 */
@WebServlet("/GetProduct")
public class GetProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int pageIndex =  Integer.parseInt(request.getParameter("pageIndex"));
		int limit = Integer.parseInt(request.getParameter("limit"));
		ProductFactory pf = new ProductFactory();
		
		List<Product> lProduct = pf.getPaging(pageIndex, limit);
		String json = new Gson().toJson(lProduct );
		System.out.println(json);
		 response.setContentType("application/json");
	    response.setCharacterEncoding("utf-8");
	    response.getWriter().write(json);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
