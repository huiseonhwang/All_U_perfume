<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<title>향수 추천 게시판</title>

${boardDTO.b_number} 글을 삭제 하시겠습니까? <br />

<form action="/perfume/recommendation/deletePro">
	<input type="hidden" name="b_number" value="${boardDTO.b_number}" />
	<input type="submit" value="글삭제" />
</form>