package kr.or.ddit.member.controller;

import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.mvc.annotation.RequestMethod;
import kr.or.ddit.mvc.annotation.resolvers.ModelAttribute;
import kr.or.ddit.mvc.annotation.stereotype.Controller;
import kr.or.ddit.mvc.annotation.stereotype.RequestMapping;
import kr.or.ddit.mvc.view.InternalResourceViewResolver;
import kr.or.ddit.validate.InsertGroup;
import kr.or.ddit.validate.ValidationUtils;
import kr.or.ddit.vo.MemberVO;

/**
 * Backend Controller(command handler) --> POJO (Plain Old Java Object)
 */
@Controller
public class MemberInsertController {
	private MemberService memSerivce = new MemberServiceImpl();
	
	@RequestMapping("/member/memberInsert.do")
	public String memberForm() {
		// 가입양식
		return "member/memberForm";
	}
	
	@RequestMapping(value="/member/memberInsert.do", method=RequestMethod.POST)
	public String memberInsert(
			HttpServletRequest req
			, @ModelAttribute("member") MemberVO member
	) throws ServletException {
		
		// 여기에 검증 검증 결과는 error라는 맵이 가지고 있을거고, 잘못됬다면 client에게 알려조야함
		Map<String, List<String>> errors = new LinkedHashMap<>();
		req.setAttribute("errors", errors);
		
		boolean valid = ValidationUtils.validate(member, errors, InsertGroup.class);
		String viewName = null;
		
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
