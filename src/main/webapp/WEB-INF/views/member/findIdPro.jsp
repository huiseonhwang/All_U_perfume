<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<c:if test="${result != null}">
회원님의 아이디는 [${result.id}]입니다.<label id ="findId"/><br/>
<input type="button" value="로그인 하러가기" onclick="window.location = '/member/login';">
<input type="button" value="비밀번호 찾기" onclick="window.location = '/member/findPw';">
</c:if>

<c:if test="${result = null}">
해당 이름으로 가입된 아이디가 없습니다. <br/>
<input type="button" value="돌아가기" onclick="window.location = '/member/login';">
</c:if>


</body>
</html>