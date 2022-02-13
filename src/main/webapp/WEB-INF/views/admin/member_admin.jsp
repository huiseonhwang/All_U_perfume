<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>     

<title>회원 강제 탈퇴 페이지</title>


<c:if test="${sessionScope.aid == null}">
	<script>
		alert("id/pw를 확인하세요");
		history.go(-1);
	</script>
</c:if>


<c:if test="${sessionScope.aid != null}" >

<form action="member_admin_pro" method = "post" >
	회원 아이디 : <input type = "text" name = "id" placeholder="탈퇴시킬 회원의 아이디를 입력하세요."> <br/>
	<input type = "submit" value = "회원 강제 탈퇴" /><br/>
	
	<!--  id 유효성 검사 -->
</form>
	
</c:if>