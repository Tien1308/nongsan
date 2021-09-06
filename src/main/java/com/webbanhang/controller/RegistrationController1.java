package com.webbanhang.controller;

import com.webbanhang.connectionDB.ConnectionDB;
import com.webbanhang.dao.impl.RegisterDao;
import com.webbanhang.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class RegistrationController1
 */
@WebServlet("/RegistrationController1")
public class RegistrationController1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationController1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String name = request.getParameter("name");
		String created = request.getParameter("created");

		System.out.println(name);
		User user = new User(username, password, email, phone, name, created);

		RegisterDao register = new RegisterDao(ConnectionDB.openConnectionDB());
		if (register.RegisterUser(user)) // On success, you can display a message to user on Home page
		{
			request.setAttribute("Message", "Ban tao tai khoan thanh cong moi ban dang nhap vao <a href='/ttcn/view/client/login.jsp'>tai day!</a>");
			RequestDispatcher rd = request.getRequestDispatcher("/view/client/register.jsp");
			rd.forward(request, response);
		} else {
			request.setAttribute("errMessage", "Tai khoan bi trung. Nhap Lai !!!");
			RequestDispatcher rd = request.getRequestDispatcher("/view/client/register.jsp");
			rd.forward(request, response);
		}
	}

}
