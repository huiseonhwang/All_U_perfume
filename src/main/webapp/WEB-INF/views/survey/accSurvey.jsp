<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>당신만의 향기, All U Perfume</title>
<link rel="stylesheet" href="/resources/css/survey.css">
</head>

<body>
<c:if test="${sessionScope.id == null && sessionScope.kid == null}">
	<script>
		alert("로그인 후 사용 가능합니다.");
		window.location="/member/login";
	</script>
</c:if>
<script type="text/javascript">
var maxCount = 3
var count = 0;

	function threeCheck(field) {
		if(field.checked){
			count += 1;
		}else{
			count -= 1;
		}
		
		if(count > maxCount){
			alert("최대 3가지 향만 선택 가능합니다.");
			field.checked = false;
			count -= 1;
		}
	}
	
	function noneCheck() {
		 var valCheck = false;
	     var userVal = document.getElementsByName("note_type_num");
	        for(var i=0;i<userVal.length;i++){
	            if(userVal[i].checked == true) {
	            	valCheck = true;
	            }
	        }
	        if(valCheck == false){
	        	alert("하나 이상의 향을 선택해주세요");
	        	return false;
	        }
	}
	
</script>
<div class="header">원하는 타입의 향을 3가지 골라주세요.</div>
    <div class="body">
        <div class="content" style = "font-size:20px" >
        <div class = "temp2"></div>
        
		<b>노트</b><br/><br/>
		<form action="/survey/accSurveyResult" method="post" onsubmit="return noneCheck();">
			<input onclick="threeCheck(this)" type = "checkbox"  name="note_type_num" value="1"/>시트러스<br/><br/>
			<input onclick="threeCheck(this)" type = "checkbox"  name="note_type_num" value="2" />과일/채소/견과류<br/><br/>
			<input onclick="threeCheck(this)" type = "checkbox"  name="note_type_num" value="3"/>꽃<br/><br/>
			<input onclick="threeCheck(this)" type = "checkbox"  name="note_type_num" value="4"/>흰 꽃<br/><br/>
			<input onclick="threeCheck(this)" type = "checkbox"  name="note_type_num" value="5"/>허브류<br/><br/>
			<input onclick="threeCheck(this)" type = "checkbox"  name="note_type_num" value="6"/>향신료<br/><br/>
			<input onclick="threeCheck(this)" type = "checkbox"  name="note_type_num" value="7"/>달콤한 디저트향<br/><br/>
			<input onclick="threeCheck(this)" type = "checkbox"  name="note_type_num" value="8"/>나무와 이끼류<br/><br/>
			<input onclick="threeCheck(this)" type = "checkbox"  name="note_type_num" value="9"/>나무 진액<br/><br/>
			<input onclick="threeCheck(this)" type = "checkbox"  name="note_type_num" value="10"/>동물에게 추출한 향기<br/><br/>
			<input onclick="threeCheck(this)" type = "checkbox"  name="note_type_num" value="11"/>술<br/><br/>
			<input onclick="threeCheck(this)" type = "checkbox"  name="note_type_num" value="12"/>그 외<br/><br/>

			<div class="textBox4"><input type="submit" value="결과 확인" style="border: none; background: transparent; width:800px; height:90px;font-weight: 500; font-size : 20px;"></div>
        </form>	
   		</div>
    </div>
<div class="footer"></div>
</body>
</html>