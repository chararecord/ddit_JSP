<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 페이지 전체의 레이아웃을 구성하는 jsp 하나 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="/includee/preScript.jsp" />
<!-- 전체페이지의 일부분, 조각 jsp 하나 -->
</head>
<body>
<h4><%=request.getHeader("user-agent") %>, ${header['user-agent']}</h4>
<h4>jQuery 와 BootStrap 사용 가능한 페이지</h4>
<jsp:include page="${contentPage}" />
</body>
<jsp:include page="/includee/postScript.jsp" />
</html>