<%@page import="java.io.FilenameFilter"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String imageFolder = application.getInitParameter("imageFolder");
	
	File folder = new File(imageFolder);
	File[] imageFiles = folder.listFiles(new FilenameFilter(){
		public boolean accept(File dir, String name){		
		String mime = application.getMimeType(name);
		return mime!=null && mime.startsWith("image/");
	
		}
	});
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="<%=request.getContextPath()%>/imageStreaming.do">
		<select name='image'>
		<% for(File tmp : imageFiles) { %>
			<option><%=tmp.getName() %>
		<% } %>
		</select>
		<input type='submit' value='전송' />
	</form>
</body>
</html>