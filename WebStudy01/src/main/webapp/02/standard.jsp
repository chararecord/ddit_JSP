<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	// java code : 전역코드 : 보통 파일의 맨 위에서 작성함
	String variable; // 지역변수
	private void test(){}
%> 
<h4> request parameter param1 : <%=request.getParameter("param1") %></h4>
<h4> request attribute attr1 : <%=request.getAttribute("attr1") %></h4>
<h4> session attribute attr1 : <%=session.getAttribute("attr2") %></h4>
<h4>JSP spec</h4>
<pre>
	: 서블릿 스펙에서 파생된 하위 스펙(전제조건), 템플릿 기반의 스크립트 형태를 가진 스펙.
	
	JSP 소스 표준 구성 요소
	1. 정적 텍스트 : 일반 텍스트, HTML, JavaScript, CSS
	2. backend sciprt code
		1) scriptlet :
			<%
				// java code : 지역코드
				String data = "데이터"; // 블럭변수
				Date now = new Date();
				// scriptlet 안에서 메소드 작성 불가
			%>
		2) directive : <%--<%@ page import="java.util.Date" %> --%> <!-- 자바의 import 구분을 사용하고 싶을 때 -->
			: JSP 페이지에 대한 부가설정이나 전처리 구문에 사용되며, 
				지시자의 이름과 속성들의 형태로 사용됨.
			page(required) : 페이지에 대한 환경 설정(부가설정)
			include(optional) : 정적 include
			taglib(optional) : 커스텀 태그 로딩. <!-- el, c:foreach 전부 커스텀 태그 -->
		3) expression : <%=data %>, <%=now %> <!-- 브라우저에 특정값 출력 -->
		4) declaration : <!-- 맨 위에 있슈 -->
		5) comment : <%-- --%>
			- client side comment : HTML, JS, CSS에서 사용되는 comment
<!-- 			comment html 주석-->
			- server side comment : java, jsp
			<% // java comment %>
			<%-- jsp commnet --%>
	3. action tag
	4. EL(표현언어)
	5. JSTL
</pre>
<script>
	/* comment javascript 주석*/
	console.log("body 랜더링 완료");
	console.log($("body")); /* A가 가지고 있는 BODY 참조 */
</script>