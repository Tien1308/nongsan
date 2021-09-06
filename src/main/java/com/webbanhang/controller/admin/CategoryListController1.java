package com.webbanhang.controller.admin;

import com.webbanhang.model.Catalog;
import com.webbanhang.service.CategoryService;
import com.webbanhang.service.impl.CategoryServicesImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class CategoryListController1
 */
@WebServlet("/CategoryListController1")
public class CategoryListController1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CategoryService cateService = new CategoryServicesImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryListController1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Catalog> cateList = cateService.getAll();
		request.setAttribute("catelist", cateList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view/admin/show-cate.jsp"); 
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
