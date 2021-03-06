package com.webbanhang.controller.admin;

import com.webbanhang.model.Admin;
import com.webbanhang.service.AdminService;
import com.webbanhang.service.impl.AdminServicesImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Servlet implementation class AdminAddController1
 */
@WebServlet("/AdminAddController1")
public class AdminAddController1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AdminService adminService = new AdminServicesImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminAddController1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		String admin_username = request.getParameter("admin-username"); 
		String admin_password = request.getParameter("admin-password"); 
		String admin_name = request.getParameter("admin-name");
		System.out.println(admin_name);
		System.out.println(admin_username);
		System.out.println(admin_password);
		Admin admin = new Admin();
		admin.setUsername(admin_username); 
		admin.setPassword(admin_password); 
		admin.setName(admin_name); 
		
		ArrayList<Admin> adminList = null;
		adminService.insert(admin); 
		adminList= adminService.getAll();
		
		request.setAttribute("adminlist", adminList); 
//		response.sendRedirect(request.getContextPath() + "/list_nv.jsp"); 
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view/admin/admin.jsp"); 
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
