<%@page import="com.hk.board.daos.UserDao"%>
<%@page import="com.hk.board.dtos.UserDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원수정폼</title>
</head>
<%
   // 수정하려는 회원의 id를 받는다
   String userId=request.getParameter("userId");
   // 데이터베이스에서 해당 회원의 정보를 조회한다
   UserDao dao= new UserDao();
   UserDto dto= dao.getUser(userId);

   
%>
<body>
<h1>회원정보수정</h1>
<form action="userUpdate.jsp" method="get">
<%--    <input type="hidden" name="userId" value="<%=dto.getUserID()%>"/> --%>
   <table border="1">
      <tr>
         <td>아이디</td>
         <td><input readonly="readonly" type="text" name="userId" value="<%=dto.getUserID()%>"/></td>
      </tr>
      <tr>
         <td>이름</td>
         <td><input type="text" name="name" value="<%=dto.getName()%>"/></td>
      </tr>
      <tr>
         <td>출생년도</td>
         <td><input type="text" name="birthYear" value="<%=dto.getBirthYear()%>"/></td>
      </tr>
      <tr>
         <td>지역</td>
         <td><input type="text" name="addr" value="<%=dto.getAddr()%>"/></td>
      </tr>
      <tr>
         <td>휴대폰 국번</td>
         <td><input type="text" name="moblie1" value="<%=dto.getMobile1()%>"/></td>
      </tr>
      <tr>
         <td>휴대폰 전화번호</td>
         <td><input type="text" name="moblie2" value="<%=dto.getMobile2()%>"/></td>
      </tr>
      <tr>
         <td>신장</td>
         <td><input type="text" name="height" value="<%=dto.getHeight()%>"/></td>
      </tr>
      <tr>
         <td>회원가입일</td>
         <td><input readonly = "readonly" type="text" name="mDate" value="<%=dto.getmDate()%>"/></td>
      </tr>
      <tr>
         <td colspan="2"><input type="submit" value="정보수정"/></td>
      </tr>
   </table>
   <a href = "index.jsp">초기화면</a>
</form>
</body>
</html>