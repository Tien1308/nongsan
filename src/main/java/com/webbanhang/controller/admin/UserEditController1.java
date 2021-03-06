package com.webbanhang.controller.admin;

import com.webbanhang.model.User;
import com.webbanhang.service.UserService;
import com.webbanhang.service.impl.UserServicesImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class UserEditController1
 */
@WebServlet("/UserEditController1")
public class UserEditController1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserService userService = new UserServicesImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserEditController1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int user_id = Integer.parseInt(request.getParameter("user-id"));
		User user =null;
		user = userService.get(user_id);
		request.setAttribute("user", user);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view/admin/edituser.jsp");
		dispatcher.forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		
		
		int user_id = Integer.parseInt(request.getParameter("user-id"));
		
		String user_name = request.getParameter("user-name");
		String user_email = request.getParameter("user-email");
		String user_phone = request.getParameter("user-phone");
		String user_userName = request.getParameter("user-userName");
		String user_password = request.getParameter("user-password");
		String user_created = request.getParameter("user-created");
		
		
		User user = new User();
		user.setName(user_name);
		user.setEmail(user_email);
		user.setPhone(user_phone);
		user.setUsername(user_userName);
		user.setPassword(user_password);
		user.setCreated(user_created);
		user.setId(user_id);
		
		
		List<User> userList = null;
		userService.edit(user);
		userList= userService.getAll();
		request.setAttribute("userlist", userList); 
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view/admin/user.jsp"); 
		dispatcher.forward(request, response); 
	}

}
