<%@page import="java.util.Map.Entry"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	/* 입력했던 방식에 맞춰서, 항상 데이터를 꺼내기 전에 먼저 작성하기 */
	request.setCharacterEncoding("EUC-KR");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<pre>
	request line : <%=request.getRequestURL() %>
	request line->queryString : <%=request.getQueryString() %> <!-- 서버가 갖고 있던 string 원형 -->
	<!-- 서버보다 먼저 data를 꺼냈기 때문에 얘가 있으면 출력 X -->
	request body : <%=request.getInputStream().available() %>
	
	*** 표준 입력방식(form)을 통해 입력된 파라미터 (String) 확보
	String getParameter(name)
	String[] getParameterValus(name)
	Enumeration&lt;String&gt; getParameterNames()
	Map&lt;String,String[]&gt; getParameterMap();
</pre>
<table>
	<thead>
		<tr>
			<th>파라미터명</th>
			<th>파라미터값(들)</th>
		</tr>
	</thead>
	<tbody>
		<%
			Enumeration<String> names = request.getParameterNames();
			while(names.hasMoreElements()){
				String parameterName = names.nextElement();
				String[] values = request.getParameterValues(parameterName);
		%>
			<tr>
				<td><%=parameterName %></td>
				<td><%=Arrays.toString(values) %></td>
			</tr>
		<%
			}
		%>
	</tbody>
</table>
<table>
	<thead>
		<tr>
			<th>파라미터명</th>
			<th>파라미터값(들)</th>
		</tr>
	</thead>
	<tbody>
		<%
			Map<String, String[]> parameterMap = request.getParameterMap();
			for(Entry<String, String[]> entry : parameterMap.entrySet()){
				String parameterName = entry.getKey();
				String[] values = entry.getValue();
		%>
			<tr>
				<td><%=parameterName %></td>
				<td><%=Arrays.toString(values) %></td>
			</tr>
		<%
			}
		%>
	</tbody>
</table>
</body>
</html>