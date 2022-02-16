<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>     

<title>Q&A 게시판</title>
<h1> Q&A 글 작성 </h1>

    <form action="/perfume/q_a/writePro" method="post">
    	<input type="hidden" name="boardnum" value="${boardDTO.boardnum}">
		<input type="hidden" name="b_number" value="${boardDTO.b_number}">
		<input type="hidden" name="b_number" value="${boardDTO.ref}">
		<input type="hidden" name="b_number" value="${boardDTO.re_step}">
		<input type="hidden" name="b_number" value="${boardDTO.re_level}">
	<c:if test="${boardDTO.b_number == 0}">
    	<input type="text" size="40" maxlength="50" name="subject"></td>
    </c:if>
    <c:if test="${boardDTO.b_number != 0}">
    	<input type="text" size="40" maxlength="50" name="subject" value="[답변]">
    </c:if>
    	작성자 : <input type = "text" name = "writer">
    	비밀번호 : <input type = "password" name = "password">
    	내 용 : <textarea rows="10" cols="20" name="content"></textarea> <br />
    	첨부파일 : ${boardDTO.filename} <br /> 
    	<input type="reset" value = "다시작성" />
    	<input type="submit" value="글쓰기" />
    </form>
    
    <c:if test = "${boardDTO.b_number == 0}">
    
    </c:if>
    
    <c:if test = "${boardDTO.b_number != 0}">
    
    </c:if>