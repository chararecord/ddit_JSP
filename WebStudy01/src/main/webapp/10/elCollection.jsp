<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.stream.Collectors"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.Set"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>10/elCollection.jsp</title>
</head>
<body>
<h4>EL에서 집합 객체 접근 방법</h4>
<%
	String[] array = new String[]{"value1", "value2"};
	List<String> list = Arrays.asList(array);
	Set<String> set = list.stream().collect(Collectors.toSet());
	
	Map<String,Object> map = new HashMap<>();
	map.put("key1", "value1");
	map.put("key 2", "value2");
	
	pageContext.setAttribute("array", array);
	pageContext.setAttribute("list", list);
	pageContext.setAttribute("set", set);
	pageContext.setAttribute("map", map);
	
	pageContext.setAttribute("memo", null);
%>
<pre>
	array : <%--=array[3] --%>, ${array[3]}
	<!-- el은 데이터 출력이 목적이지 제어가 목적이 아님. 예외가 발생하더라도 처리하는 게 목적이 아니라는 말. el을 사용할 때 어지간한 예외는 화이트스페이스처리됨 -->
	list : <%--=list.get(3) --%>, ${list[3] }, ❌${list.get(1) }❌ <!-- el에서는 메소드를 직접 호출하지 않는다 -->
	ex) memo's writer : ${memo.writer }, ${memo['writer'] }, \${memo.getWriter() }
	set : <%=set %>, ${set } <!-- set에서는 몇번째 element를 꺼내는 것이 불가능 -->
	map : <%=map.get("key-1") %>, ${map.get('key1') }, ${map.key-1 }, ${map['key1'] }
	<%=map.get("key 2") %>, ${map.get("key 2") }, \${map.key 2 }, ${map['key 2'] }
</pre>
</body>
</html>