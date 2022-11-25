package com.jjluo.crud.onepage;

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

@WebServlet("/ReadEmpOnepageServ")
public class ReadEmpOnepageServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Connection conn;
//	JDBC_DRIVER="com.microsoft.sqlserver.jdbc.SQLServerDriver";

	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		String sname = req.getParameter("namesearch");
		
		String JDBC_DRIVER="com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String DB_URL = 
				"jdbc:sqlserver://localhost:1433;databaseName=jdbc;trustservercertificate=true";
		String USER = "sa";
		String PASSWORD = "passw0rd";		
		String SQL = 
				"SELECT * FROM employee WHERE ename LIKE '%" + sname + "%' ";
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER ,PASSWORD);
			PreparedStatement stmt = conn.prepareStatement(SQL);
//			stmt.setString(1, ename);
			ResultSet rs = stmt.executeQuery();
			List<EmpsBean> emps = new ArrayList<>();
			EmpsBean emp = null;
			
			while(rs.next()) {
				emp = new EmpsBean();
				emp.setEmpno(rs.getString("empno"));
				emp.setEname(rs.getString("ename"));
				emp.setHiredate(rs.getString("hiredate"));
				emp.setSalary(rs.getString("salary"));
				emp.setDeptno(rs.getString("deptno"));
				emp.setTitle(rs.getString("title"));
				emps.add(emp);
			}
			

			req.setAttribute("searchemps", emps);
			stmt.close();
			req.getRequestDispatcher("/mid/GetSearchEmpsEnd.jsp").forward(req, res);		
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doGet(req, res);
	}
}
