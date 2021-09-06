package com.webbanhang.dao;

import com.webbanhang.model.Ordered;

import java.util.ArrayList;

public interface OrderedDao {
	void insert(Ordered ordered);
	 
	void edit(Ordered ordered); 
	
	void delete(String id); 
 
	Ordered get(int id); 
	 
	Ordered get(String name); 
 
	ArrayList<Ordered> getAll();
}
