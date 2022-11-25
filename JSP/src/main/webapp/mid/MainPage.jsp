<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>期中專題</title>

<style>
form {
	text-align: center;
	border-collapse: collapse;
	font-family: 'Noto Sans TC', sans-serif;
}
</style>



<!-- JavaScript Bundle with Popper -->
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
	<!-- CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCC -->

	<ul >
		<li><a class="dropdown-item"
			href="http://localhost:8080/JSP/mid/log.jsp"
			style="text-align: right">登出</a></li>
	</ul>

	<form method="post" action="/JSP/CreateEmpServ">
		<h2>新增員工資料(C)</h2>
		輸入員工編號 : <input type="text" name="empno" />
		<p>
			輸入員工姓名 : <input type="text" name="ename" />
		<p>
			輸入員工到職日 : <input type="text" name="hiredate" />
		<p>
			輸入員工薪水 : <input type="text" name="salary" />
		<p>
			輸入員工部門號碼 : <input type="text" name="deptno" />
		<p>
			輸入員工職稱 : <input type="text" name="title" />
		<p>
			<input type="submit" class="btn btn-primary" value="確定" />
	</form>

	<form method="post" action="/JSP/ReadEmpServ">
		<h2>查詢員工資料(R)</h2>
		<!-- RRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRR -->
		輸入員工編號 : <input type="text" name="empno" />
		<p>
			<input type="submit" class="btn btn-primary" value="確定" />
	</form>

	<form method="post" action="/JSP/UpdateEmpServ">
		<h2>修改員工資料(U)</h2>
		<!-- UUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUU -->
		輸入員工姓名 : <input type="text" name="ename" />
		<p>
			輸入欲調整的薪水 : <input type="text" name="salary" />
		<p>

			<input type="submit" value="確定" class="btn btn-primary" />
	</form>

	<form method="post" action="/JSP/DeleteEmpOnepageServ">
		<h2>刪除員工資料(D)</h2>
		<!-- DDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD -->
		輸入員工編號 : <input type="text" name="empno" />
		<p>

			<input type="submit" value="確定" class="btn btn-primary" />
	</form>

	<form method="post" action="/JSP/GetAllEmpsServ">
		<h2>查詢所有員工資料</h2>
		<input type="submit" value="確定" class="btn btn-primary" />
	</form>

</body>
</html>
