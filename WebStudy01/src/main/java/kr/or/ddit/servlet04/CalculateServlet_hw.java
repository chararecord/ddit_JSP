package kr.or.ddit.servlet04;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.servlet04.service.CalculateService;
import kr.or.ddit.servlet04.service.CalculateServiceImpl;

//@WebServlet("/04/calculate")
public class CalculateServlet_hw extends HttpServlet{
	private CalculateService service = new CalculateServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = "/WEB-INF/views/03/calculateForm.jsp";
		req.getRequestDispatcher(path).forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 1. 요청 분석
		String accept = req.getHeader("Accept");
		
		// 2. 모델 확보
		int x = Integer.parseInt(req.getParameter("leftOp")) ;		
		String oper = req.getParameter("operator");		
		int y = Integer.parseInt(req.getParameter("rightOp"));
		System.out.println(x + "------" + oper + "------" + y);
		
		Object target = null;
		
		if(oper.equals("PLUS")) {
			target = service.plus(x, y);
			System.out.println("++++++++/" + target);
		} else if (oper.equals("MINUS")) {
			target = service.minus(x, y);
			System.out.println("--------/" + target);
		} else if (oper.equals("MULTIPLY")) {
			target = service.multiply(x, y);
			System.out.println("********/" + target);
		} else if (oper.equals("DIVIDE")) {
			target = service.divide(x, y);
			System.out.println("////////:" + target);
		} else {
			return;
		}
		
		// 3. 모델 공유
		req.setAttribute("target", target);
		
		String path = null;
		
		// 4. 뷰 선택
		if(accept.startsWith("*/*") || accept.toLowerCase().contains("html")) {
			path = "/WEB-INF/views/03/calculateForm.jsp";
		} else if(accept.toLowerCase().contains("json")) {
			path = "/jsonView.do";
		// accept안에 json이 포함되어 있지 않으면
		} else if(accept.toLowerCase().contains("text/xml")) {
			path = "/xmlView.do";
		}
		// 5. 뷰 이동
		req.getRequestDispatcher(path).forward(req, resp);
	}
}
