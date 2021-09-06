package com.webbanhang.controller;

import com.webbanhang.model.Catalog;
import com.webbanhang.model.Product;
import com.webbanhang.service.CategoryService;
import com.webbanhang.service.ProductService;
import com.webbanhang.service.impl.CategoryServicesImpl;
import com.webbanhang.service.impl.ProductServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet implementation class ProductListClientController1
 */
@WebServlet("/ProductListClientController1")
public class ProductListClientController1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CategoryService cateService = new CategoryServicesImpl();
	ProductService productService = new ProductServiceImpl();
	DecimalFormat df = new DecimalFormat("#.000");   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductListClientController1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String id = req.getParameter("id");
		System.out.println("okokokok");
		List<Catalog> cateList = cateService.getAll();
		request.setAttribute("catelist", cateList);
		List<Product> productList = productService.getAll();
		request.setAttribute("productlist", productList);
		//Giá giảm
		List<Product> productsList1 = new ArrayList<Product>();
		for(Product product: productList)
		{
			Product product1 = productService.get(Integer.parseInt(product.getId()));
			product1.setPrice(String.valueOf(df.format(Double.parseDouble(product.getPrice()) * (1 - (Double.parseDouble(product.getDiscount())/100)))));
			productsList1.add(product1);
			
		}

		request.setAttribute("productlist1", productsList1);
		// Product bán chạy
		List<Product> product_banchay= productService.getProductById(6);
		request.setAttribute("product_banchay", product_banchay);	
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view/client/product.jsp"); 
		dispatcher.forward(request, response); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
