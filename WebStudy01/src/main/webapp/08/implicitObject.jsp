<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!--     isErrorPage : 에러 처리 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>08/implicitObject.jsp</title>
</head>
<body>
<h4>기본객체(내장객체)</h4>
<pre>
	<%
// 		기본 객체는 총 9가지 지원
	%>
	💜💜💜
	request(HttpServletRequest) : 클라이언트와 그로부터 발생한 요청에 대한 정보를 캡슐화한 객체
	response(HttpServletResponse) : 서버에서 클라이언트로 전송되는 응답에 대한 정보를 캡슐화한 객체
	out(JspWriter) : == response.getWriter() 이 한 줄에 의해 만들어짐, response body에 content 기록(버퍼를 제어)할 때 활용
	session(HttpSession) : 한 클라이언트와 하나의 브라우저를 대상으로 생성되는 한 세션에 대한 정보를 캡슐화한 객체
	application(ServletContext) : 하나의 컨텍스트와 서버에 대한 정보를 캡슐화한 객체
	
	💜
	page(Object) == this와 비슷한 의미, custom tag 작성시 활용
					this : 서블릿 인스턴스의 대상, 자기가 참조하고 있는 인스턴스의 타입을 그대로 가지고 있는 대상 / page의 타입은 Object(다운캐스팅 必)
	config(ServletConfig) : 현재 서블릿의 설정 정보를 캡슐화한 객체, 톰캣이 내부적으로 사용하는 기본 객체
	
	💜💜💜💜💜
	pageContext(PageContext) : 현재 jsp 페이지에 대한 모든 정보를 캡슐화한 객체 (모든 기본 객체 중 가장 먼저 생성, 나머지 기본 객체는 얘한테서 파생되는 형태)
	ex) ${pageContext.request.contextPath} : el에서 제일 많이 사용, 유일하게 el에서 지원
	
	<!-- page isErrorPage="true" 적용하면 exception 생김 -->
	exception : 발생한 에러(예외)에 대한 정보를 캡슐화한 객체, page 지시자의 isErrorpage가 활성화된 경우에만 사용 가능, 모든 error와 exception의 최상위 객체
</pre>
</body>
</html>