package com.webbanhang.service.impl;


import com.webbanhang.dao.CategoryDao;
import com.webbanhang.dao.impl.CategoryDaoImpl;
import com.webbanhang.model.Catalog;
import com.webbanhang.service.CategoryService;

import java.util.ArrayList;
import java.util.List;

public class CategoryServicesImpl implements CategoryService {
	CategoryDao categoryDao = new CategoryDaoImpl();

	@Override
	public void insert(Catalog category) {
		categoryDao.insert(category);
	}

	@Override
	public void edit(Catalog newCategory) {
		Catalog oldCate = categoryDao.get(Integer.parseInt(newCategory.getId()));
		oldCate.setName(newCategory.getName());
		oldCate.setParent_id(newCategory.getParent_id());
		categoryDao.edit(oldCate);

	}

	@Override
	public void delete(String id) {
		categoryDao.delete(id);

	}

	@Override
	public Catalog get(int id) {
		return categoryDao.get(id);
	}

	@Override
	public Catalog get(String name) {
		return categoryDao.get(name);
	}

	@Override
	public List<Catalog> getAll() {
		return categoryDao.getAll();
	}
	
	
	public ArrayList<Catalog> getCateByProduct(int id) {
		return categoryDao.getCateByProduct(id);
	}

}