<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
<c:if test="${result == 1}">
	<script>
		alert("강제 탈퇴 완료");
		window.location="/admin/main";
	</script>
</c:if>