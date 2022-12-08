<%@page import="java.nio.file.StandardCopyOption"%>
<%@page import="java.nio.file.Paths"%>
<%@page import="java.nio.file.Files"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.net.URLConnection"%>
<%@page import="java.net.URL"%>
<%@page import="kr.or.ddit.servlet01.DescriptionServlet"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>03/resourceIdentify.jsp</title>
</head>
<body>
<h4>자원의 종류와 식별방법</h4>
<pre>
	: 자원의 위치와 경로 표기 방법에 따라 분류
	
	<!-- 물리주소를 통해 접근 가능 -->
	1. File System resource : d:/contents/images/cat1.jpg
	<%
		String realPath = "d:/contents/images/cat1.jpg";
		File fileSystemResource = new File(realPath);
	%>
	파일의 크기 : <%=fileSystemResource.length() %>
	
	<!-- 논리주소를 통해 접근 가능 -->
	<!-- 물리주소를 찾아내기 위한 중간과정 필요 -->
	2. Class Path resource : /kr/or/ddit/images/cat2.png
	<%
// 		String qualifiedName = "/kr/or/ddit/images/cat2.png";
		String qualifiedName = "../images/cat2.png";
		realPath = DescriptionServlet.class.getResource(qualifiedName).getFile();
		realPath = DescriptionServlet.class.getClassLoader().getResource("kr/or/ddit/images/cat2.png").getFile();
		File classPathResource = new File(realPath);
	%>
	실제 경로 : <%=realPath %>
	파일의 크기 : <%=classPathResource.length() %>
	
	3. Web resource : https://www.google.com/logos/doodles/2022/seasonal-holidays-2022-6753651837109831.3-law.gif
	http://localhost/WebStudy01/resources/js/jquery-3.6.1.min.js
	<%
// 		String resouceURL = "https://www.google.com/logos/doodles/2022/seasonal-holidays-2022-6753651837109831.3-law.gif";
		String resouceURL = "http://localhost/WebStudy01/resources/js/jquery-3.6.1.min.js";
		URL url = new URL(resouceURL);
		URLConnection conn = url.openConnection();
		String resourcePath = url.getPath();
		int lastIdx = resourcePath.lastIndexOf('/');
		String fileName = resourcePath.substring(lastIdx+1);
		String folderPath = "d:/contents/images";
		File downloadFile = new File(folderPath, fileName);
		InputStream is = conn.getInputStream();
		Files.copy(is, Paths.get(downloadFile.getPath()), StandardCopyOption.REPLACE_EXISTING);
	%>
	resourcePath : <%=resourcePath %>
	
	*** 웹자원에 대한 식별성 : URI
	URI (Uniform Resource Identifier) : 범용 자원 식별자
	
	URL (Uniform Resource Locator) : 범용 자원 위치자
	URN (Uniform Resource Name) : 범용 자원 이름
	URC (Uniform Resource Content) : 범용 자원 컨텐츠
	
	URL 구조
	protocol(scheme)://IP(DN):port/contextName/depth1...depthN/resourceName
	// : 루트를 표현하기 위한 구분자
	
	DomainName
	3 level : www.naver.com		GlobalTopLevelDomain   : GTLD - com (기관에 대한 정보만 내포)
	4 level : www.naver.co.kr	NationalTopLevelDomain : NTLD - kr (국가를 지칭)
	
	URL 표기 방식
	절대경로와 상대경로의 차이? 앞에 슬래시가 있냐 없냐
	절대경로(**) : 최상위 루트부터 전체 경로 표현 - 생략 가능한 요소 존재
		client side : /WebStudy01/resources/images/cute7.JPG
					  context path부터 시작됨
		server side : /resources/images/cute7.JPG
					  context path 이후의 경로 표기
	상대경로 : 기준점(브라우저의 현재 주소)을 중심으로 한 경로 표현
</pre>
<%
// 	InputStream is2 = application.getResourceAsStream("/resources/images/cute7.JPG");
	String realPath1 = application.getRealPath("/resources/images/cute7.JPG");
	String realPath2 = application.getRealPath(request.getContextPath() + "/resources/images/cute7.JPG");

	request.getRequestDispatcher("/WEB-INF/views/depth1/test.jsp").forward(request, response);
	response.sendRedirect(request.getContextPath() + "/member/memberForm.do");
%>
<img src="<%=request.getContextPath() %>/resources/images/cute7.JPG" />
<img src="../resources/images/cute7.JPG" />
<img src="cute7.JPG" /> <br/>
<%-- 서버사이드 방식으로 접근한 파일의 크기 : <%=is2.available() %> --%>
realPath1 = <%=realPath1 %> <br/>
realPath2 = <%=realPath2 %> <!-- 이미 본인의 contextPath를 알고 있는 server.. -->
</body>
</html>