<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
		<div class="R dimgray">
			<font  style="color:#ffffff;"> さん　　　</font>
				<font color="red">
					<a href="login.html">ログアウト
					</a>
				</font>
		</div>
		<h1 class="C">ユーザ一覧</h1>
		<div class="R">
			<a href="create_user.html">新規登録
			</a>
		</div>
		<div class="hyou">
			<p class="dl">ログインID</p>
			<p class="dc"><span class="input-group"><input type ="text" size="40" login_id = "login_id"></span></p>
			</div>
		<br>
		<div class="hyou">
			<p class="dl">ユーザー名</p>
			<p class="dc"><span class="input-group"><input type ="text" size="40" password = "password"></span></p>
		</div>
		<br>
		<div class="hyou">
			<p class="dl">生年月日
			</p>
			<p class="dc"><span class="input-group"><input type="text" size="13" value="年/月/日" birth_date = "birth_date">
							 　～　<input type="text" size="13" value="年/月/日" birth_date = "birth_date"></span>
			</p>
		</div>
		<div class="R"><input type="submit" value="　　検索　　"></div>
		<hr>
		<table border="1" bgcolor="#c0c0c0" widt="500" cellspacing="0" cellpadding="0" aling="center">
			<tr>
				<th width="20%">ログインID</th>
				<th width="20%">ユーザー名</th>
				<th width="30%">生年月日</th>
				<th width="30%">　　　　</th>
			</tr>

		</table>
	</body>
</html>