package com.jjluo.crud.test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lcpan.bean.EmpsBean;

@WebServlet("/UpdateEmpServ")
public class UpdateEmpServ extends HttpServlet {
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
			
		String SQL = "UPDATE employee SET salary = ? WHERE ename = ?";
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER ,PASSWORD);
			PreparedStatement stmt = conn.prepareStatement(SQL);
			
			stmt.setString(1, request.getParameter("salary") );
			stmt.setString(2, request.getParameter("ename"));
			stmt.executeUpdate();

			stmt.close();
			request.getRequestDispatcher("/mid/UpdateEmpEnd.jsp").forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
