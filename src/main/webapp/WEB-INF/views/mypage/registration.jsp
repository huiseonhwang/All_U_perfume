<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>wish</title>
<style>
.ebox {
	text-align:center;
	font-size:1.5em;
	height: 150px;
 	width: 300px;
 	line-height:150px;
 	
}
.box {
	/* border: 1px solid darkblue; */ 
	text-align:center;
	font-size:1.5em;
	height: 150px;
 	width: 300px;
 	cursor: pointer;
 	background-color: gold;
 	line-height:150px;
}
</style>
<script>
	function wish(){
		window.opener.location.href="/mypage/wish";
		window.close();
	}
</script>
</head>
<body>
<table align = "center" >
<tr><td><div class="ebox" >등록 완료!</div></td></tr>
<tr><td><div class="box" onclick="wish()">등록된 관심향수 보러가기</div></td></tr>

</table>
</body>
</html>