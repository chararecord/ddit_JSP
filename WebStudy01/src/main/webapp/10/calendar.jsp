<%@page import="java.util.Locale"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.text.DateFormatSymbols"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	DateFormatSymbols dfs = DateFormatSymbols.getInstance(Locale.KOREA);
	String[] weekDays = dfs.getWeekdays();
	pageContext.setAttribute("weekDays", weekDays);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:set var="dayCount" value="1" />
<c:set var="offset" value="4" /> <!-- 12월 1일의 요일을 찾은 다음에 -1을 하면 됨 -->
<table border="1">
<thead>
	<tr>
		<c:forEach var="idx" begin="<%=Calendar.SUNDAY %>" end="<%=Calendar.SATURDAY %>">
			<td>${weekDays[idx] }</td>
		</c:forEach>
	<tr>
</thead>
<tbody>
	<c:forEach begin="1" end="6">
		<tr>
		<c:forEach begin="<%=Calendar.SUNDAY %>" end="<%=Calendar.SATURDAY %>">
			<td>${dayCount - offset }</td>
			<c:set var="dayCount" value="${dayCount+1 }" />
		</c:forEach>
		</tr>
	</c:forEach>
</tbody>
</table>
</body>
</html>