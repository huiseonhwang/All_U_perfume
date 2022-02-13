<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>     

<title>향수 추천 게시판</title>

    <form action="/perfume/recommendation/writePro" method="post">
    	<input type="hidden" name="boardnum" value="${boardDTO.boardnum}">
		<input type="hidden" name="b_number" value="${boardDTO.b_number}">
    	제 목 : <input type="text" name="subject" /> <br />
    	사용자 : <input type = "text" name="writer" id = "writer" value = ${boardDTO.writer}/> <br/>
    	PW : <input type = "password" name="password" /> <br />
    	<input type ="hidden" name ="auth" value="${boardDTO.auth}" />  <br />
    	내 용 : <textarea rows="10" cols="20" name="content"></textarea> <br />
    	첨부파일 : ${boardDTO.filename} <br /> 
    		   <input type="submit" value="글쓰기" />
    </form>