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

@WebServlet("/GetAllEmpsServ")
public class GetAllEmpsServ extends HttpServlet {
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
			
		String SQL = "SELECT [dbo].[employee].empno, [dname] ,[ename] ,[hiredate] ,[salary],[title]\r\n"
				+ "FROM [dbo].[department] \r\n"
				+ "FULL OUTER JOIN [dbo].[employee]\r\n"
				+ "ON [dbo].[department].[deptno] = [dbo].[employee].[deptno] order by empno";
		
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER ,PASSWORD);
			PreparedStatement stmt = conn.prepareStatement(SQL);
			ResultSet rs = stmt.executeQuery();
			List<EmpsBean> emps = new ArrayList<>();
			EmpsBean emp = null;
			while (rs.next()) {
				
				emp = new EmpsBean();
				emp.setEmpno(rs.getString("empno"));
				emp.setEname(rs.getString("ename"));
				emp.setHiredate(rs.getString("hiredate"));
				emp.setSalary(rs.getString("salary"));
				emp.setDeptno(rs.getString("dname"));
				emp.setTitle(rs.getString("title"));
				emps.add(emp);
			}
			request.setAttribute("emps", emps);
			stmt.close();
			request.getRequestDispatcher("/mid/GetAllEmpsEnd.jsp").forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
