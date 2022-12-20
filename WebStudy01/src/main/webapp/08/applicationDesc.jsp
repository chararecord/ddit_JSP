<%@page import="java.io.InputStream"%>
<%@page import="java.nio.file.StandardCopyOption"%>
<%@page import="java.nio.file.Files"%>
<%@page import="java.io.BufferedOutputStream"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.IOException"%>
<%@page import="java.io.BufferedInputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>08/applicationDesc.jsp</title>
</head>
<body>
<h4>application(ServletContext)</h4>
<pre>
	: 하나의 컨텍스트와 해당 컨텍스트를 운영중인 서버의 정보를 가진 객체 (singleton)
	(Servlet Container[WAS, JSP container] 와 커뮤니케이션 하기 위한 객체)
	
	1. MIME 확보 (서버가 가진 정보 획득) <!-- 마임에 대한 기본 정보를 톰캣이 가지고 있다는 의미 -->
		<%=application.getMimeType("test.jpg") %>
		<%=application.getMajorVersion() %>.<%=application.getMinorVersion() %> <!-- spec 정보 확인 가능 -->
		<%=application.getServerInfo() %> <!-- 서버는 뭐고 버전은 무엇인지 -->
		<%=application.getContextPath() %> 
		<%=request.getServletContext().getContextPath() %> <!-- 여기서 돌아오는 녀석은 application임, 이걸 줄여서 req.getContextPath로 사용 -->
	
	2. 컨텍스트 파라미터 획득
		<%=application.getInitParameter("imageFolder") %> <!-- application이 초기화될 때 전달되는 parameter를 꺼낸다 -->
	
	3. logging <% application.log("정상로그"); %> <!-- 지금은 휘발성, 남겨놓기 위해 로깅프레임워크를 사용해서 남김 => log4j 등 -->
	
	💜4💜. 현재 컨텍스트의 웹리소스 획득
		<%
			String imageURI = "/resources/images/cat1.jpg";
			String realPath = application.getRealPath(imageURI); /* 논리주소를 넣으면 물리주소 반환 */
			
			String saveFolderURI = "/09";
			String saveFolderPath = application.getRealPath(saveFolderURI); /* 논리주소를 넣으면 물리주소 반환 */
			
			File imageFile = new File(realPath);
			File destFile = new File(saveFolderPath, imageFile.getName());
			try(
				InputStream is = application.getResourceAsStream(imageURI); /* FileInputStream */
// 				FileInputStream fis = new FileInputStream(imageFile);
// 				BufferedInputStream bis = new BufferedInputStream(fis);
// 				FileOutputStream fos = new FileOutputStream(destFile);
// 				BufferedOutputStream bos = new BufferedOutputStream(fos);
			){
				
				Files.copy(is, destFile.toPath(), StandardCopyOption.REPLACE_EXISTING); /* 존재하면 새걸로 교체해줘^^ */
				
			} catch (IOException e){
				throw new RuntimeException(e); /* 원본 exception 유지 */
			}
		%>
		<%=imageFile.length() %>byte
		<%=realPath %>
</pre>
<img src="<%=request.getContextPath() %><%=saveFolderURI %>/<%=destFile.getName() %>" />
</body>
</html>