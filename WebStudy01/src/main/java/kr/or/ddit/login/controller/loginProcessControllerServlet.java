package kr.or.ddit.login.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.fasterxml.jackson.databind.util.ViewMatcher;

import kr.or.ddit.vo.MemberVO;

/**
 * 1. 검증에 통과하지 못했을 경우, 다시 로그인 폼으로 이동함
 * 2. 인증에 통과하지 못했을 경우, 다시 로그인 폼으로 이동함
 * 	- 비밀번호 오류 상태를 가정하고, 메시지 전달 -> alert 함수로 메시지 출력
 * 	- 이전에 입력받은 아이디의 상태를 유지함
 * 3. 인증 완료시에 웰컴 페이지로 이동함
 */
@WebServlet("/login/loginProcess.do")
public class loginProcessControllerServlet extends HttpServlet {	
	// 인증 성공 실패 여부 판단
	private boolean authenticate(MemberVO member) {
		return member.getMemId().equals(member.getMemPass());
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		1.
		HttpSession session = req.getSession();
		if(session.isNew()) { // 로그인 폼 받아갈 때가 첫 req임 이걸로 탔으면 거의 세션 하이재킹
			resp.sendError(400, "로그인 폼이 없는데 어떻게 로그인을 했니?ㅡㅡ? 다시 들어와라 얘");
			return;
		}
		String memId = req.getParameter("memId");
		String memPass = req.getParameter("memPass");
		String saveId = req.getParameter("saveId");
		
		MemberVO member = new MemberVO();
		member.setMemId(memId);
		member.setMemPass(memPass);
		
		boolean valid = validate(member);
		String viewName = null;
		
		// 인증시스템은 dispatcher 구조를 사용하지 않는다
		if(valid) {
//			2.4.
			if(authenticate(member)) {
				if(StringUtils.isBlank(saveId)) {
					session.setAttribute("authMember", member); // authMember O -> 로그인한 사람
					viewName = "redirect:/";
				}
				Cookie validId = new Cookie("validId", member.getMemId());
				validId.setMaxAge(60*60*24*5);
				resp.addCookie(validId);
				session.setAttribute("authMember", member); // authMember O -> 로그인한 사람
				viewName = "redirect:/";
			} else {
				session.setAttribute("validId", memId);
				session.setAttribute("message", "비밀번호 오류");
				viewName = "redirect:/login/loginForm.jsp";
			}
		} else {
			session.setAttribute("message", "아이디나 비밀번호 누락");
			viewName = "redirect:/login/loginForm.jsp";
		}
//		5.
		if(viewName.startsWith("redirect:")) {
			viewName = viewName.substring("redirect:".length());
			resp.sendRedirect(req.getContextPath() + viewName);
		} else {
			req.getRequestDispatcher(viewName).forward(req, resp);
		}
	}

	private boolean validate(MemberVO member) {
		boolean valid = true;
		
		if(StringUtils.isBlank(member.getMemId())) {
			valid = false;
		}
		if(StringUtils.isBlank(member.getMemPass())) {
			valid = false;
		}
		
		return valid;
	}
}
