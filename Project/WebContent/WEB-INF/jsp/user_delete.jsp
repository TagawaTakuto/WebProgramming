<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<link rel="stylesheet" href="style.css">
<meta charset="UTF-8">
<title>user_delete</title>
</head>
<body>
	<div class="R dimgray">
		<font  style="color:#ffffff;">${userInfo.name}さん　　　</font>
			<a href="Logout_servlet">ログアウト</a>
	</div>
<h1 class="C">ユーザ削除確認</h1>
<form method="post" action="Userdelete_servlet">
	<div class="C">ログインID:${u.login_id}</div>
	<br><input type = "hidden"  value = ${u.login_id}  name = "login_id">
	<div class="C">を本当に削除してよろしいでしょうか。</div>
	<br>
	<div class="C"><button onclick ="UserListservlet">キャンセル</button>
	 		<input type="submit" style="width:82px;height:26px" value="　OK　">
	 </div>
</form>
</body>
</html>