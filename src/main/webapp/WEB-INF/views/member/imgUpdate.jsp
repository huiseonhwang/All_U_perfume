<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>당신만의 향기, All U Perfume</title>
</head>
<body>
	 <form action="/member/imgUpdatePro" method="post" enctype="multipart/form-data">
    		  <input type="hidden" name="id" value="${sessionScope.id}" />
    	사진 : <input type="file" name="file" /> <br />
    		  <input type="submit" value="전송" />
    </form>
</body>
</html>