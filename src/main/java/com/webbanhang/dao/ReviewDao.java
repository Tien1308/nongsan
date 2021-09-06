package com.webbanhang.dao;

import com.webbanhang.model.Review;

import java.util.ArrayList;

public interface ReviewDao {
	void insert(Review review);

	void edit(Review review);

	void delete(int id);

	Review get(int id);
	
	Review get(String name);

	ArrayList<Review> getAll();
	
	ArrayList<Review> getReviewById(int id);
}
