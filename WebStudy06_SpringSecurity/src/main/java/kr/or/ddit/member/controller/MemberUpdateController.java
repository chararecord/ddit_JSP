package kr.or.ddit.member.controller;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.validate.UpdateGroup;
import kr.or.ddit.vo.MemberVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/member/memberUpdate.do")
public class MemberUpdateController {
	private final MemberService service;

	@GetMapping
	public String updateForm(
			//TODO 나중에 내가 직접 나만의 anntation과 resolver를 만들어봐~ㅎ
			@SessionAttribute("authMember") MemberVO authMember
			, Model model
	) {
		// 수정 폼 제공
//		MemberVO authMember = (MemberVO) session.getAttribute("authMember");
		MemberVO member = service.retrieveMember(authMember.getMemId());
		model.addAttribute("member", member);
		return "member/memberForm";
	}

	@PostMapping
	public String updateProcess(
			@Validated(UpdateGroup.class) @ModelAttribute("member") MemberVO member
			, Model model
			, BindingResult errors
			, HttpSession session) throws IOException {
		
		String viewName = null;
		
		if(!errors.hasErrors()) {
			ServiceResult result = service.modifyMember(member);
			switch (result) {
			case INVALIDPASSWORD:
				model.addAttribute("message", "비밀번호 오류");
				viewName = "member/memberForm";
				break;
			case FAIL:
				model.addAttribute("message", "서버에 문제 있음. 다시 수정ㄱㄱ");
				viewName = "member/memberForm";
				break;
			default:
				// 로그인 했을 때 만들었던 authMember도 바꿔야함 -> 어떻게?
				MemberVO modifiedMember = service.retrieveMember(member.getMemId());
				// 세션에다가 넣어줄 때는 session 필요, 뺄 때는 필요 X
				session.setAttribute("authMember", modifiedMember);
				viewName = "redirect:/mypage.do";
				break;
			}
		} else {
			viewName = "member/memberForm";
		}
		
		return viewName;
	}
}
