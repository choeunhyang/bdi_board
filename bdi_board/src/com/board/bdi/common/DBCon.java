package com.board.bdi.common;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBCon {
	private static Properties prop;
	private static Connection con;
	static {// 호출을 하든 안하든 딱 한번만 실행됨.
		prop = new Properties();
		String path = "/config/db.properties";
		InputStream is = DBCon.class.getResourceAsStream(path);
		try {
			prop.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Connection getCon() {
		if (con == null) {
			try {
				Class.forName(prop.getProperty("driver"));
				con = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("id"), prop.getProperty("pwd"));
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return con;
	}
	public static void close() {
		if(con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}con = null;
	}
	public static void main(String[] args) {
		getCon();
		close();
	}
}
