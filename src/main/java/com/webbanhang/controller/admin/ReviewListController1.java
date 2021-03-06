package com.webbanhang.controller.admin;

import com.webbanhang.model.Review;
import com.webbanhang.service.ReviewService;
import com.webbanhang.service.impl.ReviewServicesImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class ReviewListController1
 */
@WebServlet("/ReviewListController1")
public class ReviewListController1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ReviewService reviewService = new ReviewServicesImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewListController1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Review> reviewList = reviewService.getAll();
		request.setAttribute("reviewlist", reviewList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view/admin/show-review.jsp");
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
