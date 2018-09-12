package com.board.bdi.service;

import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

public interface BoardService {
	public void insertBoard(HttpServletRequest request) throws SQLException, ServletException;
	public void selectBoard(HttpServletRequest request) throws SQLException, ServletException;
	public void updateBoard(HttpServletRequest request) throws SQLException, ServletException;
	public void deleteBoard(HttpServletRequest request) throws SQLException, ServletException;
	public void selectBoardList(HttpServletRequest request) throws SQLException, ServletException;
	
	public void selectCommentList(HttpServletRequest request) throws SQLException, ServletException;
	public void selectComment(HttpServletRequest request) throws SQLException, ServletException;
	public void insertComment(HttpServletRequest request) throws SQLException, ServletException;
	public void deleteComment(HttpServletRequest request) throws SQLException, ServletException;
}
