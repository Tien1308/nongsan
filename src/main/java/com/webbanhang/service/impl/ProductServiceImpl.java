package com.webbanhang.service.impl;


import com.webbanhang.dao.ProductDao;
import com.webbanhang.dao.impl.ProductDaoImpl;
import com.webbanhang.model.Product;
import com.webbanhang.service.ProductService;

import java.util.ArrayList;

public class ProductServiceImpl implements ProductService {
	ProductDao productDao = new ProductDaoImpl();

	@Override
	public void insert(Product product) {
		productDao.insert(product);
	}

	@Override
	public void edit(Product newProduct) {
		Product oldProduct = productDao.get(Integer.parseInt(newProduct.getId()));
		oldProduct.setName(newProduct.getName());
		oldProduct.setCatalog_id(newProduct.getCatalog_id());
		oldProduct.setStatus(newProduct.getStatus());
		oldProduct.setPrice(newProduct.getPrice());
		oldProduct.setDescription(newProduct.getDescription());
		oldProduct.setContent(newProduct.getContent());
		oldProduct.setDiscount(newProduct.getDiscount());
		oldProduct.setImage_link(newProduct.getImage_link());
		oldProduct.setCreated(newProduct.getCreated());

		productDao.edit(oldProduct);

	}

	@Override
	public void delete(String id) {
		productDao.delete(id);

	}

	@Override
	public Product get(int id) {
		return productDao.get(id);
	}

	@Override
	public Product get(String name) {
		return productDao.get(name);
	}

	@Override
	public ArrayList<Product> getAll() {
		return productDao.getAll();
	}

	@Override
	public ArrayList<Product> getProductById(int id) {
		return productDao.getProductById(id);
	}
	
	@Override
	public ArrayList<Product> searchByName(String productName) {
		return productDao.searchByName(productName);
	}

	@Override
	public ArrayList<Product> getProductByIdCate(int idCate) {
		// TODO Auto-generated method stub
		return null;
	}



}