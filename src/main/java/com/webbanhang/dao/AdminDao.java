package com.webbanhang.dao;

import com.webbanhang.model.Admin;

import java.util.ArrayList;
 
public interface AdminDao { 
	void insert(Admin admin);
 
	void edit(Admin admin); 
	
	void delete(String id); 
 
	Admin get(int id); 
	 
	Admin get(String name); 
 
	ArrayList<Admin> getAll(); 
	
} 
