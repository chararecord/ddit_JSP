<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>08/sessionDesc.jsp</title>
<jsp:include page="/includee/preScript.jsp" />
<script src="<%=request.getContextPath() %>/resources/js/custom.js"></script>
<%-- <script src="<%=request.getContextPath() %>/resources/js/custom.js" /> -> 태그에 바디가 없으면 script 넣는 공간 X --%>
</head>
<body>
<h4>session(HttpSession)</h4>
<h4 id="timerArea"></h4>
<pre>
	(웹)세션이란?
		: 어플리케이션 서버를 사용하기 시작한 순간부터 사용 종료까지의 기한
		
	시작(생성) : 클라이언트로부터 최초 요청(재전송되는 아이디가 없는 요청)이 발생했을 때 -> 식별자가 부여된 세션이 새로 생성
				-> 세션 아이디가 요청에 대한 응답이 전송될 때 응답 헤더에 포함되어 클라이언트로 전송
		세션 아이디 : <%=session.getId() %>
		세션 생성 시점 : <%=new Date(session.getCreationTime()) %>
		마지막 요청 시점 : <%=new Date(session.getLastAccessedTime()) %>
		timeout : <%=session.getMaxInactiveInterval() %>s
				
		유지(tracking mode) : 세션 식별자(세션 아이디) 재전송 구조(공통점)
			<!-- COOKIE, URL -> 어떤 형태던 sessionId를 재전송 시킴 -->
			1) COOKIE
			2) URL : <a href="sessionDesc.jsp;jsessionid=<%=session.getId() %>">URL트래킹모드</a> <!-- 보안취약 -->
			3) SSL(Secure Socket Layer)
			<!-- 키를 소유하고 있어야 함 -->
	종료(만료)
		1) 세션의 아이디가 재전송되지 않을 때 ex) 세션과 관련된 쿠키 삭제
		2) 브라우저가 종료될 때
		3) session timeout 이내에 새로운 요청을 통해 아이디가 재전송되지 않을 때
		4) session invalidation(명시적인 로그아웃)
</pre>
<div id="msgArea"> 
	세션을 연장하겠습니까?
	<input type="button" value="예" class="controlBtn" id="YES" />
	<input type="button" value="아니오" class="controlBtn" id="NO" />
</div>
<script type="text/javascript">
// 	이벤트 전파구조 (Event propagation) : bubbling 방식
// 	$(document).on("click", ".controlBtn", function(){});
	$("#timerArea").sessionTimer(${pageContext.session.maxInactiveInterval}, {
		msgAreaSelectoer : "#msgArea",
		btnSelector : ".controlBtn"
	});

<%-- 	let timeout = <%=session.getMaxInactiveInterval() %> --%>
// 	let area = $("#timerArea")
// 	area.sessionTimer(timeout);
	</script>
<jsp:include page="/includee/postScript.jsp" />
</body>
</html>