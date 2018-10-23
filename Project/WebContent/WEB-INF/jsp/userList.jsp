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

		<form method="post" action="UserListservlet">
			<div class="C">
				ログインID　<input type ="text" size="40%" name = "login_id">
			</div>
			<br>
			<div class="C">
				ユーザー名　<input type ="text" size="40" name = "name">
			</div>
			<br>
			<div class="C">
				生年月日　　<input type="date" size="15" name = "date_start">
							 ～　<input type="date" size="15" name = "date_end">
			</div>
			<br>
			<div class="C"><input type="submit" value="　　検索　　"></div>
		</form>
		<hr>
		<table class="tab" >
			<tr>
				<th class="gray" width="20%">ログインID</th>
				<th class="gray" width="20%">ユーザー名</th>
				<th class="gray" width="30%">生年月日</th>
				<th class="gray" width="20%"></th>
			</tr>
		<c:forEach var="user" items="${userList}" >
                   <tr>
                     <td class="C" width="20%"> ${user.login_id}</td>
                     <td class="C" width="20%"> ${user.name}</td>
                     <td class="C" width="30%"> ${user.birth_date}</td>

                     <td align="center">
                       <input type="button" class ="blue L" value="詳細" onClick="location.href ='userDetailservlet?id=${user.id}'" >
				<c:if test = "${userInfo.name == user.name or userInfo.name == '管理者'}">
                       <input type="button" class ="green" value="更新"  onClick="location.href ='UserUpdate_servlet?id=${user.id}'">
				</c:if>
				<c:if test = "${userInfo.name == '管理者'}">
                       <input type="button" class ="red" value="削除" onClick="location.href ='Userdelete_servlet?id=${user.id}'">
				</c:if>
                     </td>
                   </tr>
        </c:forEach>
        </table>
	</body>
</html>