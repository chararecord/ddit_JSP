package kr.or.ddit.login.controller;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.exception.UserNotFoundException;
import kr.or.ddit.login.service.AuthenticateService;
import kr.or.ddit.login.service.AuthenticateServiceImpl;
import kr.or.ddit.vo.MemberVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 1. 검증에 통과하지 못했을 경우, 다시 로그인 폼으로 이동함
 * 2. 인증에 통과하지 못했을 경우, 다시 로그인 폼으로 이동함
 * 	- 비밀번호 오류 상태를 가정하고, 메시지 전달 -> alert 함수로 메시지 출력
 * 	- 이전에 입력받은 아이디의 상태를 유지함
 * 3. 인증 완료시에 웰컴 페이지로 이동함
 */
@Slf4j
@RequiredArgsConstructor // final 상수가 있으면 걔네를 모아서 생성자로 만들어주는 annotation
@Controller
public class LoginProcessController {	
	// 인증 성공 실패 여부 판단
	
	private final AuthenticationManager service;
	
	@PostConstruct
	public void init() {
		log.info("주입된 객체 : {}", service);
	}
	
	@RequestMapping(value="/login/loginProcess.do", method=RequestMethod.POST)
	public String process(HttpServletRequest req, HttpSession session, HttpServletResponse resp) throws ServletException, IOException {
//		1.
		if(session.isNew()) { // 로그인 폼 받아갈 때가 첫 req임 이걸로 탔으면 거의 세션 하이재킹
			resp.sendError(400, "로그인 폼이 없는데 어떻게 로그인을 했니?ㅡㅡ? 다시 들어와라 얘");
			return null;
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
			try {
				ServiceResult result = service.authenticate(member);
//				2.4.
				if(ServiceResult.OK.equals(result)) {
					Cookie saveIdCookie = new Cookie("savedId", member.getMemId());
					saveIdCookie.setDomain("localhost");
					saveIdCookie.setPath(req.getContextPath());
					int maxAge = 0;
					if(StringUtils.isNotBlank(saveId)) {
						maxAge = 60*60*24*5;
					}
					saveIdCookie.setMaxAge(maxAge);
					resp.addCookie(saveIdCookie);
					session.setAttribute("authMember", member); // authMember O -> 로그인한 사람
					viewName = "redirect:/";
				} else {
					session.setAttribute("validId", memId);
					session.setAttribute("message", "비밀번호 오류");
					viewName = "redirect:/login/loginForm.jsp";
				}
			} catch (UserNotFoundException e) {
				session.setAttribute("message", "존재하지 않는 회원입니다.");
				viewName = "redirect:/login/loginForm.jsp";
			}
		} else {
			session.setAttribute("message", "아이디나 비밀번호 누락");
			viewName = "redirect:/login/loginForm.jsp";
		}
		return viewName;
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
