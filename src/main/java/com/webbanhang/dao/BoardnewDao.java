package com.webbanhang.dao;

import com.webbanhang.model.Boardnew;

import java.util.ArrayList;

public interface BoardnewDao {
	void insert(Boardnew boardnew);

	void edit(Boardnew boardnew);

	void delete(int id);

	Boardnew get(int id);
	
	Boardnew get(String name);

	ArrayList<Boardnew> getAll();
}
