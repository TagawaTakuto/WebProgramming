<%@page language="java" contentType="text/html;charset="UTF-8"
pageEncoding="UTF-8"%>

<%
request.setCharacterEncoding("UTF-8");

String id = request.getId("id");
String name =request.getName("name");
Date birthDate = request.getBirth_date("birth_date");
String createDate = request.getCreate_date("create_date");
String updateDate = request.getUpdate_date("update_date");
%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="style.css">
<meta charset="UTF-8">
<title>user_page</title>
</head>
<body>
<div class="R dimgray">
	<font  style="color:#ffffff;"> さん　　　</font>
		<a href="login.html">ログアウト</a>
	</div>
	<h1 class="C">ユーザ情報詳細参照</h1>
	<div class="C">ログインID <%=id%></div>
	<div class="C">ユーザ名</div>
	<div class="C">生年月日</div>
	<div class="C">登録日時</div>
	<div class="C">更新日時</div>
	<div class="L"><a href="user_search.html">戻る</a></div>

</body>
</html>