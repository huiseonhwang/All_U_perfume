<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
${boardDTO.b_number} 글을 삭제 하시겠습니까? <br />

<form action="/perfume/q_a/deletePro">
	<input type="hidden" name="b_number" value="${boardDTO.b_number}" />
	<input type="submit" value="글삭제" />
</form>