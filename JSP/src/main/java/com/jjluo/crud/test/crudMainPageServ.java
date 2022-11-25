package com.jjluo.crud.test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/crudMainPageServ")
public class crudMainPageServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static String JDBC_DRIVER="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	public static String DB_URL = 
			"jdbc:sqlserver://localhost:1433;databaseName=jdbc;trustservercertificate=true";
	public static String USER = "sa";
	public static String PASSWORD = "passw0rd";	

	Connection conn;
//	JDBC_DRIVER="com.microsoft.sqlserver.jdbc.SQLServerDriver";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER ,PASSWORD);
			request.getRequestDispatcher("/mid/MainPage.jsp").forward(request, response);
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
