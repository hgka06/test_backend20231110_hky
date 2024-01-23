<%@page import="com.hk.board.dtos.HkDto"%>
<%@page import="com.hk.board.daos.HkDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<%response.setContentType("text/html; charset=utf-8"); %>
<%@include file="header2.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글수정하기</title>
</head>
<%
	HkDto dto = (HkDto)request.getAttribute("dto");
%>
<body>
<!-- <h1>글 수정하기</h1> -->
<form action = "hkController.jsp" method = "post">
	<input type = "hidden" name = "command" value="updateBoard"/>
	<input type = "hidden" name = "seq" value = "<%=dto.getSeq() %>" />
	<table border = "1" class="board1">
		<tr>
			<th>작성자</th>
			<td><%=dto.getId() %></td>
		</tr>
		<tr>
			<th>제목</th>
			<td><input class = "bt" type = "text"  name = "title" value = "<%=dto.getTitle() %>"/></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea class = "in" rows = "10" cols = "60" name = "content"><%=dto.getContent() %></textarea></td>
		</tr>
		<tr>
			<td colspan = "2">
				<button type = "submit">수정완료</button>
				<button type = "button" onclick = "location.href='hkController.jsp?command=boardList'">글목록</button>
			</td>
		</tr>
	</table>
</form>
<%@include file="footer.jsp" %>
</body>
</html>