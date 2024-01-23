<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%String msg = request.getParameter("msg"); %>
<body>
<form action="login.user" method = "post" onsubmit = "return userIdCookie()">
	<!-- <input type = "hidden" name = "command" value="login"/> -->
	<h1>Login in</h1>
	<input class = "loginVal" type ="text" name = "id" placeholder = "ID" required = "required"/>
	<input class = "loginVal" type ="password" name = "password" placeholder = "PASSWORD" required = "required"/>
	<input type = "checkbox" value = "remember-me"/><label>아이디저장</label>
	<label>${msg==null?"":msg}</label>
	<button type = "submit">Sign in</button>
	<button type = "button" onclick="registForm()">Sign Up</button>
</form>
</body>
</html>