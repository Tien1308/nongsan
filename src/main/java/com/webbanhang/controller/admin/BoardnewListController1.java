package com.webbanhang.controller.admin;

import com.webbanhang.model.Boardnew;
import com.webbanhang.service.BoardnewService;
import com.webbanhang.service.impl.BoardnewServicesImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class BoardnewListController1
 */
@WebServlet("/BoardnewListController1")
public class BoardnewListController1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BoardnewService newService = new BoardnewServicesImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardnewListController1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("okokokok");
		
		List<Boardnew> boardnewList = newService.getAll();
		request.setAttribute("boardnewlist", boardnewList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view/admin/show-new.jsp");
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
