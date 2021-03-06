package com.webbanhang.controller.admin;

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
import java.util.List;

/**
 * Servlet implementation class ProductAddController1
 */
@WebServlet("/ProductAddController1")
public class ProductAddController1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CategoryService cateService = new CategoryServicesImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductAddController1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Catalog> cateList = cateService.getAll();
		request.setAttribute("catelist", cateList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view/admin/addproduct.jsp"); 
		dispatcher.forward(request, response); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		String product_cate = request.getParameter("product-cate");
		String product_name = request.getParameter("product-name");
		String product_price = request.getParameter("product-price");
		String product_status = request.getParameter("product-status");
		String product_desc = request.getParameter("product-desc");
		String product_content = request.getParameter("product-content");
		String product_discount = request.getParameter("product-discount");
		String product_image = request.getParameter("product-image");
		String product_day = request.getParameter("product-day");

		Product product = new Product();
		product.setCatalog_id(product_cate);
		product.setName(product_name);
		product.setPrice(product_price);
		product.setStatus(product_status);
		product.setDescription(product_desc);
		product.setContent(product_content);
		product.setDiscount(product_discount);
		product.setImage_link(product_image);
		product.setCreated(product_day);
		
		ProductService productService = new ProductServiceImpl();
		
		List<Product> productList = null;
		productService.insert(product);
		productList = productService.getAll(); 
		
		
		request.setAttribute("productlist", productList); 
//		response.sendRedirect(request.getContextPath() + "/list_nv.jsp"); 
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view/admin/show-product.jsp"); 
		dispatcher.forward(request, response); 
	}

}
