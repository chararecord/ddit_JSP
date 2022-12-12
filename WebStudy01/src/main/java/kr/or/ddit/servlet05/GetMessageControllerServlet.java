package kr.or.ddit.servlet05;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/04/getGreetingMessage")
public class GetMessageControllerServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		1. 요청 분석(line, header, body) - datatype이 뭔지, locale이 선택되었는지(선택되었다면 그게 뭔지)
		String accept = req.getHeader("Accept");
		String locale = req.getParameter("locale");
		Locale clientLocale = null;
		if(locale!=null) {
//			ko, en : language tag, locale code
			clientLocale = Locale.forLanguageTag(locale); // parameter로 결정됨
		} else {
			clientLocale = req.getLocale(); // Accept-language header로 결정됨
		}
		String name = req.getParameter("name");
		if(name==null||name.isEmpty()) {
			resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		
//		2. 모델 확보
		Object message = null;
		Object key = null;
		
		List<String> keyList = new ArrayList<String>();
		
		try {
			message = retrieveMessage(clientLocale, name);
			keyList = getKey(clientLocale);
		} catch (MissingResourceException e) {
			resp.sendError(HttpServletResponse.SC_NOT_FOUND);
			return;
		}
		
//		3. 모델 공유(setAttribute)
//		{"message":"HELLO"}
//		Map<String, Object> target = Collections.singletonMap("message", message);
		req.setAttribute("message", message);
		System.out.println("message"+message);
		req.setAttribute("keyList", keyList);
		System.out.println("keyList"+keyList);
		
//		4. 뷰 선택
		String viewName = null;
		int statusCode = HttpServletResponse.SC_OK;
		if(accept.contains("json")) {
			viewName = "/jsonView.do";
		} else if (accept.contains("xml")) {
			viewName = "/xmlView.do";
		} else if (accept.contains("plain")) {
			viewName = "/WEB-INF/views/04/plainView.jsp";
		} else {
			statusCode = HttpServletResponse.SC_NOT_ACCEPTABLE;
		}
		
		if(statusCode==HttpServletResponse.SC_OK) {
//		5. 뷰 이동
			req.getRequestDispatcher(viewName).forward(req, resp);
		} else {
			resp.sendError(statusCode);
		}
	}

	private List<String> getKey(Locale clientLocale) {
		String baseName = "kr.or.ddit.props.Message";
		ResourceBundle bundle = ResourceBundle.getBundle(baseName, clientLocale);
		
		List<String> keyList = new ArrayList<>();
		Enumeration keys = bundle.getKeys();
		while(keys.hasMoreElements()) {
			String key2 = (String)keys.nextElement();
			keyList.add(key2);
		}
		return keyList;
	}

	private Object retrieveMessage(Locale clientLocale, String name) {
		String baseName = "kr.or.ddit.props.Message";
		ResourceBundle bundle = ResourceBundle.getBundle(baseName, clientLocale);
		return bundle.getString(name);
	}
}
