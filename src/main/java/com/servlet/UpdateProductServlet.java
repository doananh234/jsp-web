package com.servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import facetory.ProductFactory;
import shopdemo.Product;

/**
 * Servlet implementation class UpdateProductServlet
 */
@WebServlet("/updateProduct")
public class UpdateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int idproduct = Integer.parseInt( request.getParameter("idproduct"));
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
		p.setIdproduct(idproduct);
		ProductFactory pf = new ProductFactory();
	    boolean res = pf.updateNewProduct(p);
	    response.getWriter().write(res?"true":"false");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
