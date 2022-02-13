<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
    function abs4(fourth){
        window.location.href="/survey/absSurvey5?gender=${absSurveyDTO.gender}&season=${absSurveyDTO.season}&third=${absSurveyDTO.third}&fourth="+fourth;
    }
</script>


<div class="header">좋아하는 분위기의 단어를 골라주세요.</div>
    <div class="body">
        <div class="content">
        	<div class = "temp2"></div>
	    		<c:forEach items="${fourth}" var="absSurvey4">	
			           		<div class="imagebox">
			           			<img class="image" src="/resources/images/survey/${absSurvey4.fourth}.jpg" onclick="abs4('${absSurvey4.fourth}')" >
			           		</div>
			           		<br/>
			            <div class = "textBox">${absSurvey4.survey}</div>
			            
				</c:forEach>
		</div>
    </div>
<div class="footer"></div>


</body>
</html>