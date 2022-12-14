<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>05/flowControl.jsp</title>

<!-- 동적내포 -->
<%-- <jsp:include page="/includee/preScript.jsp" /> --%>
<%-- <%=varOnPre %> => compile error -> 소스로 들어오는 게 아니다 --%>
<%@ include file="/includee/preScript.jsp" %>
<%-- <%=varOnPre %> => error 안남 -> 실행 전 jsp 파일 그 자체로 들어옴 --%>
</head>
<body>
<h4>흐름 제어 방법</h4>
<pre>
	Http : Connetless, Stateless <!-- 를 정확하게 이해해야 밑에 구조를 이해할 수 있음, 이 단점을 파훼하기 위해서 session, cookie 사용 -->
	1. 요청 분기(request dispatch) : A를 대상으로 한 최초의 요청이 계속 유지됨 <!-- 가장 많이 활용되는 게 모델2 아키텍쳐 -->
		1) forward(Model2) : A(request 처리, controller) -> B(response 생성, view) 이동 후의 최종 응답은 B에서 전송
		2) include(페이지 모듈화) : A -> B -> A 최종 응답에 A+B 의 모든 데이터가 포함
			<!-- 실행 시점이 기준 -->
			내포되는 시점과 내포되는 대상에 따라 분류됨
			- 정적 내포 : 컴파일 전에 소스가 파싱되는 단계에서 소스파일이 내포됨
			- 동적 내포 : 실행시에 실행의 결과 데이터가 내포됨
		<%
			request.setAttribute("att1", new Date()); // parameter -> dataType이 문자열 한정, attribute -> dataType 한정되지 X
			String path = "/02/standard.jsp";
// 			request.getRequestDispatcher(path).forward(request, response); // 이동 전 최초로 받았던 req를 가지고 넘어감
// 			request.getRequestDispatcher(path).include(request, response); // 이동 전 최초로 받았던 req를 가지고 넘어감 => 요청 분기
			pageContext.include(path); // 우리가 사용하는 8kb짜리 버퍼 -> 버퍼가 어떻게 활용되고 있는지 알아야하고, 그러려면 io를 파야함
		%>
	2. Redirect :
		A -> response body가 없고, Line(302) + Header(Location)로만 구성된 응답이 전송
		  -> Location 방향으로 새로운 요청을 전송함
		  -> B에서 Body를 가진 최종 응답이 전송됨
		<%--
			session.setAttribute("attr2", "세션 속성");
			String location = request.getContextPath() + path; // 주소를 사용하는 대상이 달라졌기 때문에 server에서 client side 방식으로 주소를 표현해야함
			response.sendRedirect(location);
// 			response.sendRedirect(location +"?param1="+request.getParameter("param1")); // 직접 세팅해주지 않는 한 그 이전 요청이 가지고 있던 정보를 전달하는 방법은 X
		--%>
</pre>
</body>
</html>