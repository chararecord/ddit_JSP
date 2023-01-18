package kr.or.ddit.member.controller;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.validate.InsertGroup;
import kr.or.ddit.vo.MemberVO;
import lombok.extern.slf4j.Slf4j;

/**
 * Backend Controller(command handler) --> POJO (Plain Old Java Object)
 */
@Slf4j
@Controller
@RequestMapping("/member/memberInsert.do")
public class MemberInsertController {
	
	@Inject
	private MemberService memSerivce;
	
	// 핸들러 메소드 호출 전 얘를 먼저 호출함
	@ModelAttribute("member")
	public MemberVO member() {
		log.info("@ModelAttribute 메소드 실행 -> member 속성 생성");
		return new MemberVO();
	}
	
	@GetMapping
	public String memberForm(@ModelAttribute("member") MemberVO member) {
		// 가입양식
		return "member/memberForm";
	}
	
	@PostMapping
	public String memberInsert(
			HttpServletRequest req
			// @Valid - 검증해! but groupInt를 결정할 수 없는 annotation..
			// @@Validated - 검증해! groupInt를 결정할 수 있는 annotation..
			, @Validated(InsertGroup.class) @ModelAttribute("member") MemberVO member
			, Errors errors
	) throws ServletException, IOException {
		
		boolean valid = !errors.hasErrors();
		String viewName = null;
		
		log.info("member에 뭐가 들었슈 : {}", member);
		if(valid) {
			ServiceResult result = memSerivce.createMember(member);
			switch (result) {
			case PKDUPLICATED:
				req.setAttribute("message", "아이디 중복");
				viewName = "member/memberForm";
				break;
			case FAIL:
				req.setAttribute("message", "서버에 문제 있음. 다시 가입ㄱㄱ");
				viewName = "member/memberForm";
				break;
			default:
				viewName = "redirect:/";
				break;
			}
		} else {
			viewName = "member/memberForm";
		}
		return viewName;
	}
}
