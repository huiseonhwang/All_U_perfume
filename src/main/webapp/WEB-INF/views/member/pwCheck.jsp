<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="/resources/jquery/jquery-3.6.0.min.js"></script>  
<html>
<head>
<meta charset="UTF-8">
<title>당신만의 향기, All U Perfume</title>
</head>

<script>
function pwCheck(){
	$.ajax({
		 type : "post" ,
		data : {id : $("#id").val(), pw : $("#pw").val(), pw2 : $("#pw2").val()} , 
		url : "/member/pwCheckPro" , 
		success : function(data){
			a = parseInt(data);
			if(a == 1){
				alert("비밀번호가 변경되었습니다!");
				window.location="/member/userInfo";
			}else{
				alert("비밀번호가 틀립니다.");
			}
		}
	});	
}
</script>

<body>

	<form action="/member/pwCheckPro" method="post" onsubmit="pwCheck();">
	<input type="hidden" value="${sessionScope.id}" name="id" id="id" />
		현재 비밀번호 : <input type="password" name="pw" id="pw" />
		변경할 비밀번호: <input type="password" name="pw2" id="pw2"/>
		<input type="submit" value="전송" />
	</form>
</body>
</html>