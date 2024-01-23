<%@page import="com.hk.board.dtos.HkDto"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>

<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%response.setContentType("text/html; charset=utf-8");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 상세조회하기</title>
<script type="text/javascript">
   function updateForm(seq){
      //수정폼으로 이동하기 -> 수정폼에 게시글 데이터는 계속 보여지게 하기 위해 상세 조회기능실행
      location.href="updateBoardForm.board?seq="+seq;
   }
   
   //삭제하기
   function deleteBoard(seq){
      location.href="deleteBoard.board?seq="+seq;
   }
   
</script>
</head>
<%
   //request객체에 저장된 dto객체가 전달됨
   HkDto dto =(HkDto)request.getAttribute("dto");
%>

<body>
<h1>글 상세조회</h1>
<table border="1">
   <tr>
      <th>작성자</th>
      <td><%=dto.getId()%></td>
   </tr>
   <tr>
      <th>제목</th>
      <td><%=dto.getTitle()%></td>
   </tr>
   <tr>
      <th>내용</th>
      <td><textarea rows="10" cols="60" readonly="readonly"><%=dto.getContent()%></textarea></td>
   </tr>
   <tr>
      <td colspan="2">
         <button onclick="updateForm(<%=dto.getSeq()%>)">수정</button>
         <button onclick="deleteBoard(<%=dto.getSeq()%>)">삭제</button>
         <button type="button" onclick="location.href='boardList.board'">글목록</button>
      </td>
   </tr>
</table>
</body>
</html>



