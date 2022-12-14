<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" buffer="8kb"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>05/responseDesc.jsp</title>
</head>
<body>
<h4>response(HttpServletResponse)</h4>
<pre>
	Http의 response packaging
	1. Response line : Status Code(응답상태코드, XXX)
		100 ~ : 커넥션이 계속 유지가 되는 ~ ing ~ 구조, WebSocket에서 사용하는 코드
		200 ~ : OK
		<!-- 서버나 프레임워크 내부에서 자동 설정되는 상태코드 -->
		300 ~ : 최종 처리하기 위해 클라이언트의 추가 액션이 필요함. (response body가 없음)
			304(cache data관련) : Not Modified
			301/302/307 : Moved + Location response header와 함께 사용 (redirect request)
			<%--
				// 이동 방식의 차이
// 				request.getRequestDispatcher("/04/messageView.jsp").forward(request, response); /* 서버 내에서 이동 */
				String location = request.getContextPath() + "/04/messageView.jsp";
				response.sendRedirect(location); /* 클라이언트로부터 새로운 요청 발생 -> 그 요청에 의해 이동 */
			--%>
		<!-- 개발자가 직접 세팅해줘야하는 상태코드 -->	
		400 ~ : client side error -> Fail
			400 : <%=HttpServletResponse.SC_BAD_REQUEST %>, 클라이언트 전송 데이터(parameter) 검증시 활용 <!-- 필요한 parameter값이 안들어왔거나 잘못된 값이 들어왔을 때 -->
			401 / 403 : 인증(Authentication, 신원확인과정)과 인가(Authorization, 권한부여여부확인) 기반의 접근 제어에 활용
				<%=HttpServletResponse.SC_UNAUTHORIZED %>, <%=HttpServletResponse.SC_FORBIDDEN %>
			404 : <%=HttpServletResponse.SC_NOT_FOUND %> <!-- URI, MESSAGE 자원이 잘못됬거나 존재하지 않을 때 -->
			405 : <%=HttpServletResponse.SC_METHOD_NOT_ALLOWED %>, 현재 요청의 메소드에 대한 콜백 메소드가 재정의되지 않았을 때 <!-- do계열 method 오류일 때 -->
			406 / 415 : content-type(MIME)과 관련된 상태 코드
				<%=HttpServletResponse.SC_NOT_ACCEPTABLE %>, Accpet request header에 설정된 MIME 데이터를 만들어 낼 수 없을 때 406
					ex) accpet : application/json
						content-type : application/json(XXX)
				<%=HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE %>, Content-Type request header를 해석할 수 없을 때 415
					ex) accpet : application/json --> unmarshalling(XXX)
		500 ~ : server side error -> Fail
	2. Response Header : meta data
		1) Content(body)에 대한 부가정보 설정 : Content-* 시작하는 헤더 존재, Contet-Type(MIME), Content-Length(size)
										 Content-Disposition(content name, 첨부여부)
		<%-- 참고용으로만 기억할 것
			response.setHeader("Content-Disposition", "inline[attatchment];filename=\"파일명\""); /* response의 metaData도 문자기반 */
		--%>
		2) Cache control : 자원에 대한 캐싱 설정
		3) Auto Request : 주기적으로 갱신되는 자원에 대한 자동 요청
		4) Location 기반의 이동구조(Redirection)
	3. Response Body(Content body, message body) :
<%-- 		response.getWirter(), response.getOutputStream(), <%= %>, out --%>
</pre>
</body>
</html>