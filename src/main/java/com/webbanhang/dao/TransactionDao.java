package com.webbanhang.dao;

import com.webbanhang.model.Transactions;

import java.util.ArrayList;


public interface TransactionDao {
	void insert(Transactions transaction);
	 
	void edit(Transactions admin); 
	
	void delete(String id); 
 
	Transactions get(int id); 
	 
	Transactions get(String name); 
 
	ArrayList<Transactions> getAll(); 
	
	
}
