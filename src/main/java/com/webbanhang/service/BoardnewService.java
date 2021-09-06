package com.webbanhang.service;

import com.webbanhang.model.Boardnew;

import java.util.ArrayList;

public interface BoardnewService {
	void insert(Boardnew boardnew);

	void edit(Boardnew boardnew);

	void delete(int id);

	Boardnew get(int id);
	
	Boardnew get(String name);

	ArrayList<Boardnew> getAll();

}
