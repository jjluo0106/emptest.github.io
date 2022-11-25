<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>登入</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU"
	crossorigin="anonymous">
<style>

body{
		background-image:'/mid/pet.png';
		
		margin:0;
	}
.todays_pickup {
	color: #ff0042;
	font-family: "Harucraft", sans-serif;
	font-size: 40px;
	line-height: 1.1;
	text-align: center;
	text-shadow: 0px 0px 0 rgb(235, 235, 235), 1px 1px 0 rgb(228, 228, 228),
		2px 2px 0 rgb(222, 222, 222), 3px 3px 0 rgb(215, 215, 215), 4px 4px 0
		rgb(209, 209, 209), 5px 5px 0 rgb(203, 203, 203), 6px 6px 5px
		rgba(0, 0, 0, 0.25), 6px 6px 1px rgba(0, 0, 0, 0.5);
}
</style>
</head>
<body>
	<main class="form-signin m-5 text-center">
		<div class=" text-center  border-5 todays_pickup ">
			<h2 style="font-size: 60px;">使用者登入</h2>

			<form action="http://localhost:8080/JSP/GetAllEmpsServ" method="post">
				帳號 : <input type="text" name="account" class="floatingInput"><br />
				<br /> 密碼 : <input type="text" name="password"
					class="floatingPassword"><br /> <br /> <input
					type="submit" value="登入">
		</div>
		<div class="" style="color: red">${message}</div>
		</form>
	</main>
	</div>
	<div class="text-center m-5">
		快速登入:
		<button class="btn btn-outline-info fastLogin">Jay</button>

	</div>
</body>
<script src="https://code.jquery.com/jquery-3.6.1.js"
	integrity="sha256-3zlB5s2uwoUzrXK3BT7AX3FyvojsraNFxCc2vC/7pNI="
	crossorigin="anonymous"></script>
<script>
	//快速登入
	$(".fastLogin").click(function() {
		$(".floatingInput").val(this.innerHTML);
		$(".floatingPassword").val(this.innerHTML + "001");
	});
</script>
</html>