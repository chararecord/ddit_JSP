package kr.or.ddit.member.controller;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

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
	public String mypage(Model model, MemberVOWrapper principal) throws ServletException, IOException {
//		MemberVO authMember = (MemberVO) session.getAttribute("authMember");
//		MemberVOWrapper principal = (MemberVOWrapper) req.getUserPrincipal();
		MemberVO authMember = principal.getRealMember();
		
		MemberVO member = service.retrieveMember(authMember.getMemId());
		
//		req.setAttribute("member", member); - 의미 없어짐
		model.addAttribute("member", member);
		return "member/memberView"; // logical view name
	}
}
