<%@page import="java.net.URLEncoder"%>
<%@page import="kr.or.ddit.commons.wrapper.CookieHttpServletRequestWrapper"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>11/cookieDesc.jsp</title>
</head>
<body>
<h4>Cookie</h4>
<pre>
	session(server) vs cookie(client)
		: http의 stateless 특성으로 인해 커뮤니케이션 정보가 유지되지 않는 경우, 사용하는 저장소의 개념
		
	사용 단계
	1. 쿠키 객체 생성(name, value)
	2. 응답(헤더, set-cookie)에 포함시켜 전송
	<%
		Cookie firstCookie = new Cookie("firstCookie", "firstValue");
		response.addCookie(firstCookie);
		String koreanValue = URLEncoder.encode("한글값", "UTF-8");
		Cookie koreanCookie = new Cookie("koreanCookie", koreanValue);
		response.addCookie(koreanCookie);
// 		Cookie domainCookie = new Cookie("domainCookie", "domain cookie value");
// 		domainCookie.setDomain("localhost");
// 		response.addCookie(domainCookie);
		Cookie otherPathCookie = new Cookie("otherPathCookie", "otherPathCookievalue");
		otherPathCookie.setPath(request.getContextPath() + "/12");
		response.addCookie(otherPathCookie);
		
		Cookie longLiveCookie = new Cookie("longLiveCookie", "longlong");
		longLiveCookie.setPath("/"); /* localhost기만 하면 어디서든 사용 가능 */
		longLiveCookie.setMaxAge(0);
		response.addCookie(longLiveCookie);
	%>
	
	3. 브라우저가 자기 저장소에 저장
	4. 다음번 요청(헤더, cookie)을 통해 재전송
	
	5. 요청에 포함된 쿠키를 통해 상태를 복원
	<a href="viewCookie.jsp">동일 경로에서 쿠키 확인</a>
	<a href="../12/viewCookie.jsp">다른 경로에서 쿠키 확인</a>
	<%--
		String findedValue = new CookieHttpServletRequestWrapper(request).getCookieValue("koreanCookie");
		out.println("쿠키값 : " + findedValue);
	--%>
	
	** 쿠키 속성들
	필수 속성
		name : 식별자
		value : String, url encoded value
	부가 속성
		domain(host) : 다음번에 요청에 포함시켜 재전송할지 여부를 결정하는 조건 <!-- 쿠키를 재전송할 때 재전송여부를 결정하는 첫번째 조건 -->
					ex) .naver.com, <!-- 호스트 상위의 레벨구조만 일치하면 전송 --> www.naver.com <!-- 여기에만 보냄 --> .com(X)
		path : 다음번에 요청에 포함시켜 재전송할지 여부를 결정하는 조건 <!-- 재전송여부를 결정하는 두번째 조건 -->
				path 설정이 명시되지 않은 경우, 쿠키 생성 경로가 반영됨
		maxAge : 쿠키 만료 시한, 기본값은 세션 만료 시한
				ex) -1, 브라우저 종료시 바로 삭제
					 0, longLiveCookie.setMaxAge(0) => 기존에 있던 쿠키를 삭제 (name, value.. 등 모든 속성이 동일한 쿠키인 경우 삭제 가능)
		secure...
</pre>
</body>
</html>