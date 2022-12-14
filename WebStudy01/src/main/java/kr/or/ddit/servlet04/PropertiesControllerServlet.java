package kr.or.ddit.servlet04;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import kr.or.ddit.servlet01.DescriptionServlet;
import kr.or.ddit.servlet04.service.PropertiesService;
import kr.or.ddit.servlet04.service.PropertiesServiceImpl;

@WebServlet("/03/props/propsView.do")
public class PropertiesControllerServlet extends HttpServlet {
	private PropertiesService service = new PropertiesServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// Header에서 accept만 가져와서 변수에 담아주기
		// 1. 요청 분석
		String accept = req.getHeader("Accept"); // */*라고 들어오는 경우도 있음
		
		// 2. 모델 확보
		Object target = service.retrieveData();
		
		// 3. 모델 공유
		req.setAttribute("target", target);
		
		String path = null;
		
		// 4. 뷰 선택
		if(accept.startsWith("*/*") || accept.toLowerCase().contains("html")) {
			path = "/WEB-INF/views/03/propsView.jsp";
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