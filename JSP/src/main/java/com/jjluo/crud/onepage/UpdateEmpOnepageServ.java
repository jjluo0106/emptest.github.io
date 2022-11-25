package com.jjluo.crud.onepage;

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
import javax.servlet.http.HttpSession;

@WebServlet("/UpdateEmpOnepageServ")
public class UpdateEmpOnepageServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Connection conn;
//	JDBC_DRIVER="com.microsoft.sqlserver.jdbc.SQLServerDriver";

	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		String empno = req.getParameter("empno");
		String ename = req.getParameter("ename");
		String hiredate = req.getParameter("hiredate");
		String salary = req.getParameter("salary");
		String dname = req.getParameter("deptno");
		String title = req.getParameter("title");
		
		String JDBC_DRIVER="com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String DB_URL = 
				"jdbc:sqlserver://localhost:1433;databaseName=jdbc;trustservercertificate=true";
		String USER = "sa";
		String PASSWORD = "passw0rd";		
		String SQL = 
				"UPDATE [dbo].[employee] SET ename = ?, hiredate = ?, salary = ?, deptno = ?, title = ? WHERE empno = ?";
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER ,PASSWORD);
			PreparedStatement stmt = conn.prepareStatement(SQL);
			stmt.setString(6, empno);
			stmt.setString(1, ename);
			stmt.setString(2, hiredate);
			stmt.setString(3, salary);
			stmt.setString(4, dname);
			stmt.setString(5, title);
			stmt.executeUpdate();

			
			stmt.close();
			HttpSession session = req.getSession();
			res.sendRedirect("/JSP/GetAllEmpsServ");	
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doGet(req, res);
	}
}
