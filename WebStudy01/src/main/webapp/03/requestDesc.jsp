<%@page import="com.sun.xml.internal.ws.api.pipe.NextAction"%>
<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h4>request (HttpServletRequest)</h4>
<form method="">
</form>
<pre>
	Http의 요청 패키징 방식
	: 자원에 대한 식별 + 자원에 대한 행위 정보를 기본으로 함
	
	1. Request Line : URI, http(request) Method
		request Method : 행위 정보, 요청의 의도(목적)
		<!-- 표준메서드 -->
		GET(R)
		POST(C)
		<!-- 비표준메서드 -->
		PUT/PATCH(U)
			- 동적으로 파악되는 일부 데이터만 수정 - patch <- doPut에 포함
		 	- 모든 데이터를 한번에 다 수정 - put (중프때 했던 방식)
		DELETE(D)
		HEAD : 응답데이터의 패키징 구조 (LINE + HEADER)
			- response line과 header만 가져오고 싶을 때 (body 없는 응답, ex.세션 연장할 때)
		OPTIONS : 현재 서버가 특정 메소드를 지원하는지 여부를 확인하기 위한 사전 요청(preFlight request)에 사용
		TRACE : 서버 디버깅 용도로 제한적으로 사용 (by 클라이언트)
		
		ex) /member/memberInsert.do <!-- request Line을 효과적으로 사용하고 있지 못함 -->
		
			** RESTFul URI 구조 (자원식별과 행위를 분리하자) - JSON/XML로 자원표현
			/member      GET <!-- 전체회원조회 -->
			/member/a001 GET <!-- a001회원조회 -->
			/member/a001 PUT <!-- a001회원정보수정 -->
			/member/a001 DELETE <!-- a001회원정보삭제 = 탈퇴 -->
			/member POST <!-- 회원정보등록 = 가입 -->
			=> URI는 하나만 있으면 되고 그냥 Method를 바꿔가면서 표현할 수 있다
				순수하게 그 응답 데이터만 제공하고자 하면 xml, json 방식으로 응답해야함
				html로 응답한다면 그건 RESTFul스럽지 않은 응답
			<%
				String requestURI = request.getRequestURI();
				StringBuffer requestURL = request.getRequestURL();
				String method = request.getMethod();
			%>
			requestURI : <%=requestURI %>
			requestURL : <%=requestURL %>
			request method : <%=method %>
			
	2. Request Header : 클라이언트에 대한 부가정보(meta data)
						이름-값의 쌍으로 구성된 "문자" 데이터
			<%
				String userAgent = request.getHeader("User-Agent");
				out.println(userAgent);
				request.getHeaderNames();
			%>
	3. Request Body(optional) : POST, PUT, 
								클라이언트가 서버로 보내는 컨텐츠 영역 (Content-Body, Message-Body)
			<%=request.getInputStream().available() %>
</pre>
<table border="1">
	<thead>
		<tr>
			<th>헤더명</th>
			<th>헤더값</th>
		</tr>
	</thead>
	<tbody>
		<%
			Enumeration<String> em = request.getHeaderNames();
			while(em.hasMoreElements()) {
				String header = em.nextElement();
		%>
		<tr>
			<td><%=header %></td>
			<td><%=request.getHeader(header) %></td>
		</tr>
		<%
			}
		%>
	</tbody>
</table>

</body>
</html>