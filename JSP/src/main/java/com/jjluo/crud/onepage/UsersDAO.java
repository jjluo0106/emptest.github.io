package com.jjluo.crud.onepage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.lcpan.bean.EmpsBean;





public class UsersDAO {
	private Connection conn;

	public UsersDAO(Connection conn) {
		this.conn = conn;
	}
	/**
	 * �ھڨϥΪ̪�ID�����ϥΪ̪��Ҧ���ơC
	 * <p>
	 * 
	 * @param userID �ϥΪ̪�ID
	 * @return Users �ϥΪ̪�java bean�A�̭����ϥΪ̪��Ҧ���ơF �YID���s�b�h�^��null�C
	 */
	public EmpsBean getEmpByNo(String empno) throws SQLException {
		String SQL = "SELECT * FROM [jdbc].[dbo].[employee] where empno=? ";
		PreparedStatement preState = conn.prepareStatement(SQL);
		preState.setString(1, empno);
		ResultSet rs = preState.executeQuery();

		if (rs.next()) {
			EmpsBean u = new EmpsBean();
			u.setEmpno(rs.getString("empno"));
			u.setEname(rs.getString("ename"));
			u.setHiredate(rs.getString("hiredate"));
			u.setSalary(rs.getString("salary"));
			u.setDeptno(rs.getString("deptno"));
			u.setTitle(rs.getString("title"));
			
			System.out.println("aaaaa");
			return u;
		}
		

		preState.close();
		return null;
	}
	/**
	 * ���o�Ҧ��ϥΪ̪���ơC
	 * <p>
	 * 
	 * @return ArrayList �ϥΪ̪����X�A�̭����Ҧ��ϥΪ̪���ơC
	 */

	public ArrayList<EmpsBean> getAllUsers() throws SQLException {

	//	String SQL = "SELECT [empno],[ename],[hiredate],[salary],[deptno],[title] FROM [jdbc].[dbo].[employee]";
		String SQL = "SELECT  [empno],[ename],[hiredate],[salary],[dname],[title]FROM [jdbc].[dbo].[employee]join [jdbc].[dbo].department on [employee].[deptno]=[department].deptno";
		
		
		PreparedStatement preState = conn.prepareStatement(SQL);

		ArrayList<EmpsBean> aL = new ArrayList<EmpsBean>();

		ResultSet rs = preState.executeQuery();

		while (rs.next()) {
			EmpsBean u = new EmpsBean();
			u.setEmpno(rs.getString("empno"));
			u.setEname(rs.getString("ename"));
			u.setHiredate(rs.getString("hiredate"));
			u.setSalary(rs.getString("salary"));
			u.setDeptno(rs.getString("dname"));
			u.setTitle(rs.getString("title"));
			aL.add(u);
		}
		
		rs.close();
		preState.close();

		return aL;
	}
	
	public ArrayList<UsersBean> getAllUsers2() throws SQLException {

		String SQL = "SELECT [id],[username],[userPwd],[photo] FROM [jdbc].[dbo].[Users]";
		
		
		PreparedStatement preState = conn.prepareStatement(SQL);

		ArrayList<UsersBean> aL = new ArrayList<UsersBean>();

		ResultSet rs = preState.executeQuery();

		while (rs.next()) {
			UsersBean u = new UsersBean();
			u.setId(rs.getInt("id"));
			u.setUsername(rs.getString("username"));
			u.setUserPwd(rs.getString("userPwd"));
			u.setPhoto(rs.getString("photo"));
	
			aL.add(u);
		}
		
		rs.close();
		preState.close();

		return aL;
	}
	
	
	
	
	public UsersBean getOneEmpByAccountAndPassword(UsersBean u) throws SQLException {

		String SQL = "SELECT * FROM [jdbc].[dbo].[Users] WHERE username = ? AND userPwd = ?";
		PreparedStatement preState = conn.prepareStatement(SQL);
		preState.setString(1, u.getUsername());
		preState.setString(2, u.getUserPwd());
		
		
		ResultSet rs = preState.executeQuery();

		if (rs.next()) {
			UsersBean uDetail = new UsersBean();
			uDetail.setId(rs.getInt("id"));
			uDetail.setUsername(rs.getString("username"));
			uDetail.setUserPwd(rs.getString("userPwd"));

			return uDetail;
		}
		rs.close();
		preState.close();

		return null;
	}
	
	//insert emp
	public void insertEmp(EmpsBean b ) throws SQLException {
	    String SQL = "insert into  [jdbc].[dbo].[employee]  VALUES (?, ?, ?, ?, ?, ?) ";
	    PreparedStatement pstmt = conn.prepareStatement(SQL);

	    pstmt.setString(1, b.getEmpno());
		pstmt.setString(2, b.getEname());
		pstmt.setString(3, b.getHiredate());
		pstmt.setString(4, b.getSalary());
		pstmt.setString(5, b.getDeptno());
		pstmt.setString(6, b.getTitle());
//		int count = pstmt.executeUpdate();
//		System.out.println("delete count = " + count);
		pstmt.execute();
		pstmt.close();
		
	}
	
	public void deleteEmp(String empno ) throws SQLException {
		
		String SQL = "delete [jdbc].[dbo].[employee] where empno= ? ";
		PreparedStatement pstmt = conn.prepareStatement(SQL);
		pstmt.setString(1, empno);
		
		int count = pstmt.executeUpdate();
		System.out.println("delete count = " + count);
		
		pstmt.close();
	}
	
	
	public void updateEmp(EmpsBean b ) throws SQLException {
		
		String SQL = "update [jdbc].[dbo].[employee]SET [ename]=? , [hiredate]=?,[salary]=?, [deptno]=?,[title]=? where [empno]=?";
		PreparedStatement pstmt = conn.prepareStatement(SQL);
	    pstmt.setString(6, b.getEmpno());
		pstmt.setString(1, b.getEname());
		pstmt.setString(2, b.getHiredate());
		pstmt.setString(3, b.getSalary());
		pstmt.setString(4, b.getDeptno());
		pstmt.setString(5, b.getTitle());
		
		int count = pstmt.executeUpdate();
		System.out.println("delete count = " + count);
		
		pstmt.close();
	}
	
	
//	
//	public  DepartmentBean getOneDnoByDname(String d) throws SQLException {
//
//		String SQL = "SELECT * FROM [jdbc].[dbo].[department]where[dname] =?";
//		PreparedStatement preState = conn.prepareStatement(SQL);
//		preState.setString(1, d);
//	
//		
//		
//		ResultSet rs = preState.executeQuery();
//
//		if (rs.next()) {
//			DepartmentBean dDetail = new DepartmentBean();
//			dDetail.setDeptno(rs.getString("deptno"));
//			dDetail.setDname(rs.getString("dname"));
//		
//
//			return dDetail;
//		}
//		rs.close();
//		preState.close();
//
//		return null;
//	}
//	
	
	
	
	
//	
//	public byte[] getPhotoByID(String empno) throws SQLException {
//
//		String SQL = "SELECT photo FROM [PetForum].[dbo].[Pet] WHERE id = ?";
//		PreparedStatement preState = conn.prepareStatement(SQL);
//
//		preState.setInt(1, id);
//		ResultSet rs = preState.executeQuery();
//
//		byte[] bytes = null;
//
//		if (rs.next()) {
//			bytes = rs.getBytes("photo");
//		}
//
//		rs.close();
//		preState.close();
//
//		return bytes;
//	}
//	
	
	
	
	
	
	
	
	
	
}
