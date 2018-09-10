package com.board.bdi.service;

import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

public interface UserService {
	public void joinUser(HttpServletRequest request) throws SQLException, ServletException;
	public void loginUser(HttpServletRequest request) throws SQLException, ServletException;
	public void logoutUser(HttpServletRequest request) throws SQLException, ServletException;
	public void deleteUser(HttpServletRequest request) throws SQLException, ServletException;
	public void userList(HttpServletRequest request) throws SQLException, ServletException;
}
