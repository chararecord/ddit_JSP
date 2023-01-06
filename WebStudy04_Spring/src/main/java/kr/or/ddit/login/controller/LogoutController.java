package kr.or.ddit.login.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.mvc.annotation.RequestMethod;
import kr.or.ddit.mvc.annotation.stereotype.Controller;
import kr.or.ddit.mvc.annotation.stereotype.RequestMapping;

@Controller
public class LogoutController {
	
	@RequestMapping(value="/login/logout.do", method=RequestMethod.POST)
	public String process(HttpSession session) {
//		session.removeAttribute("authMember");
		session.invalidate(); // 알아서 세션 속성을 싹 지워주고 현재 세션 강제 만료 시켜줌
		
		return "redirect:/";
	}
}
 