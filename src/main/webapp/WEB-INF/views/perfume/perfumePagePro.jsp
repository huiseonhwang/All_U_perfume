<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>


프로페이지</br>

<style>
#menu{
 padding: 0px;
 margin: 0px;
 display : flex;
 height: 50vh;
 justify-content: left;
 align-items: left;
}


#perfumelist{
 padding: 0px;
 margin: 0px;
 display : flex;
 height: 0vh;
 justify-content: center;
 align-items: center;
}

#page {
position: fixed; 
bottom: 0; 
width: 100%; 
text-align: center;
}
		
dd {
 
  display: none;
}




</style>

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>



<c:if test="${sessionScope.id == null && sessionScope.kid == null}">
	<script>
		alert("로그인 후 사용 가능합니다.");
		window.location="/member/login";
	</script>
</c:if>

<c:if test="${sessionScope.id != null}">
	${sessionScope.id}님, 환영합니다!
	<input type="button" value="로그아웃" onclick="window.location='/member/logout'" />
	<input type="button" value="회원정보" onclick="window.location='/member/userInfo'" />
	<input type="button" value="설문하러 가기"  onclick="window.location = '/survey/surveyStart'">
	<input type="button" value="메인으로 가기"  onclick="window.location = '/main/list'">
	<input type="button" value="향수 추천페이지"  onclick="window.location = '/perfume/recommendation'">
	<input type="button" value="공지사항 페이지"  onclick="window.location = '/perfume/notice'">
	
</c:if>

<c:if test="${sessionScope.kid != null}">
	${sessionScope.kid}님, 환영합니다!
	<input type="button" value="로그아웃" onclick="kakaoLogout();" />
	<input type="button" value="회원정보" onclick="window.location='/member/userInfo'" />
	<input type="button" value="설문하러 가기"  onclick="window.location = '/survey/surveyStart'">
	<input type="button" value="메인으로 가기"  onclick="window.location = '/main/list'">
	<input type="button" value="향수 추천페이지"  onclick="window.location = '/perfume/recommendation'">
	<input type="button" value="공지사항 페이지"  onclick="window.location = '/perfume/notice'">
	
</c:if>

<h3>카테고리</h3> </br> 
<input type="button" value="메인으로 가기"  onclick="window.location = '/main/list'">
<div class="menu">
	<form action="/main/search" method="post">
 
	 <select name="choose">
	 <option value="name">향수이름</option>
	 <option value="note">노트이름</option>
	 </select>
 		<input id="key" type = "text" name="keyword"/><input type="submit" value="검색"/></br>

<dl>
	<dt><b>성별</b></dt>
		<dd>
			<input type = "checkbox" id ="gender1" name="c_gender" value="0">여성<br/>
			<input type = "checkbox" id ="gender2" name="c_gender" value="1">남성<br/>
			<input type = "checkbox" id ="gender3" name="c_gender" value="2">중성<br/>
		</dd>


	<dt><b>계절</b></dt>
		<dd>
			<input type = "checkbox" id="season1" name="c_season" value="1">봄</br>
			<input type = "checkbox" id="season2" name="c_season" value="2">여름</br>
			<input type = "checkbox" id="season3" name="c_season" value="3">가을</br>
			<input type = "checkbox" id="season4" name="c_season" value="4">겨울</br>
		</dd>

	<dt><b>노트</b></dt>
		<dd>
			<input type = "checkbox" name="c_note" value="1">시트러스</br>
			<input type = "checkbox" name="c_note" value="2">과일/채소/견과류</br>
			<input type = "checkbox" name="c_note" value="3">꽃</br>
			<input type = "checkbox" name="c_note" value="4">흰 꽃</br>
			<input type = "checkbox" name="c_note" value="5">허브류</br>
			<input type = "checkbox" name="c_note" value="6">향신료</br>
			<input type = "checkbox" name="c_note" value="7">달콤한 디저트향</br>
			<input type = "checkbox" name="c_note"value="8">나무와 이끼류</br>
			<input type = "checkbox" name="c_note" value="9">나무 진액</br>
			<input type = "checkbox" name="c_note" value="10">동물에게 추출한 향기</br>
			<input type = "checkbox" name="c_note" value="11">술</br>
			<input type = "checkbox" name="c_note" value="12">그 외</br>
		</dd>
</dl>
</form>
</div>


<div id="perfumelist">

<table border="1">
<tr><td>게시글 번호 </td><td>향수이름</td></tr>
<c:forEach items="${cate}" var="catee">
	<tr><td><a href="/main/detail?p_number=${catee.p_number}&f_name=${catee.f_name}
	&page=${pa.page}&perPageNum=${pa.perPageNum}&gender=${catee.gender}&season=${catee.season}">${catee.p_number}</a></td>
	
	<td><a href="/main/detail?p_number=${catee.p_number}&f_name=${catee.f_name}
	&page=${pa.page}&gender=${catee.gender}&season=${catee.season}&perPageNum=${pa.perPageNum}">${catee.f_name}</a></td></tr>
</c:forEach>
</table>

</div>

<script>
$('dt').on('click', function() {

	  function slideDown(target) {
	    slideUp();
	    $(target).addClass('on').next().slideDown();
	  }

	  function slideUp() {
	    $('dt').removeClass('on').next().slideUp();
	  }

	  $(this).hasClass('on') ? slideUp() : slideDown(this);

	});
	
	var key = document.querySelector("#key");
	
	key.onfocus = function (e) {
		    $('dt').removeClass('on').next().slideUp();
		    $("input[name=c_gender]").prop("checked", false);
		    $("input[name=c_season]").prop("checked", false);
		    $("input[name=note]").prop("checked", false);

		   
	};
	
	
	
</script>


<div id="page">
	<ul>
		<c:if test="${pageMaker.prev}">
			<a href="${pageMaker.makeQuery(pageMaker.startPage - 1)}">이전</a>
		</c:if>
			
		<c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="idx">
			<a href="${pageMaker.makeQuery(idx)}">${idx}</a>	
		</c:forEach>
		
		<c:if test="${pageMaker.next && pageMaker.endPage > 0 }">
			<a href="list${pageMaker.makeQuery(pageMaker.endPage+1)}">다음</a>
		</c:if>
	</ul>

</div>


	
	
	






