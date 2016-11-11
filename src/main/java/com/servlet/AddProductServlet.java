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
 * Servlet implementation class AddProductServlet
 */
@WebServlet("/addProduct")
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		String price = request.getParameter("price");
		int quatity = Integer.parseInt(request.getParameter("quatity")) ;
		String info = request.getParameter("info");
		String img = request.getParameter("img");
		Product p = new Product();
		p.setName(name);
		p.setPrice(price);
		p.setImg(img);
		p.setInfo(info);
		p.setQuatity(quatity);
		
		ProductFactory pf = new ProductFactory();
	    Product res = pf.createNewProduct(p); 
	    String json = new Gson().toJson(res );
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
