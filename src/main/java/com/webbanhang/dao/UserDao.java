package com.webbanhang.dao;

import com.webbanhang.model.User;

import java.util.ArrayList;

public interface UserDao {
	
	void insert(User user);

	void edit(User user);
	
	void delete(int id);

	User get(String name);

	User get(int id);
	
	ArrayList<User> getAll();
}
