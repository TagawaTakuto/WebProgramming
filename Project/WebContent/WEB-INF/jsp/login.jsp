<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang ="ja">
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="style.css">
	<title>login</title>
</head>
	<body>
		<h1 class = "C"> ログイン画面 </h1>

	<font color="red">
		<c:if test="${errMsg != null}" >
	   		<div class="C" role="alert">
		 	 ${errMsg}
			</div>
		</c:if>
	</font>
		<form method="post" action="Login_servlet">
			<br>
			<div class="C">ログインID　　<input type ="text" name = "login_id"  placeholder="id"></div><br>
			<br>
			<div class="C">パスワード　　<input type ="password" name = "password" placeholder="●●●●●"></div><br>
			<div class="C"><input type ="submit" value="　ログイン　"></div>
		</form>
	</body>
</html>
