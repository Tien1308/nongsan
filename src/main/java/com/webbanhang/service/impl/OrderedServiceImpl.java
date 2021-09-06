package com.webbanhang.service.impl;

import com.webbanhang.dao.OrderedDao;
import com.webbanhang.dao.impl.OrderedDaoImpl;
import com.webbanhang.model.Ordered;
import com.webbanhang.service.OrderedService;

import java.util.ArrayList;

public class OrderedServiceImpl implements OrderedService {
	OrderedDao orderDao = new OrderedDaoImpl();
	@Override
	public void insert(Ordered ordered) {
		orderDao.insert(ordered);
	}

	@Override
	public void edit(Ordered ordered) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Ordered get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ordered get(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Ordered> getAll() {
		return orderDao.getAll();
	}

}
