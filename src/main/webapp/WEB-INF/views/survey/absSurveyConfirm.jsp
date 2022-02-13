<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<script>
    function a(result){
        window.location.href="/survey/absSurveyResult?note="+result    }
    function b(){
        window.location.href="/survey/absSurvey"   }
</script>
<div class="header"></div>
    <div class="body">
        <div class="content" style = "font-size:20px" >
        <div class = "temp2"></div>
        	회원님이 고르신 성별은 
			<c:forEach items="${survey1}" var="survey1">
				<b style = "font-size:25px; color:#76448A;">${survey1.survey}</b>
	 		</c:forEach>이시군요!<br/><br/>
	
			<c:forEach items="${survey2}" var="survey2">
				<b style = "font-size:25px; color:#76448A;">${survey2.survey}</b>
			</c:forEach>의 정취가 담긴 향수를 찾고 계시네요.<br/><br/>
	 
			<c:forEach items="${survey3}" var="survey3">
				<b style = "font-size:25px; color:#76448A;">${survey3.survey}</b>
	 		</c:forEach>가 담긴 향수,<br/><br/>
	 
	 		<c:forEach items="${survey4}" var="survey4">
				<b style = "font-size:25px; color:#76448A;">${survey4.survey}</b>
	 		</c:forEach>같은 이미지가 그려지는 향수,<br/><br/>
	
	 		<c:forEach items="${survey5}" var="survey5">
				<b style = "font-size:25px; color:#76448A;">${survey5.survey}</b>
	 		</c:forEach>이라는 단어가 어울리는 향수.<br/><br/>
	 
			All U Perfume이 오늘, 당신의 향수를 찾아드릴게요.<br/><br/>
	
			찾으시는 분위기가 맞나요?<br/><br/><br/><br/>
	
			<c:forEach items="${survey5}" var="survey5">
				<div class="textBox4"  onclick="a('${survey5.note}')" >네, 맞아요</div>
			</c:forEach><br/>
			<div class="textBox4"  onclick="b()" >다시 알아볼래요</div>
	
   		</div>
    </div>
<div class="footer"></div>
</body>
</html>