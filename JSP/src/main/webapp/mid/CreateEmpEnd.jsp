<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html><!--新增第三站-->
<head>
<title>員工資料</title>
</head>
<body style="background-color:#fdf5e6" >
<div align="center">
<h2>員工資料</h2>
<jsp:useBean id="emptest" scope="request" class="com.lcpan.bean.EmpsBean" />
<!-- 過程中使用從路徑class中類別EmpBean的get&set -->
<!-- 讓emp成為存取代表/範圍是request(請求結束消失)/路徑 -->
<form method="post" action="../http://localhost:8080/JSP/MainPage" align="center">
<table>
更新成功!!
<input type="submit" value="返回主頁面" />
</table>
</form>
</div>
</body>
</html>