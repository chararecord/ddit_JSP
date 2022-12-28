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
import kr.or.ddit.mvc.view.InternalResourceViewResolver;
import kr.or.ddit.validate.InsertGroup;
import kr.or.ddit.validate.ValidationUtils;
import kr.or.ddit.vo.MemberVO;

@WebServlet("/member/memberInsert.do")
public class MemberInsertControllerServlet extends HttpServlet {
	private MemberService memSerivce = new MemberServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 가입양식
		String viewName = "member/memberForm";
		new InternalResourceViewResolver("/WEB-INF/views/", ".jsp").resolveView(viewName, req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		1. 검증 포함
		req.setCharacterEncoding("UTF-8");
		
		// command object - 검증 대상
		MemberVO member = new MemberVO();
		req.setAttribute("member", member);
//		member.setMemId(req.getParameter("memId"));
		
		Map<String, String[]> parameterMap = req.getParameterMap();
		// 전달되는 파라미터와 그걸 받는 칭구의 이름이 같아야할 것 memId=memId
		try {
			BeanUtils.populate(member, parameterMap);
		} catch (IllegalAccessException | InvocationTargetException e) {
			throw new RuntimeException(e);
		}
		
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
		new InternalResourceViewResolver("/WEB-INF/views/", ".jsp").resolveView(viewName, req, resp);
		
//		parameterMap.entrySet().stream()
//				.forEach(entry->{
//					String paramName = entry.getKey();
//					MemberVO.class.getDeclaredField(paramName);
//					PropertyDescriptor pd = new PropertyDescriptor(paramName, MemberVO.class);
//					Method setter = pd.getWriteMethod();
//				});
		
//		HttpSession session = req.getSession();
//		
//		// 회원가입
//		MemberVO member = new MemberVO();
//		member.setMemId(req.getParameter("memId"));
//		member.setMemPass(req.getParameter("memPass"));
//		member.setMemName(req.getParameter("memName"));
//		member.setMemBir(req.getParameter("memBir"));
//		member.setMemZip(req.getParameter("memZip"));
//		member.setMemAdd1(req.getParameter("memAdd1"));
//		member.setMemAdd2(req.getParameter("memAdd2"));
//		
//		ServiceResult result = memSerivce.createMember(member);
//		String viewName = null;
//		if(ServiceResult.OK.equals(result)) {
//			viewName = "redirect:/";
//		}
//		else if(ServiceResult.PKDUPLICATED.equals(result)) {
//			session.setAttribute("message", "중복된 아이디 입니다. 다른 아이디를 사용해주세요.");
//			viewName = "redirect:/login/loginForm.jsp";
//		} else if(ServiceResult.FAIL.equals(result)) {
//			session.setAttribute("message", "가입에 실패하셨습니다.");
//			viewName = "redirect:/login/loginForm.jsp";
//		}
//		
//		if(viewName.startsWith("redirect:")) {
//			viewName = viewName.substring("redirect:".length());
//			resp.sendRedirect(req.getContextPath() + viewName);
//		} else {
//			req.getRequestDispatcher(viewName).forward(req, resp);
//		}	
	}
}
