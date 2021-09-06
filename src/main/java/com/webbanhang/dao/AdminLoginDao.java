package com.webbanhang.dao;


import com.webbanhang.connectionDB.ConnectionDB;
import com.webbanhang.model.Admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;




public class  AdminLoginDao {
	public static boolean checkAdminLogin (String username, String password) {
		boolean exist = false;
		try {

			String sql = "select * from admin where username=? and password=?";
			Connection con = ConnectionDB.openConnectionDB();
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, username);
			st.setString(2, password);
			ResultSet rs;
			rs = st.executeQuery();
		    exist = rs.next();
		    Admin admin = new Admin();
		    String name = rs.getString("name");
		    admin.setName(name);
		    } catch (Exception e) {
			e.printStackTrace();
		}
		return exist;
	}

}
