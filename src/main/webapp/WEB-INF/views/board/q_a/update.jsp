<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>     

<title>Q&A 게시판</title>

    <form action="/perfume/q_a/updatePro" method="post">
    	<input type="hidden" name="boardnum" value="${boardDTO.boardnum}">
		<input type="hidden" name="b_number" value="${boardDTO.b_number}">
    	제 목 : <input type="text" name="subject" value = "${boardDTO.subject }"/> <br/> 
    	작성자 : <input type ="text" name = "writer" value ="${boardDTO.writer } "/> <br/>
    	<input type ="hidden" name ="password" value ="${boardDTO.password }">
    	내 용 : <textarea rows="10" cols="20" name="content">${boardDTO.content }</textarea> <br />
    	첨부파일 : ${boardDTO.filename} <br /> 
    	<input type="submit" value="글 수정" />
    </form>
    <a href ="/perfume/q_a/list"> 글 목록 </a>