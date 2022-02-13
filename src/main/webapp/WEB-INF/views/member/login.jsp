<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>    
<script src="/resources/js/kakaoLogin.js"></script>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>당신만의 향기, All U Perfume</title>
</head>
<body>

	<form action="/member/loginPro" method="post">
		id: <input type="text" name="id"/> <br/>
		pw: <input type="password" name="pw"/> <br/>
			<input type="submit" value="로그인"> <br/>
		아직 회원이 아니신가요? <input type="button" value="회원가입 하러가기" onclick="window.location='/member/register'" />
	</form>

<a href="javascript:kakaoLogin();"><img src="/resources/images/kakao_login_medium_wide.png" alt="카카오계정 로그인" style="height: 50px;"/></a></br>


</body>
</html>