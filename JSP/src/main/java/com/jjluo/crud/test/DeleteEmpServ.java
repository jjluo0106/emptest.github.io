package com.jjluo.crud.test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DeleteEmpServ")
public class DeleteEmpServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Connection conn;
//	JDBC_DRIVER="com.microsoft.sqlserver.jdbc.SQLServerDriver";

	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		String empno = req.getParameter("empno");
		
		String JDBC_DRIVER="com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String DB_URL = 
				"jdbc:sqlserver://localhost:1433;databaseName=jdbc;trustservercertificate=true";
		String USER = "sa";
		String PASSWORD = "passw0rd";		
		String SQL = 
				"DELETE employee WHERE empno = ?";
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER ,PASSWORD);
			PreparedStatement stmt = conn.prepareStatement(SQL);
			stmt.setString(1, empno);
			stmt.executeUpdate();

			req.setAttribute("emp", empno);
			stmt.close();
			req.getRequestDispatcher("/mid/DeleteEmpEnd.jsp").forward(req, res);		
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doGet(req, res);
	}
}
