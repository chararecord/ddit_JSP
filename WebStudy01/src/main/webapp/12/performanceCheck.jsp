<%@page import="java.sql.SQLException"%>
<%@page import="java.util.ArrayList"%>
<%@page import="kr.or.ddit.vo.MemoVO"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="kr.or.ddit.db.ConnectionFactory"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>12/performanceCheck.jsp</title>
</head>
<body>
<h4>성능 고려사항</h4>
<pre>
	응답 소요 시간 : latency time(99.999% - 네트워크지연시간) + processing time
	case 1 - 21ms - 전체 한번 실행
	case 2 - 1947ms, DBCP case 4 - 30ms - connection, query 100번씩
	case 3 - 44ms - 쿼리 100번씩
	 
	
	=> 커넥션을 미리 생성해놓는다면(?!) 서버가 하루에 감당할 수 있는 트래픽 계산, 감당할 수 있는 커넥션을 미리 생성해놓는다(따로 관리 필요)
		커넥션을 담을 수 있는 그릇(pool)
		1. 풀을 만들어 관리해야 하고
		2. 그걸 관리하는 알바생이 필요하다
		3. 풀에 일정 커넥션을 담아 보관할 수 있는 구조가 필요 (connection pooling) <!-- 웹어플 만들 때 필수 -->
	<%
		long startTime = System.currentTimeMillis();
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT CODE, WRITER, CONTENT, \"DATE\" FROM TBL_MEMO ");
		for(int i=1; i<=100; i++){
			try(
				Connection conn = ConnectionFactory.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			){
				ResultSet rs = pstmt.executeQuery();
				List<MemoVO> list = new ArrayList<>();
				while(rs.next()){
					MemoVO vo = new MemoVO();
					vo.setCode(rs.getInt("code"));
					vo.setWriter(rs.getString("writer"));
					vo.setContent(rs.getString("content"));
					vo.setDate(rs.getString("date"));
					list.add(vo);
				}
			} catch(SQLException e){
				throw new RuntimeException(e); /* 예외정보 바꿔치기 */
			}
		}
		long endTime = System.currentTimeMillis();
	%>
	소요시간 : <%=endTime-startTime %>ms
</pre>
</body>
</html>