package com.webbanhang.controller.admin;

import com.webbanhang.model.Transactions;
import com.webbanhang.service.TransactionService;
import com.webbanhang.service.impl.TransactionServicesImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class OrderListController1
 */
@WebServlet("/OrderListController1")
public class OrderListController1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TransactionService transactionService = new TransactionServicesImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderListController1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Transactions> transactionList = transactionService.getAll();
		request.setAttribute("order", transactionList); 
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view/admin/show-order.jsp"); 
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
