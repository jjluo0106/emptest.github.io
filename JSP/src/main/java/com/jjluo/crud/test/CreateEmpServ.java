package com.jjluo.crud.test;
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

import com.lcpan.bean.EmpsBean;

@WebServlet("/CreateEmpServ")
public class CreateEmpServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Connection conn;
//	JDBC_DRIVER="com.microsoft.sqlserver.jdbc.SQLServerDriver";

	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		String empno = req.getParameter("empno");//敺�(頛詨)隢���澆�(�����)霈�
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
		String SQL = 
			"INSERT INTO  employee VALUES(?,?,?,?,?,?)";
//		(ename, hiredate, salary, deptno, title)
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER ,PASSWORD);//��蝺�
			PreparedStatement stmt = conn.prepareStatement(SQL);//����蝺����QL��征���
			stmt.setString(1, empno);//�stmt��etString�瘜��澆���蝛粹�葉
			stmt.setString(2, ename);
			stmt.setString(3, hiredate);
			stmt.setString(4, salary);
			stmt.setString(5, deptno);
			stmt.setString(6, title);
			stmt.executeUpdate();//��隞亙�澆�末敺��鞈�澈
//			ResultSet rs = stmt.executeQuery();
			EmpsBean emp = new EmpsBean();//��Bean��征���:����雿輻get set�銋����
			emp.setEname(ename);//���������EmpBean��et�瘜�Bean(甇文之撠神�������et set�撱�)
			emp.setEmpno(empno);
			emp.setHiredate(hiredate);
			emp.setSalary(salary);
			emp.setDeptno(deptno);
			emp.setTitle(title);
//			if(stmt.next()) {
//	
//				stmt.getString(1, empno);
//				emp.setEname(rs.getString("ename"));
//				emp.setHiredate(rs.getString("hiredate"));
//				emp.setSalary(rs.getString("salary"));
//				emp.setDeptno(rs.getString("deptno"));
//				emp.setTitle(rs.getString("title"));
//			}
			
//			System.out.println(emp.getEmpno());皜祈岫
			req.setAttribute("emptest", emp);//����葉閮剖�惇��:霈◤隢�����
			//�����葡�甇文���迂 敺�蝙���閬���
			stmt.close();//����蝛粹��
			req.getRequestDispatcher("/mid/UpdateEmpEnd.jsp").forward(req, res);	
			//霈�����甈�ㄐ敺��
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();//?
		}
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doGet(req, res);
	}
}
