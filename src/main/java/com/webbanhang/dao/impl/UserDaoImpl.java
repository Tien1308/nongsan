package com.webbanhang.dao.impl;

import com.webbanhang.connectionDB.ConnectionDB;
import com.webbanhang.dao.UserDao;
import com.webbanhang.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDaoImpl  implements UserDao {
	
	@Override
	public void insert(User user) {
		String sql = "INSERT INTO users(name,email,phone,username,password,created) VALUES (?, ?, ?, ?, ?, ?)";
		Connection con = ConnectionDB.openConnectionDB();

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, user.getName());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPhone());
			ps.setString(4, user.getUsername());
			ps.setString(5, user.getPassword());
			ps.setString(6,user.getCreated());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		String sql = "DELETE FROM users where id = ?";
		Connection con = ConnectionDB.openConnectionDB();

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public User get(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User get(int id) {
		User user = new User();
		String sql = "select * from users where id=?";
		Connection con = ConnectionDB.openConnectionDB();

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				user.setPhone(rs.getString("phone"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setCreated(rs.getString("created"));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

        return user;
	}
	
	@Override
	public void edit(User user) {	
		String sql = "Update users set name=?, email=?, phone=?, username=?, password=?, created=? where id=?";
		Connection con = ConnectionDB.openConnectionDB();

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, user.getName());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPhone());
			ps.setString(4, user.getUsername());
			ps.setString(5, user.getPassword());
			ps.setString(6,user.getCreated());
			ps.setInt(7,user.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public ArrayList<User> getAll() {		
		ArrayList<User> users = new ArrayList<User>();
		String sql = "SELECT * FROM users";
		Connection conn = ConnectionDB.openConnectionDB();

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				User user = new User();

				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				user.setPhone(rs.getString("phone"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setCreated(rs.getString("created"));
				users.add(user);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			
		}

		return users; 
	}

}


