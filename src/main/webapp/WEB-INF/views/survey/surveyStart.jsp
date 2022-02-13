<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>당신만의 향기, All U Perfume</title>
<link rel="stylesheet" href="/resources/css/survey.css">
</head>

<body>
<c:if test="${sessionScope.id == null && sessionScope.kid == null}">
	<script>
		alert("로그인 후 사용 가능합니다.");
		window.location="/member/login";
	</script>
</c:if>
<div class="header">설문 방식을 선택해 주세요.</div>
    <div class="body">
        <div class="content">
        <div class = "temp2"></div>
			<div class="textBox2" onclick="window.location= '/survey/accSurvey'" >
		    	구체적 설문
		    </div>
		    <br/>
		    <div class="textBox2" onclick="window.location= '/survey/absSurvey'" >
		    	추상적 설문
		    </div>
   		</div>
    </div>
<div class="footer"></div>

	
	
	
</body>
</html>