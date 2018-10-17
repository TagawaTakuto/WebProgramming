<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang ="ja">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="style.css">
<title>user_search</title>
</head>
	<body>
		<div class="R dimgray">
			<font  style="color:#ffffff;">${userInfo.name}さん　　　</font>
				<font color="red">
					<a href="Logout_servlet">ログアウト
					</a>
				</font>
		</div>
		<h1 class="C">ユーザ一覧</h1>
		<div class="R">
			<a href="UserCreate_servlet">新規登録
			</a>
		</div>
		<div class="C">
			ログインID　<input type ="text" size="40%" name = "login_id"></span>
			</div>
		<br>
		<div class="C">
			ユーザー名　<input type ="text" size="40" name = "password"></span>
		</div>
		<br>
		<div class="C">
			生年月日　　<input type="date" size="15" name = "date_start">
							 ～　<input type="date" size="15" name = "date_end">
			</p>
		</div>
		<div class="C"><input type="submit" value="　　検索　　"></div>
		<hr>
		<table border="1" bgcolor="#c0c0c0" width = "1000" cellspacing="0" cellpadding="0" aling="center">
			<tr>
				<th width="20%">ログインID</th>
				<th width="20%">ユーザー名</th>
				<th width="30%">生年月日</th>
				<th width=></th>
			</tr>
		</table >
		<table border="1" width="1000"  aling="center">
		<c:forEach var="user" items="${userList}" >
                   <tr>
                     <td class="C" width="20%"> ${user.login_id}</td>
                     <td class="C" width="20%"> ${user.name}</td>
                     <td class="C" width="30%"> ${user.birth_date}</td>

                     <td class="C">
                       <a  href ="userDetailservlet?id=${user.id}">詳細</a>　　
                       <a class="green" href ="UserUpdate_servlet?id=${user.id}">更新</a>　　
                       <a class="red" href ="userDeleteervlet?id=${user.id}">削除</a>
                     </td>
                   </tr>
        </c:forEach>
        </table>
	</body>
</html>