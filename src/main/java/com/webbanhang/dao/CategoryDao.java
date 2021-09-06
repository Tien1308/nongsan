package com.webbanhang.dao;

import com.webbanhang.model.Catalog;

import java.util.ArrayList;

public interface CategoryDao {
	void insert(Catalog category);

	void edit(Catalog category);

	void delete(String id);

	Catalog get(int id);
	
	Catalog get(String name);

	ArrayList<Catalog> getAll();
	
	ArrayList<Catalog> getCateByProduct(int id);

}
