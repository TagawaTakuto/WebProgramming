<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang ="ja">
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="style.css">
	<title>login</title>
</head>
	<body>
		<h1 class = "C"> ログイン画面 </h1>

		<c:if class="C" test="${errMsg != null}" >
	   		<div class="C" role="alert">
		 	 ${errMsg}
			</div>
		</c:if>

		<form method="post" action="Login_servlet">
			<br>
			<div class="C">ログインID　　<input type ="text" name = "login_id"  placeholder="id"></div><br>
			<br>
			<div class="C">パスワード　　<input type ="password" name = "password" placeholder="●●●●●"></div><br>
			<div class="C"><input type ="submit" value="　ログイン　"></div>
		</form>
	</body>
</html>
