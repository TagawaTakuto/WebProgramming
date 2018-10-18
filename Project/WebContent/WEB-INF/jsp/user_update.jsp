<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<link rel="stylesheet" href="style.css">
<meta charset="UTF-8">
<title>user_update</title>
</head>
<body>
	<div class="R dimgray">
		<font  style="color:#ffffff;">${userInfo.name}さん　　　</font>
			<a href="Logout_servlet">ログアウト</a>
	</div>
	<form method="post" action="UserUpdate_servlet">
		<h1 class="C">ユーザ情報更新</h1>
		<font color="red">
			<c:if test="${errMsg != null}" >
	   			<div class="C" role="alert">
		 	 	${errMsg}
				</div>
			</c:if>
		</font>
		<div class="C">ログインID ${userd.login_id}</div>
		<br><input type = "hidden" value = userInfo.login_id name = "login_id">
		<div class="C">パスワード　　　　　<input type="password" name = "password"></div>
		<br>
		<div class="C">パスワード(確認)　　<input type="password" name = "kakuninpassword"></div>
		<br>
		<div class="C">ユーザ名　　　　　　<input type="text" value="${userd.name}" name = "name"></div>
		<br>
		<div class="C">生年月日　　　　　<input type="Date" value="${userd.birth_date}" name = "birth_date"></div>
		<br>
		<div class="C"><input type="submit" value="更新"></div>
		<br>
	</form>
		<div class="R"><a href="UserListservlet">戻る</a></div>
	</body>
</html>