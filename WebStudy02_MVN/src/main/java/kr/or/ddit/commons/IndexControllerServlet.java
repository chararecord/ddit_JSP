package kr.or.ddit.commons;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/index.do")
public class IndexControllerServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		1. 요청 분석
//		2. 모델 확보
//		3. 모델 공유
//		4. 뷰 선택
//		5. 뷰 이동
		req.setAttribute("contentPage", "/WEB-INF/views/index.jsp");
		String viewName = "/WEB-INF/views/layout.jsp";
		req.getRequestDispatcher(viewName).forward(req, resp);
	}
}
