package kr.or.ddit.member.controller;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.vo.MemberVO;

@Controller
public class MemberDeleteController {
	@Inject
	private MemberService service;

	// 아이디와 비밀번호의 인증 시스템에서는 dispatcher를 사용하지 안흔ㄴ다
	@RequestMapping(value="/member/memberDelete.do", method=RequestMethod.POST)
	public String memberDelete(
			@RequestParam(value="memPass", required=true) String memPass
			, @SessionAttribute(value="authMember", required=true) MemberVO authMember
			, HttpSession session
			, RedirectAttributes redirectAttribute	
	) throws ServletException, IOException {
		
		String memId = authMember.getMemId();
		
		MemberVO inputData = new MemberVO();
		inputData.setMemId(memId);
		inputData.setMemPass(memPass);
		
		String viewName = null;
		ServiceResult result = service.removeMember(inputData);
		switch (result) {
		case INVALIDPASSWORD:
			redirectAttribute.addFlashAttribute("message", "비밀번호 오류"); // 따로 삭제할 필요 X
			viewName = "redirect:/mypage.do";
			break;
		case FAIL:
			redirectAttribute.addFlashAttribute("message", "서버 오류");
			viewName = "redirect:/mypage.do";
			break;
		default:
			session.invalidate(); // 로그아웃시키기
			viewName = "redirect:/";
			break;
		}
		return viewName;
	}
}
