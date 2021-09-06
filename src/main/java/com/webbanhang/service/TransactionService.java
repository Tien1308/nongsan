package com.webbanhang.service;

import com.webbanhang.model.Transactions;

import java.util.ArrayList;

public interface TransactionService {
	void insert(Transactions transaction);
	 
	void edit(Transactions transaction); 

	void delete(String id); 
 
	Transactions get(int id); 
	 
	Transactions get(String name); 
 
	ArrayList<Transactions> getAll(); 

}
