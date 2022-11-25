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
		<h2>搜尋結果</h2>


			<table class="table table-striped">
				<tr style="background-color: #fdf5e6">
					<th>員工編號
					<th>姓名
					<th>到職日
					<th>薪水
					<th>部門
					<th>職稱
					<th><c:forEach items="${searchemps}" var="searchemp" varStatus="s">
							<tr>
								<td>${searchemp.empno}
						<td>${searchemp.ename}
						<td>${searchemp.hiredate}
						<td>${searchemp.salary}
						<td>${searchemp.deptno}
						<td>${searchemp.title}
								<td><a
									href="javascript:if (confirm('確認刪除')) location='/JSP/DeleteEmpServ?empno=${emp.empno}'"><input
										type="button" value="刪除" class="btn btn-danger"></a> <c:set
										var="count" value="${s.count }" />
						</c:forEach>
						
			</table>
			<h3>共${count}筆員工資料</h3>
			
			 <form method="post" action="/JSP/GetAllEmpsServ">
			<input type="submit" value="返回主頁" class="btn btn-primary">
		</form>
		
	</div>
</body>
</html>