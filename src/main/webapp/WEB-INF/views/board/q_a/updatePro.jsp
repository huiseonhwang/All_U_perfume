<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
<c:if test="${result == 1}">
	<script>
		alert("글수정 완료");
		window.location="/perfume/q_a/q_aBoardPage";
	</script>
</c:if>