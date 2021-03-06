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
import java.util.List;



/**
 * Servlet implementation class AdminEditController1
 */
@WebServlet("/AdminEditController1")
public class AdminEditController1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AdminService adminService = new AdminServicesImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminEditController1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int admin_id= Integer.parseInt(request.getParameter("admin-id"));
		Admin admin = null;
		admin = adminService.get(admin_id);
		request.setAttribute("admin", admin);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view/admin/editadmin.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		int admin_id = Integer.parseInt(request.getParameter("id"));
		String admin_username = request.getParameter("username");
		String admin_password = request.getParameter("password");
		String admin_name = request.getParameter("name");	
		
		System.out.println(admin_username);
		System.out.println(admin_password);
		System.out.println(admin_name);
		
		Admin admin = new Admin();
		admin.setId(admin_id);
		admin.setUsername(admin_username);
		admin.setPassword(admin_password);
		admin.setName(admin_name);
		
		
		List<Admin> adminList = null;
		adminService.edit(admin);
		adminList = adminService.getAll();
		request.setAttribute("adminlist", adminList); 
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view/admin/admin.jsp"); 
		dispatcher.forward(request, response); 
	}

}
