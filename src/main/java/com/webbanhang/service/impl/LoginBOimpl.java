package com.webbanhang.service.impl;

import com.webbanhang.dao.impl.LoginDao;
import com.webbanhang.model.User;
import com.webbanhang.service.LoginBO;

public class LoginBOimpl implements LoginBO {
	LoginDao loginDao = new LoginDao();
	public User checkLogin(String username, String password){
		return loginDao.checkLogin(username, password);
	}
}
