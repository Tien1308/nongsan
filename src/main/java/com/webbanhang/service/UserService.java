package com.webbanhang.service;

import com.webbanhang.model.User;

import java.util.ArrayList;
public interface UserService {
	
void insert(User user);
	
	void edit(User user);
	
	void delete(int id);
	
	User get(int id);
	
	User get(String name);

	ArrayList<User> getAll();

}

