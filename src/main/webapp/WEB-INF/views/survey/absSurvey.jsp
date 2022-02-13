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
    function abs1(gender){
        window.location.href="/survey/absSurvey2?gender="+gender;
    }
    
</script>



<div class="header">향수를 사용할 성별을 골라주세요.</div>
    <div class="body">
        <div class="content">
        <div class = "temp2"></div>
            <c:forEach items="${first}" var="absSurvey1">				
		        	<div class="textBox2" onclick="abs1('${absSurvey1.gender}')" >
		           		${absSurvey1.survey}
		           	</div>
		       		<br/>
			</c:forEach>
   		</div>
    </div>
<div class="footer"></div>



</body>
</html>