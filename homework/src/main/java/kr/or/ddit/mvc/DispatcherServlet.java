package kr.or.ddit.mvc;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.commons.IndexController;
import kr.or.ddit.login.controller.LoginProcessController;
import kr.or.ddit.login.controller.LogoutController;
import kr.or.ddit.member.controller.MemberInsertController;
import kr.or.ddit.member.controller.MemberListController;
import kr.or.ddit.member.controller.MemberViewController;
import kr.or.ddit.mvc.view.InternalResourceViewResolver;
import kr.or.ddit.mvc.view.ViewResolver;
import kr.or.ddit.prod.controller.ProdListCondtroller;

public class DispatcherServlet extends HttpServlet {
	private ViewResolver viewResolver;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		viewResolver = new InternalResourceViewResolver("/WEB-INF/views/", ".jsp");
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		super.service(req, resp); // 없애면 do계열 메소드를 실행하지 않겠다는 의미
		req.setCharacterEncoding("UTF-8");
		
//		String requestURI = req.getRequestURI();
//		requestURI = requestURI.substring(req.getContextPath().length());
		
		String requestURI = req.getServletPath();
		
		AbstractController controller = null;
		if("/member/memberList.do".equals(requestURI)) {
			controller = new MemberListController();
		} else if ("/prod/prodList.do".equals(requestURI)){
			controller = new ProdListCondtroller();
		} else if ("/member/memberView.do".equals(requestURI)){
			controller = new MemberViewController();
		} else if ("/index.do".equals(requestURI)){
			controller = new IndexController();
		} else if ("/member/memberInsert.do".equals(requestURI)){
			controller = new MemberInsertController();
		} else if ("/login/loginProcess.do".equals(requestURI)){
			controller = new LoginProcessController();
		} else if ("/login/logout.do".equals(requestURI)){
			controller = new LogoutController();
		}
	
		if(controller==null) {
			resp.sendError(404, requestURI + " 는 처리할 수 없는 자원입니다.");
			return;
		}
			
		String viewName = controller.process(req, resp);
		if(viewName==null) {
			if(!resp.isCommitted()) {
				resp.sendError(500, "논리적인 viewName은 null일 수 없습니다.");
			}
		} else {
			viewResolver.resolveView(viewName, req, resp);
		}
	}
}
