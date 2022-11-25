package com.jjluo.crud.onepage;
//�憓洵鈭��
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

import com.lcpan.bean.EmpsBean;

@WebServlet("/CreateEmpOnepageServ")
public class CreateEmpOnepageServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Connection conn;
//	JDBC_DRIVER="com.microsoft.sqlserver.jdbc.SQLServerDriver";

	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		String empno = req.getParameter("empno");
		String ename = req.getParameter("ename");
		String hiredate = req.getParameter("hiredate");
		String salary = req.getParameter("salary");
		String deptno = req.getParameter("deptno");
		String title = req.getParameter("title");
		String JDBC_DRIVER="com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String DB_URL = 
			"jdbc:sqlserver://localhost:1433;databaseName=jdbc;trustservercertificate=true";
		String USER = "sa";
		String PASSWORD = "passw0rd";	
		String SQL1= "UPDATE employee SET salary = ? WHERE ename = ?";
		String SQL2 = 
			"INSERT INTO  employee VALUES(?,?,?,?,?,?)";
		
		
		
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER ,PASSWORD);//��蝺�
			PreparedStatement stmt = conn.prepareStatement(SQL2);
			stmt.setString(1, empno);
			stmt.setString(2, ename);
			stmt.setString(3, hiredate);
			stmt.setString(4, salary);
			stmt.setString(5, deptno);
			stmt.setString(6, title);
			stmt.executeUpdate();
			EmpsBean emp = new EmpsBean();
			emp.setEname(ename);
			emp.setEmpno(empno);
			emp.setHiredate(hiredate);
			emp.setSalary(salary);
			emp.setDeptno(deptno);
			emp.setTitle(title);
			req.setAttribute("emptest", emp);
			stmt.close();
			
			HttpSession session = req.getSession();
			res.sendRedirect("/JSP/GetAllEmpsServ");
//			req.getRequestDispatcher("/JSP/GetAllEmpsServ").forward(req, res);	
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();//?
		}
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doGet(req, res);
	}
}
