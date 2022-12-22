package kr.or.ddit.login.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login/logout.do")
public class logoutControllerServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
//		session.removeAttribute("authMember");
		session.invalidate(); // 알아서 세션 속성을 싹 지워주고 현재 세션 강제 만료 시켜줌
		
		String viewName = "redirect:/";
		if(viewName.startsWith("redirect:")) {
			viewName = viewName.substring("redirect:".length());
			resp.sendRedirect(req.getContextPath() + viewName);
		} else {
			req.getRequestDispatcher(viewName).forward(req, resp);
		}
	}
}
