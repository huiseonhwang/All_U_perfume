<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
#col1 {
	text-align: center;
    position: absolute;
    left: 5px;
    padding: 0px;  
    
}

#col2 {
	text-align: center;
    position: absolute;
    margin-left: 200px;
    padding: 0px;
}

#col3 {
	text-align: center;
	position: absolute;
    margin-left: 400px;
    padding: 0px;
}

#col4 {
	text-align: center;
	position: absolute;
    margin-left: 600px;
    padding: 0px;
}

#col5 {
	text-align: center;
    margin-left: 800px;
    padding: 0px;
}

#a{
	text-align: center;
	text-rendering: optimizeLegibility;
	text-decoration: none;
	white-space:nowrap;
}

#aa{
	text-rendering: optimizeLegibility;
    font-size: inherit;
    line-height: 1.6;
    margin-bottom: 1rem;
}

.firstbox {

 	height: 500px;
 	width: 200px;
}
.box {
	/* border: 1px solid darkblue;  */
	margin: 30px 3px 10px 5px;
	height: 50px;
 	width: 950px;
}

#btnSubmit{
        width:100px;
        margin:auto;
        display:block;
    }

</style>

<html>
<head>
<meta charset="UTF-8">
<title>당신만의 향기, All U Perfume</title>
</head>
<body>
<c:if test="${sessionScope.id == null && sessionScope.kid == null}">
	<script>
		alert("로그인 후 사용 가능합니다.");
		window.location="/member/login";
	</script>
</c:if>
<div class="header"></div>
    <div class="body">
        <div class="content">
        	<div class="box"><br/><input id="btnSubmit" style="width:3cm;height:1cm" type="button" value="관심향수 등록"/></div>
			<br/>
			<br/>
        	<c:forEach items="${result}" var="result" varStatus="status" step="1" begin="0">
				<div class="firstbox"id="col${status.index % 5 + 1}" >	
				<div><input type="checkbox"></div><br/>
				<div>
					<p id ="aa"><a href="javascript:void(0);" onclick="window.open('/main/detail?p_number=${result.p_number}&f_name=${result.f_name}', 'pop01', 'top=10, left=10, width=500, height=600, status=no, menubar=no, toolbar=no, resizable=no');">
						<img src="${result.f_pic}" width="100" height="200"></a>
					</p>
 					<p id="aa"><a href="javascript:void(0);" onclick="window.open('/main/detail?p_number=${result.p_number}&f_name=${result.f_name}', 'pop01', 'top=10, left=10, width=500, height=600, status=no, menubar=no, toolbar=no, resizable=no');">
 						${brand[status.index].d_name}</a>
 						
 					</p>
 					<p id="aa" ><a href="javascript:void(0);" onclick="window.open('/main/detail?p_number=${result.p_number}&f_name=${result.f_name}', 'pop01', 'top=10, left=10, width=500, height=600, status=no, menubar=no, toolbar=no, resizable=no');">
 						${result.f_name}</a>
 					</p>
 				</div>
 				</div>
			</c:forEach>
   		</div>
    </div>
<div class="footer"></div>

</body>
</html>