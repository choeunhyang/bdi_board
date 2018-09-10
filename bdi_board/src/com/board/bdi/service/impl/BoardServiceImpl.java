package com.board.bdi.service.impl;

import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.board.bdi.dao.BoardDAO;
import com.board.bdi.dao.impl.BoardDAOImpl;
import com.board.bdi.service.BoardService;

public class BoardServiceImpl implements BoardService {
	private BoardDAO bdao = new BoardDAOImpl();
	@Override
	public void insertBoard(HttpServletRequest request) throws SQLException, ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void selectBoard(HttpServletRequest request) throws SQLException, ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateBoard(HttpServletRequest request) throws SQLException, ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteBoard(HttpServletRequest request) throws SQLException, ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void selectBoardList(HttpServletRequest request) throws SQLException, ServletException {
		// TODO Auto-generated method stub
//		request.setAttribute("biList", bdao.selectBoardList(bi));
	}

}
