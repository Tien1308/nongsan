package com.webbanhang.service;

import com.webbanhang.dao.impl.LoginDao;
import com.webbanhang.model.User;

public interface LoginBO {
	LoginDao loginDao = new LoginDao();
	public User checkLogin(String username, String password) ;
		
}
