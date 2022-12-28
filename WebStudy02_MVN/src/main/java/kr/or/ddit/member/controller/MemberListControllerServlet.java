package kr.or.ddit.member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.mvc.view.InternalResourceViewResolver;
import kr.or.ddit.vo.MemberVO;

@WebServlet("/member/memberList.do")
public class MemberListControllerServlet extends HttpServlet {
	private static final Logger log = LoggerFactory.getLogger(MemberListControllerServlet.class);
	
	private MemberService service = new MemberServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<MemberVO> memberList = service.retrieveMemberList();
		log.info("memberList : {}", memberList);
		req.setAttribute("memberList", memberList);
		String viewName = "member/memberList";
		
		new InternalResourceViewResolver("/WEB-INF/views/", ".jsp").resolveView(viewName, req, resp);
	}
}