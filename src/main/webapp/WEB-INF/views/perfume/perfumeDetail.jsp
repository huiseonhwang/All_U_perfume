<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>


<style>
	.hidden{display:none;}
</style>






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





<table align = "center">
<c:forEach items="${getDetail}" var= "per"> 

<script>
	function wish(){
		var result = confirm("관심향수로 등록하시겠습니까?");
		var url = "/mypage/registration?f_number=${per.f_number}&writer=${sessionScope.id}";
        var name = "wish";
		var option = "width = 500, height = 500, top = 100, left = 200, location = no"
		if(result){
			window.open(url,name, option);	
		}else{	
		}
	}
</script>

<tr><td>게시물번호 :</td><td>${per.p_number}</td></tr>
<td>${per.p_number}<input type = "button" value="관심향수 등록" onclick="wish()"/></td></tr>

<tr>
	<td><img src="${per.f_pic}" width="100" height="200"></td>
</tr>
<tr>
	<td>향수번호 :</td><td>${per.f_number}</td>
</tr>
<tr>
	<td>향수이름 :</td><td>${per.f_name}</td>
</tr>

<tr>
        <td>
            탑노트:
        </td>
        <td>
            <c:forEach items="${topnote}" var= "note"> 
            <td><img src="${note.n_pic}" /><br/>
            ${note.note_eng}<br/></td>
            </c:forEach>
        </td>
    </tr>
    <tr>
        <td>
            하트 노트 :
        </td>
        <td>
        <c:forEach items="${heartnote}" var= "note"> 
            <td><img src="${note.n_pic}" /><br/>
            ${note.note_eng} <br/></td>
            </c:forEach>
        </td>
    </tr>
    <tr>
        <td>
            베이스 노트 :
        </td>
        <td>
            <c:forEach items="${basenote}" var= "note"> 
            <td><img src="${note.n_pic}" /><br/>
            ${note.note_eng} <br/></td>
            </c:forEach>
        </td>
    </tr>
    
<tr>
	<td>성별 :</td>
	<td><c:choose>
		<c:when test="${per.gender == '0'}">
		여자
		</c:when>
		<c:when test="${per.gender == '1'}">
		남자
		</c:when>
		<c:when test="${per.gender == '2'}">
		중성
	</c:when>
	</c:choose>
	</td></tr>
<tr>
	<td>계절 : </td>
	<td><c:choose>
		<c:when test="${per.season == '1'}">
		봄
		</c:when>
		<c:when test="${per.season == '2'}">
		여름
		</c:when>
		<c:when test="${per.season == '3'}">
		가을
		</c:when>
		<c:when test="${per.season == '4'}">
		겨울
		</c:when>
		<c:when test="${per.season == '1-2'}">
		봄,여름
		</c:when>
		<c:when test="${per.season == '1-3'}">
		봄,가을
		</c:when>
		<c:when test="${per.season == '1-4'}">
		봄,겨울
		</c:when>
		<c:when test="${per.season == '2-3'}">
		여름,가을
		</c:when>
		<c:when test="${per.season == '2-4'}">
		여름,겨울 
		</c:when>
		<c:when test="${per.season == '3-4'}">
		가을,겨울
		</c:when>
		<c:when test="${per.season == '1-2-3'}">
		봄,여름,가을
		</c:when>
		<c:when test="${per.season == '2-3-4'}">
		여름,가을,겨울
		</c:when>
		<c:when test="${per.season == '1-2-3-4'}">
		봄,여름,가을,겨울
	</c:when>
	</c:choose>
	</td>
</tr>

<tr class="hidden"><td>탑노트번호 :</td><td>${per.topnote_num}</td></tr>
<tr class="hidden"><td>하트노트번호 :</td><td>${per.heartnote_num}</td></tr>
<tr class="hidden"><td>베이스노트번호 :</td><td>${per.basenote_num}</td></tr>
</c:forEach>
</table>



<c:forEach items="${getDetail}" var= "per">
	<c:if test="${sessionScope.id != null}">
		<div id="review" align = "center" >
			<form action="/main/review?writer=${sessionScope.id}&p_number=${per.p_number}&f_name=${per.f_name}" method="post" >
				<table>
				<tr>
					<td>${sessionScope.id}님 </td>
				</tr>
				<tr><td>긍정적 리뷰</td><td>부정적 리뷰</td></tr>
				<tr>
					<td><textarea cols="50" rows="10" name="like_re"></textarea></td>
					<td><textarea cols="50" rows="10" name="unlike_re"></textarea></td>
				</tr>
				
				</table>
			<input type="submit" value="입력"/>
			</form>
		</div>
	</c:if>
</c:forEach>


<c:forEach items="${getDetail}" var= "per">
	<c:if test="${sessionScope.kid != null}">
		<div id="review" align = "center" >
			<form action="/main/review?writer=${sessionScope.kid}&p_number=${per.p_number}&f_name=${per.f_name}" method="post" >
				<table>
				<tr>
					<td>${sessionScope.kid}님 </td>
				</tr>
				<tr><td>긍정적 리뷰</td><td>부정적 리뷰</td></tr>
				<tr>
					<td><textarea cols="50" rows="10" name="like_re"></textarea></td>
					<td><textarea cols="50" rows="10" name="unlike_re"></textarea></td>
				</tr>
				
				</table>
			<input type="submit" value="입력"/>
			</form>
		</div>
	</c:if>
</c:forEach>

<c:forEach items="${getReview}"  varStatus="status" var="re">
	<table align = "center">
	<tr>
		<td>${re.writer}님</td>
	</tr>
	<tr>
		<td>긍정적 리뷰 </td>
		<td>부정적 리뷰 </td>
	</tr>
	<tr>
		<td>${re.like_re}</td>
		<td>${re.unlike_re}</td>
	</tr>
	<tr>
		<td>${re.reg_date}</td>
	</tr>
	<tr>
		<td>${re.like_re_heart} 
		
		<c:if test="${sessionScope.kid != null}">
			<input type="button" onclick="window location ='/main/like?id=${sessionScope.kid}
			&p_number=${re.p_number}&r_number${re.r_number}&f_name${f_name}'"/></td>
		</c:if>
		
		<c:if test="${sessionScope.id != null}">
			<input type="button" onclick="window.location='/main/like?id=${sessionScope.id}&p_number=${re.p_number}&r_number=${re.r_number}&f_name=${getDetail[status.index].f_name}'" value="좋아요"/>
			${sessionScope.id} ${re.p_number}  ${re.r_number} ${getDetail[status.index].f_name} </td>
		</c:if>
		
		<td>${re.unlike_re_heart}</td>
	</tr>
	
	</table>
</c:forEach>









