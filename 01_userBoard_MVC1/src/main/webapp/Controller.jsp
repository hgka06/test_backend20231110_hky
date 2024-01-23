<%@page import="com.hk.board.daos.UserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<%response.setContentType("text/html; charset=utf-8"); %>        
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
   //1단계: command 값 받기 - 어떤 요청인지 확인을 위해 값을 받는다
   String command = request.getParameter("command");

   //2단계: DAO 객체 생성 - DB관련 작업 수행을 위해 준비..
   UserDao dao = new UserDao();

   
   %>

</body>
</html>