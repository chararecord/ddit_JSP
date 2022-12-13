package kr.or.ddit.servlet05;

import java.io.IOException;
import java.util.Date;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/05/getServerTime")
public class GetServerTimeControllerServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*
		1. 1초마다 갱신되는 데이터 내보내기.. 우리는.. refresh header -> 동작 안할거야.. 화면에 락을 걸어야 하는 헤더거든.. 동작하지 않는다는 것을 먼저 확인
		2. 대안 찾기 비동기를.. 1초마다 발생시키기.. interval 함수 사용..
		*/
		
		// 1. 요청 분석
		// 요청 조건 : 헤더(accpet)와 파라미터(locale)
		String localeParam = req.getParameter("locale");
		System.out.println(localeParam);
		String accept = req.getHeader("Accept");

//		파라미터 locale에 따라, 로케일 객체 변경
		Locale clientLocale = req.getLocale();
		if(localeParam!=null && !localeParam.isEmpty()) {
			clientLocale = Locale.forLanguageTag(localeParam);
		}
		
		// 2. 모델 확보
		Date now = new Date();
		String nowSTr = String.format(clientLocale, "now : %tc", now); // formatting
		System.out.println(nowSTr);
		
		// 3. 모델 공유
		req.setAttribute("now", nowSTr);
		req.setAttribute("message", nowSTr);
		resp.setHeader("Refresh", "1");
		
		// 4. 뷰 선택
//		헤더 accept에 따라, viewName 변경
		String viewName = null;
		if(accept.contains("json")) {
			viewName = "/jsonView.do";
		} else if (accept.contains("plain")) {
			viewName = "/WEB-INF/views/04/plainView.jsp";
		} else {
			resp.sendError(HttpServletResponse.SC_NOT_ACCEPTABLE, accept + " mime은 생성할 수 없습니다.");
		}
		
		if(viewName==null && !resp.isCommitted()) {
			resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "viewName은 null일 수 없습니다.");
		} else {
			// 5. 뷰 이동
			req.getRequestDispatcher(viewName).forward(req, resp);
		}
	}
}
