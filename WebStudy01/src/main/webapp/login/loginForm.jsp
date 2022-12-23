<%@page import="kr.or.ddit.commons.wrapper.CookieHttpServletRequestWrapper"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:if test="${not empty message }">
	<script>
		alert("${message}");
	</script>
	<c:remove var="message" scope="session"/>
</c:if>
<body>
	<form method="post" action='<c:url value="/login/loginProcess.do" />'>
		<ul>
			<li>
				<c:set var="savedId" value="${cookie['savedId']['value'] }" /> <!-- 속성에 저장해두자 -->
				<input type="text" name="memId" placeholder="아이디" value="${not empty validId ? validId : savedId }"/>
				<input type="checkbox" name="saveId" ${not empty savedId ? 'checked' : ''}/>아이디기억하기
				<!-- 해당 아이디의 기억 시간은 5일, 체크했을 때는 최대 5일까지 아이디를 기억 시키자 -->
				<!-- 체크하지 않았는데 로그인 성공? 기존에 저장되어있는 쿠키까지 제거할 수 있어야함 -->
				<!-- 체크했을 때만 고려...?ㅠㅠ?ㅠㅠ???ㅠ?ㅠ?ㅠ?ㅠ?ㅠ?ㅠ?ㅠ??ㅠㅠ??ㅠ?ㅠ??
				 -->
				<c:remove var="validId" scope="session"/>
			</li>
			<li>
				<input type="password" name="memPass" placeholder="비밀번호" />
				<input type="submit" value="로그인" />
			</li>
		</ul>
	</form>
</body>
<script type="text/javascript">
</script>
</html>