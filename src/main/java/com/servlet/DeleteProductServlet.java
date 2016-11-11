package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import facetory.ProductFactory;
import shopdemo.Product;

/**
 * Servlet implementation class DeleteProductServlet
 */
@WebServlet("/deleteProduct")
public class DeleteProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ProductFactory pf = new ProductFactory();
		int idp = Integer.parseInt(request.getParameter("id")) ;
		int newRow = Integer.parseInt(request.getParameter("newRow")) ;
		 response.setContentType("application/json");
	    response.setCharacterEncoding("utf-8");
	    boolean res = pf.deleteNewProductById(idp);
	    Product nextProduct = pf.getProductIndex(newRow);
	    String json = new Gson().toJson(nextProduct );
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
