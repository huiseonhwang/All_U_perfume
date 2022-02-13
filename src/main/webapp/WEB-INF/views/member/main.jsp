<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
    
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>

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

<c:if test="${sessionScope.id != null}">
	${sessionScope.id}님, 환영합니다!
	<input type="button" value="로그아웃" onclick="window.location='/member/logout'" />
	<input type="button" value="회원정보" onclick="window.location='/member/userInfo'" />
	<input type="button" value="설문하러 가기"  onclick="window.location = '/survey/surveyStart'">
	<input type="button" value="메인으로 가기"  onclick="window.location = '/main/list'">
	<input type="button" value="향수 추천페이지"  onclick="window.location = '/perfume/recommendation/list'">
	<input type="button" value="공지사항 페이지"  onclick="window.location = '/perfume/notice/list'">
	<input type="button" value="Q&A 페이지"  onclick="window.location = '/perfume/q_a/list'">
</c:if>

<c:if test="${sessionScope.kid != null}">
	${sessionScope.kid}님, 환영합니다!
	<input type="button" value="로그아웃" onclick="kakaoLogout();" />
	<input type="button" value="회원정보" onclick="window.location='/member/userInfo'" />
	<input type="button" value="설문하러 가기"  onclick="window.location = '/survey/surveyStart'">
	<input type="button" value="메인으로 가기"  onclick="window.location = '/main/list'">
	<input type="button" value="향수 추천페이지"  onclick="window.location = '/perfume/recommendation/list'">
	<input type="button" value="공지사항 페이지"  onclick="window.location = '/perfume/notice/list'">
	<input type="button" value="Q&A 페이지"  onclick="window.location = '/perfume/q_a/list'">
</c:if>

<script>
Kakao.init('b39601cdde217504460c15ddd71b1b47');
//카카오로그아웃  
  function kakaoLogout() {
    if (!Kakao.Auth.getAccessToken()) {
      alert('Not logged in.')
      return
    }
    Kakao.Auth.logout(function() {
      $.ajax({
    	  url: "/member/kLogout",
          type: "POST",
          contentType : "application/json; charset=UTF-8",
          async: false,
          success: function(data){
              alert("로그아웃 되었습니다.");
              window.location="/member/login";
          } 
      });
    })
  }
</script>
</body>

</html>