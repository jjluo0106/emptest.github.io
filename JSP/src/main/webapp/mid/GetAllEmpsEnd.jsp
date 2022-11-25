<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*,com.lcpan.bean.EmpsBean"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>員工資料</title>

<style>
h2 {
	text-align: center;
	border-collapse: collapse;
	font-family: 'Noto Sans TC', sans-serif;
}
</style>


<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+TC:wght@700&display=swap"
	rel="stylesheet">

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU"
	crossorigin="anonymous">

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+TC:wght@700&family=ZCOOL+KuaiLe&display=swap"
	rel="stylesheet">
</head>
<body style="background-color: #fdf5e6">
	<div align="center">
		<ul>
			<li><a class="dropdown-item"
				href="http://localhost:8080/JSP/mid/log.jsp"
				style="text-align: right; list-style-type: none">登出</a></li>
		</ul>
		<h2>員工資料</h2>

		<form method="post" action="/JSP/ReadEmpOnepageServ">
			
				查詢員工姓名:<input type="text" name="namesearch" placeholder="name">
				<input type="submit" value="搜索" class="btn btn-success">
		</form>

			<table class="table table-striped">
				<tr style="background-color: #fdf5e6">
					<th>員工編號
					<th>姓名
					<th>到職日
					<th>薪水
					<th>部門(輸入編號)
					<th>職稱
					<th><c:forEach items="${emps}" var="emp" varStatus="s">
							<tr>
								<td>${emp.empno}
								<td>${emp.ename}
								<td>${emp.hiredate}
								<td>${emp.salary}
								<td>${emp.deptno}
								<td>${emp.title}
								<td><a
									href="javascript:if (confirm('確認刪除')) location='/JSP/DeleteEmpServ?empno=${emp.empno}'"><input
										type="button" value="刪除" class="btn btn-danger"></a> <c:set
										var="count" value="${s.count }" />
						</c:forEach>
						<form method="post" action="/JSP/CreateEmpOnepageServ">
							<tr>
								<td><input type="text" name="empno" placeholder="number">
								<td><input type="text" name="ename" placeholder="name">
								<td><input type="date" name="hiredate">
								<td><input type="text" name="salary" placeholder="salary">
								<td><select name="deptno"><option value="100">100</option>
										<option value="200">200</option>
										<option value="300">300</option></select>
								<td><select name="title"><option value="engineer">engineer</option>
										<option value="senior engineer">senior engineer</option>
										<option value="manager">manager</option></select>
								<td><input type="submit" value="新增" class="btn btn-success">
						</form>
						<form method="post" action="/JSP/UpdateEmpOnepageServ">
							<tr>
								<td><input type="text" name="empno" placeholder="number">
								<td><input type="text" name="ename" placeholder="name">
								<td><input type="date" name="hiredate">
								<td><input type="text" name="salary" placeholder="salary">
								<td><select name="deptno"><option value="100">100</option>
										<option value="200">200</option>
										<option value="300">300</option></select>
								<td><select name="title"><option value="engineer">engineer</option>
										<option value="senior engineer">senior engineer</option>
										<option value="manager">manager</option></select>
								<td><input type="submit" value="修改" class="btn btn-warning">
								<td><div>${message}</div>
						</form>
			</table>
			<h3>共${count}筆員工資料</h3> <!-- <form method="post" action="/JSP/mid/MainPage.jsp">
			<input type="submit" value="返回主頁" class="btn btn-primary">
		</form>
		 -->
	</div>
</body>
</html>