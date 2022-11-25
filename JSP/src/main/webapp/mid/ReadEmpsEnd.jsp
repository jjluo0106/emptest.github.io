<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>員工資料</title>
</head>
<body style="background-color:#fdf5e6" >
<div align="center">
<h2>員工資料</h2>
<jsp:useBean id="emp" scope="request" class="com.lcpan.bean.EmpsBean" />

<form method="post" action="http://localhost:8080/JSP/mid/MainPage.jsp">
<table>
<tr><td>員工編號
<input type="text" disabled value="<%= emp.getEmpno() %>">
<tr><td>姓名<input type="text" disabled value="<%= emp.getEname() %>" >
<tr><td>到職日<input type="text" disabled value="<%= emp.getHiredate() %>" >
<tr><td>薪水<input type="text" disabled value="<%= emp.getSalary() %>" >
<tr><td>部門編號<input type="text" disabled value="<%= emp.getDeptno() %>" >
<tr><td>職稱<input type="text" disabled value="<%= emp.getTitle() %>" >
<input type="submit" value="返回主選單" />
</table>
</form>
</div>
</body>
</html>