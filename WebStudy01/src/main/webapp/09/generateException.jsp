<%@page import="java.io.IOException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>09/generateException.jsp</title>
</head>
<body>
<h4>예외 처리 테스트</h4>
<%
	if(1==1)
		throw new IOException("강제로예외를발생시키겠다아");
	// checked인데 왜 컴파일 에러가 안나지? tomcat이 기다리면서 잡고 있었다
%>
</body>
</html>