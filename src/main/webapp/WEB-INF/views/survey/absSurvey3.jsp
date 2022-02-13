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


<script>
    function abs3(third){
        window.location.href="/survey/absSurvey4?gender=${absSurveyDTO.gender}&season=${absSurveyDTO.season}&third="+third;
    }
</script>

<div class="header">떠올리는 것만으로도 행복하거나
편안해지는 향기를 골라주세요.</div>
    <div class="body">
        <div class="content">
        	<div class = "temp"></div>
            	<c:forEach items="${third}" var="absSurvey3">				
		        	<div class="imagebox">
		           		<img class="image" src="/resources/images/survey/${absSurvey3.third}.jpg" onclick="abs3('${absSurvey3.third}')" >
		           	</div>
		           	<br/>
					<div class = "textBox">${absSurvey3.survey}</div>

		  
			</c:forEach>
   		</div>
    </div>
<div class="footer"></div>

</body>
</html>