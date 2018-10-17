<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="style.css">
<meta charset="UTF-8">
<title>user_page</title>
</head>
<body>
<div class="R dimgray">
	<font  style="color:#ffffff;">${userInfo.name}さん　　　</font>
		<a href="Logout_servlet">ログアウト</a>
	</div>
	<h1 class="C">ユーザ情報詳細参照</h1>
	<div class="C">ログインID :${userd.login_id}</div>
	<div class="C">ユーザ名 :${userd.name}</div>
	<div class="C">生年月日 :${userd.birth_date}</div>
	<div class="C">登録日時 :${userd.create_date}</div>
	<div class="C">更新日時 :${userd.update_date}</div>
	<div class="R"><a href="UserListservlet">戻る</a></div>

</body>
</html>