package kr.or.ddit.login.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LogoutController {
	
//	@RequestMapping(value="/login/logout.do", method=RequestMethod.POST)
	@PostMapping("/login/logout.do")
	public String process(HttpSession session) {
//		session.removeAttribute("authMember");
		session.invalidate(); // 알아서 세션 속성을 싹 지워주고 현재 세션 강제 만료 시켜줌
		
		return "redirect:/";
	}
}
 