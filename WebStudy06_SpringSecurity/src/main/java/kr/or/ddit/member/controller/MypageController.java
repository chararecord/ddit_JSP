package kr.or.ddit.member.controller;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.MemberVOWrapper;

@Controller
public class MypageController extends HttpServlet {
	
	@Inject
	private MemberService service; // 서비스와의 의존관계
	
	@RequestMapping("/mypage.do")
	public String mypage(
			@AuthenticationPrincipal MemberVOWrapper user
			, @AuthenticationPrincipal(expression = "realMember") MemberVO member
			, Model model
	
	) throws ServletException, IOException {
		MemberVO authMember = user.getRealMember();
		model.addAttribute("member", member);
		return "member/memberView"; // logical view name
	}
}
