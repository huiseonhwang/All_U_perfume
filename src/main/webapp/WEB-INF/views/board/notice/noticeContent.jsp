<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
    
<title>공지사항 게시판</title>

<table border = "1" >
		<tr>
			<th class="active" >제목</th>
			<td>
				${boardDTO.subject }
			</td>
			<th class="active">작성자</th>
			<td>
				${boardDTO.auth }
			</td>
			<th class="active"> 작성일 </th>
			<td>
				${boardDTO.reg_date }
			</td>
			<th class="active"> 조회수 </th>
			<td>
				${boardDTO.readcount }
			</td>
		</tr>

</table>
<table border = "1" >
		<tr>
			<th class="active" >내용</th>
			<td>
				${boardDTO.content }
			</td>
		</tr>
</table>

		<a href="/perfume/notice/list" role = "button"> 글 목록 </a> 
		<a href="/perfume/notice/update?b_number=${boardDTO.b_number }" role = "button"> 수정 </a>
		<a href="/perfume/notice/delete?b_number=${boardDTO.b_number }" role = "button"> 삭제 </a> 
		


