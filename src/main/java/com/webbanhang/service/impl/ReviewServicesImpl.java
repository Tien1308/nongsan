package com.webbanhang.service.impl;

import com.webbanhang.dao.ReviewDao;
import com.webbanhang.dao.impl.ReviewDaoImpl;
import com.webbanhang.model.Review;
import com.webbanhang.service.ReviewService;

import java.util.ArrayList;

public class ReviewServicesImpl implements ReviewService {
	ReviewDao reviewDao = new ReviewDaoImpl();
	@Override
	public void insert(Review review) {
		reviewDao.insert(review);
		
	}

	@Override
	public void edit(Review review) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		reviewDao.delete(id);
	}

	@Override
	public Review get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Review get(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Review> getAll() {
		return reviewDao.getAll();
	}
	
	@Override
	public ArrayList<Review> getReviewById(int id) {
		return reviewDao.getReviewById(id);
	}

}
