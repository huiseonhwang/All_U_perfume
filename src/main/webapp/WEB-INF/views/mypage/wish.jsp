<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>   

<!DOCTYPE html>
<html>
<head>
<c:if test="${sessionScope.id == null && sessionScope.kid == null}">
	<script>
		alert("로그인 후 사용 가능합니다.");
		window.location="/member/login";
	</script>
</c:if>

<c:if test="${sessionScope.id != null}">
	${sessionScope.id}님의 관심향수입니다!
	<input type="button" value="로그아웃" onclick="window.location='/member/logout'" />
	<input type="button" value="회원정보" onclick="window.location='/member/userInfo'" />
	<input type="button" value="설문하러 가기"  onclick="window.location = '/survey/surveyStart'">
	<input type="button" value="메인으로 가기"  onclick="window.location = '/main/list'">
	<input type="button" value="향수 추천페이지"  onclick="window.location = '/perfume/recommendation'">
	<input type="button" value="공지사항 페이지"  onclick="window.location = '/perfume/notice'">
	
</c:if>

<c:if test="${sessionScope.kid != null}">
	${sessionScope.kid}님의 관심향수입니다!
	<input type="button" value="로그아웃" onclick="kakaoLogout();" />
	<input type="button" value="회원정보" onclick="window.location='/member/userInfo'" />
	<input type="button" value="설문하러 가기"  onclick="window.location = '/survey/surveyStart'">
	<input type="button" value="메인으로 가기"  onclick="window.location = '/main/list'">
	<input type="button" value="향수 추천페이지"  onclick="window.location = '/perfume/recommendation'">
	<input type="button" value="공지사항 페이지"  onclick="window.location = '/perfume/notice'">
	
</c:if>

<meta charset="UTF-8">
<title>wish</title>
<style>

</style>
</head>
<body>
<table border="1">
<tr><td>게시글 번호 </td><td>향수이름</td></tr>

<c:forEach items="${p}" var="p">
<tr><td>${p.f_name} </td><td>${p.f_number}</td></tr>
</c:forEach>
</table>



</body>
</html>