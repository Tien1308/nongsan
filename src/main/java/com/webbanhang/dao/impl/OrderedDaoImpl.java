package com.webbanhang.dao.impl;

import com.webbanhang.connectionDB.ConnectionDB;
import com.webbanhang.dao.OrderedDao;
import com.webbanhang.model.Ordered;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderedDaoImpl implements OrderedDao {

	@Override
	public void insert(Ordered ordered) {
		String sql = "INSERT INTO ordered(product_id, transaction_id,qty) VALUES (?, ?, ?)";
		Connection con = ConnectionDB.openConnectionDB();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, Integer.parseInt(ordered.getProduct_id()));
			ps.setInt(2, Integer.parseInt(ordered.getTransaction_id()));
			ps.setInt(3, ordered.getQty());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
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
		ArrayList<Ordered> ordereds = new ArrayList<Ordered>();
		String sql = "SELECT * FROM ordered";
		Connection con = ConnectionDB.openConnectionDB();
		try {
			PreparedStatement ps = con.prepareStatement(sql); 
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				Ordered ordered = new Ordered();
				ordered.setId(rs.getString("id"));
				ordered.setProduct_id(rs.getString("product_id"));
				ordered.setTransacsion_id(rs.getString("transaction_id"));
				ordered.setQty(Integer.parseInt(rs.getString("qty")));
				ordereds.add(ordered);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ordereds;
	}

}
