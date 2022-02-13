<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<script src="/resources/jquery/jquery-3.6.0.min.js"></script>  
<script>
	$(document).ready(function(){
		$("#btn").click(function(){
			$.ajax({
				type : "post" ,
				data : {id : $("#id").val()} , 
				url : "/member/idCheck" , 
				success : function(data){	
					a = parseInt(data);
					if(a == 1){
						$("#result").html("<font color='red'>중복</font>");
					}else{
						$("#result").html("<font color='green'>사용가능</font>");
					}
				}
			});
		});
	});	
	
	function nullCheck(){
		if($("#pw").val() == ""){
			$("#pwCheck").html("<font color='red'>비밀번호를 입력해주세요.</font>");
			return false;
		}
	}
</script>  
<html>
<head>
<meta charset="UTF-8">
<title>당신만의 향기, All U Perfume</title>
</head>
<body>
	<form action="/member/registerPro" method="post" enctype="multipart/form-data" onsubmit="return nullCheck();">
		아이디: <input type="text" id="id" name="id">
			  <input type="button" value="중복확인" id="btn" />
    		  <label id="result"></label>
    		  <br />
		비밀번호: <input type="password" id="pw" name="pw"> <label id="pwCheck"></label> <br/>
		이름: <input type="text" id="name" name="name"><br/>
		이메일: <input type="text" id="email" name="email" placeholder="example@example.com"><br/>
		전화번호: <input type="text" id="phone" name="phone" placeholder="01012345678"><br/>
		생일: <input type="date" id="birthday" name="birthday2"><br/> <%-- 직접 대입하지 않음. --%>
		성별: <input type="radio" id="male" name="gender" value="male">남성
				<input type="radio" id="female" name="gender" value="female">여성<br/>
		프로필 이미지: <input type="file" id="file" name="file"><br/>
			<input type="submit" value="회원가입"><br/>
	</form>
	
</body>
</html>