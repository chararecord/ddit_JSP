package kr.or.ddit.member.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
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
import kr.or.ddit.member.dao.MemberDAOImpl;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.mvc.view.InternalResourceViewResolver;
import kr.or.ddit.validate.UpdateGroup;
import kr.or.ddit.validate.ValidationUtils;
import kr.or.ddit.vo.MemberVO;

@WebServlet("/member/memberDelete.do")
public class MemberDeleteControllerServlet extends HttpServlet {
	private static final Logger log = LoggerFactory.getLogger(MemberDeleteControllerServlet.class);
	private MemberService service = new MemberServiceImpl();

	// 아이디와 비밀번호의 인증 시스템에서는 dispatcher를 사용하지 안흔ㄴ다
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		MemberVO member = (MemberVO) session.getAttribute("authMember");
		member.setMemPass(req.getParameter("memPass"));
		
		String viewName = null;
		
		Map<String, List<String>> errors = new LinkedHashMap<>();
		req.setAttribute("errors", errors);
		boolean valid = ValidationUtils.validate(member, errors, UpdateGroup.class);
		if(valid) {
			ServiceResult result = service.removeMember(member);
			log.info("탔다ㅋ -----> {} ", result);
			switch (result) {
			case INVALIDPASSWORD:
				req.setAttribute("message", "비밀번호 오류");
				viewName = "member/memberView";
				break;
			case FAIL:
				req.setAttribute("message", "서버에 문제 있음. 다시 수정ㄱㄱ");
				viewName = "member/memberView";
				break;
			default:
				viewName = "redirect:/";
				session.invalidate();
				break;
			}
		} else {
			viewName = "member/memberView";
			log.info("엘스 -----> {} ", errors);
			errors.forEach((k,v)->{
				log.error("{} : {}", k, v);
			});
		}
		new InternalResourceViewResolver("/WEB-INF/views/", ".jsp").resolveView(viewName, req, resp);
	}
}
