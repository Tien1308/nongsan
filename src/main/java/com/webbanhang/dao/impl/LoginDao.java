package com.webbanhang.dao.impl;

import com.webbanhang.connectionDB.ConnectionDB;
import com.webbanhang.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDao {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public User checkLogin(String username, String password) {
		try {
			String query = "select username, password from ttcn.users where username = ? AND password = ?";
			Connection conn = ConnectionDB.openConnectionDB();
			ps = conn.prepareStatement(query);
			ps.setString(1, username);
			ps.setString(2, password);
			rs = ps.executeQuery();
			while(rs.next()) {
				User u = new User(rs.getString(1), rs.getString(2));
				return u;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
}
