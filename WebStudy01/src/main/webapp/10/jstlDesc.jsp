<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>10/jstlDesc.jsp</title>
</head>
<body>
<h4>JSTL (Jsp Standard Tag Library)</h4>
<pre>
	: 커스텀 태그들 중에서 많이 활용될 수 있는 것들을 모아놓은 라이브러리
	&lt;prefix:tagname attr_name="attr_value" &gt;
	1. 커스텀 태그 로딩 : taglib directive 사용
	2. prefix를 통한 태그 접근
	
	** core 태그 종류
	1. EL 변수(속성)와 관련된 태그 : set, remove
		<c:set var="sample" value="샘플값" scope="session" /> <!-- scope default가 page -->
		${sample }, ${sessionScope.sample }
		<c:remove var="sample" scope="session" /> <!-- 어느 영역에서 지우는지 명시해줘야함 -->
		--> ${sample }
	2. 조건문 : if(조건식){블럭문}, switch~case(조건값)...~default
		단일조건문 : if (else X)
			<c:if test="${empty param.name1 }">
				파라미터 없음.
			</c:if>
			<c:if test="${not empty param.name1 }">
				파라미터 있음.
			</c:if>
		다중조건문 : choose ~ when ~ otherwise
			<c:choose>
				<c:when test="${empty param.name1 }">
					파라미터 없음
				</c:when>
				<c:otherwise>
					파라미터 있음
				</c:otherwise>
			</c:choose>
	3. 반복문 : foreach, forTokens , for(선언절; 조건절; 증감절) for(임시블럭변수 : 반복대상집합객체)
		<c:set var="array" value='<%=new String[] {"value1", "value2"} %>' />
		<c:forEach var="i" begin="0" end="${fn:length(array)-1 }" step="1" varStatus="vs"> 
			${array[i] } --> 현재 반복의 상태(LoopTagStatus) : ${vs.index }, ${vs.count }, ${vs.first }, ${vs.last }
		</c:forEach>
		<c:forEach items="${array }" var="element">
			${element }
		</c:forEach>
		
		int num = 3;
		intnum=3;
		select mem_id from member;
		아버지가 방에 들어가신다
		아버지 가방에 들어가신다
		<c:forTokens items="아버지 가방에 들어가신다" delims=" " var="token">
			${token }
		</c:forTokens>
		<c:forTokens items="1,2,3,4" delims="," var="token">
			${token * 10 }
		</c:forTokens>
		
	4. 기타
		url 재작성 : url(client side path, session parameter), redirect
			<!-- 현재 클라이언트의 정보를 동적으로 판단, 쿠키 차단하면 세션파라미터를 url에 붙여버림 -->
			<c:url value="/06/memoView.jsp" />
			<a href='<c:url value="/10/jstlDesc.jsp" />'>세션 유지</a> <!-- 새로고침과 같은 효과 -->
<%-- 			<c:redirect url="/06/memoView.jsp" /> --%>
			<%--
				String location = request.getContextPath() + "/06/memoView.jsp";
				response.sendRedirect(location);
			--%>
		표현구조 : out
			<!--  -->
<%-- 			<jsp:include page=""></jsp:include> <!-- 동적내포 : A가 B의 결과물을 끌고올 때 사용, 동일한 context안에 있을 때만 끌고 올 수 있음 --> --%>
			<c:out value="<h4>출력값</h4>" escapeXml="false" />
</pre>
<!-- 크롤링(crawling)의 1단계 : 필요한 document를 외부에서 끌고왔음 -->
<c:import url="https://www.naver.com" var="naver" /> <!-- 동적내포 : context의 제한이 없음, var를 사용한다면 변수에 저장해둘 수 있음 -->
<c:out value="${naver }" escapeXml="true"></c:out>
</body>
</html>