package com.webbanhang.controller.admin;

import com.webbanhang.service.ProductService;
import com.webbanhang.service.impl.ProductServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class ProductDeleteController1
 */
@WebServlet("/ProductDeleteController1")
public class ProductDeleteController1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProductService productService = new ProductServiceImpl();
    
    public ProductDeleteController1() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		productService.delete(id);
		request.setAttribute("productlist", productService.getAll());	
		
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view/admin/show-product.jsp"); 
		dispatcher.forward(request, response); 
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
