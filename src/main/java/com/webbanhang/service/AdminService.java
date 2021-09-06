package com.webbanhang.service;

import com.webbanhang.model.Admin;

import java.util.ArrayList;
public interface AdminService { 
	void insert(Admin admin);
 
	void edit(Admin admin); 

	void delete(String id); 
 
	Admin get(int id); 
	 
	Admin get(String name); 
 
	ArrayList<Admin> getAll(); 
 
} 
