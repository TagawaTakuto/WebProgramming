<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<link rel="stylesheet" href="style.css">
<meta charset="UTF-8">
<title>create_user</title>
</head>
<body>
	<div class="R dimgray">
		<font  style="color:#ffffff;">${userInfo.name} さん　　　</font>
			<a href="login.html">ログアウト</a>
	</div>
	<h1 class="C">ユーザ新規登録</h1>
	<font color="red">
			<c:if test="${errMsg != null}" >
	   			<div class="C" role="alert">
		 	 	${errMsg}
				</div>
			</c:if>
		</font>
	<form method="post" action="UserCreate_servlet">
		<div class="C">ログインID　　　　<input type="text" name = "login_id"></div>
		<br>
		<div class="C">パスワード　　　　<input type="password" name = "password"></div>
		<br>
		<div class="C">パスワード(確認)　<input type="password" name = "kakuninpassword"></div>
		<br>
		<div class="C">ユーザ名　　　　　<input type="text" name = "name"></div>
		<br>
		<div class="C">生年月日　　　　　<input type="text" name = "birth_date"></div>
		<br>
		<div class="C"><input type="submit" value="登録"></div>
		<div class="R"><a href="UserListservlet">戻る</a></div>
	</form>
</body>
</html>