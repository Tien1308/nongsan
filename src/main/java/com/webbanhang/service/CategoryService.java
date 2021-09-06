package com.webbanhang.service;

import com.webbanhang.model.Catalog;

import java.util.ArrayList;
import java.util.List;
public interface CategoryService {
	void insert(Catalog category);

	void edit(Catalog category);

	Catalog get(int id);
	
	Catalog get(String name);

	List<Catalog> getAll();

	void delete(String id);
	
	ArrayList<Catalog> getCateByProduct(int id);

}

