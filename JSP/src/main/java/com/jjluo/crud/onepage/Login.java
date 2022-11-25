package com.jjluo.crud.onepage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;







@WebServlet("/Login.do")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static String JDBC_DRIVER="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	public static String DB_URL = 
			"jdbc:sqlserver://localhost:1433;databaseName=jdbc;trustservercertificate=true";
	public static String USER = "sa";
	public static String PASSWORD = "passw0rd";	

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String account = request.getParameter("account");
		String password = request.getParameter("password");

		UsersBean u = new UsersBean();
		u.setUsername(account);
		u.setUserPwd(password);
		Connection conn;

		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER ,PASSWORD);
			UsersDAO uDAO = new UsersDAO(conn);
			UsersBean uDetail = uDAO.getOneEmpByAccountAndPassword(u);

			if (uDetail == null) {
				request.setAttribute("message", "±b¸¹©Î±K½X¿ù»~");
				request.getRequestDispatcher("mid/log.jsp").forward(request, response);
				return;
			}

			HttpSession seesion = request.getSession();
			seesion.setAttribute("loginUser", uDetail);
//			response.sendRedirect("/Project/GetAllUsers.do");
			
			response.sendRedirect("mid/MainPage.jsp");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
