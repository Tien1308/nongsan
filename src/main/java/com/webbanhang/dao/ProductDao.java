package com.webbanhang.dao;

import com.webbanhang.model.Product;

import java.util.ArrayList;

public interface ProductDao {
	void insert(Product product);

	void edit(Product product);

	void delete(String id);

	Product get(int id);
	
	Product get(String name);

	ArrayList<Product> getAll();
	
	ArrayList<Product> getProductById(int id);

	ArrayList<Product> searchByName(String productName);


}
