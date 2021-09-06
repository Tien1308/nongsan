package com.webbanhang.service.impl;

import com.webbanhang.dao.BoardnewDao;
import com.webbanhang.dao.impl.BoardnewDaoImpl;
import com.webbanhang.model.Boardnew;
import com.webbanhang.service.BoardnewService;

import java.util.ArrayList;

public class BoardnewServicesImpl implements BoardnewService {
	BoardnewDao boardnewDao = new BoardnewDaoImpl();

	@Override
	public void insert(Boardnew boardnew) {
		// TODO Auto-generated method stub
		boardnewDao.insert(boardnew);
	}

	@Override
	public void edit(Boardnew newBoardnew) {
		// TODO Auto-generated method stub
		Boardnew oldBoardnew = boardnewDao.get(Integer.parseInt(newBoardnew.getId()));
		System.out.println("xem thử có chưa "+oldBoardnew);
		oldBoardnew.setTitle(newBoardnew.getTitle());
		oldBoardnew.setContent(newBoardnew.getContent());
		oldBoardnew.setImage_link(newBoardnew.getImage_link());
		oldBoardnew.setAuthor(newBoardnew.getAuthor());
		oldBoardnew.setCreated(newBoardnew.getCreated());
		boardnewDao.edit(oldBoardnew);
	}
	
	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		boardnewDao.delete(id);
	}

	@Override
	public Boardnew get(int id) {
		return boardnewDao.get(id);
	}

	@Override
	public Boardnew get(String name) {
		return boardnewDao.get(name);
	}

	@Override
	public ArrayList<Boardnew> getAll() {
		return boardnewDao.getAll();
	}

}
