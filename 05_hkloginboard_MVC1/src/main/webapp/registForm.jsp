<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<%response.setContentType("text/html; charset=utf-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="layout.css" />

<script type="text/javascript">

   onload=function(){
      //id 중복체크를 완료한 후에 다른 정보를 입력할 수 있게 처리
      //입력박스에 입력하기 전에 idChk=y/n여부를 확인해서 y면 입력 실행, n이면 id입력박스로 커서 이동
      var inputs=document.querySelectorAll("input[name]");
      var idChk=document.getElementById("idChk");
      for(var i=2; i<inputs.length;i++){
         inputs[i].onfocus=function(){
            if(idChk.textContent=="n"){         
               alert("ID 중복체크를 먼저 확인해주세요");
               inputs[1].focus();   //id 입력박스로 이동
            }
         }
      }
   }
   //ID중복체크
   function idChk(){
      //입력된 ID값 구하기
      var id=document.getElementsByName("id")[0].value;
      if(id==""){
         alert("ID를 입력하세요");
      }else{
         window.open("userController.jsp?command=idChk"
                  + "&id="+id,"ID 확인", "width=300px, height=300px");
         
      }
   }
   
   // 패스워드 확인하기
   function isPW(form){
	   if(form.password.value != form.password2.value){
		   alert("비밀번호를 확인하세요");
		   form.password.value=""; // 비밀번호 초기화
		   form.password2.value="";
		   form.password.focus(); // 비밀번호를 바로 입력할 수 있도록 커서 넣기
		   return false; // false를 리턴하면 이벤트를 취소시킨다.
	   }
   }
</script>
</head>
<body>
<nav class="navbar">
   <div id="navbar">
      <ul class="navbar-nav">
         <li>회원가입</li>
         <!-- <li>ABOUT</li>
         <li>CONRECT</li> -->
      </ul>
   </div>
</nav>
<div class="container">
   <!-- <h1>회원가입</h1> -->
   <form class="form-group" action="userController.jsp" method="post" onsubmit = "return isPW(this)">
      <input type="hidden" name="command" value="addUser"/>
      <input type="text" name="id" placeholder="ID" required = "required"/>
      <span id="idChk" style="display:none;">n</span>
      <a href="#" onclick="idChk()">중복체크</a>
      <input type="text" name="name" placeholder="이름" required = "required"/>
      <input type="password" name="password" placeholder="PASSWORD" required = "required"/>
      <input type="password" name="password2" placeholder="PASSWORD확인" required = "required"/>
      <input type="text" name="address" placeholder="주소" required = "required"  />
      <button class ="click">주소찾기</button>
      <input type="email" name="email" placeholder="이메일" required = "required"/>
      <br/><button type="submit">가입완료</button>
      <button type="button" onclick="location.href='index.jsp'">HOME</button>
   </form>
</div>

<div class = "footer">
	Copyright 2023.09.26. 홍가영 All rights reserved.
</div>

<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
	 let click = document.querySelector(".click"); 
     click.onclick = function (roadAddr){
    	// 선언적함수로 open()까지 묶고 roadAddr을 원하는 input textbox에 불러온다
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
                // 예제를 참고하여 다양한 활용법을 확인해 보세요.
           var roadAddr = data.roadAddress; // 도로명 주소 변수
           document.getElementsByName("address")[0].value = roadAddr
            }
        }).open();
    }
    
    
</script>

</body>
</html>