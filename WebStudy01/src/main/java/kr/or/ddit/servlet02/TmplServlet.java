package kr.or.ddit.servlet02;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.tmpl")
public class TmplServlet extends HttpServlet{
	private ServletContext application;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		application = getServletContext();
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		
		StringBuffer tmplSrc = readTemplate(req, resp);
		
		if(tmplSrc==null) {
			System.err.println("⚠️템플릿 소스를 읽을 수 없습니다.⚠️");
			return;
		}
		/*Map<String, Object> scope = new HashMap<>();
		scope.put("now", new Date());*/
		
		String html = evaluateVariables(tmplSrc, req);
		
		PrintWriter out = resp.getWriter();
		out.println(html);
	}

	private String evaluateVariables(StringBuffer tmplSrc, HttpServletRequest scope) {
		String evalPattern = "#([a-zA-Z0-9_]+)#"; // <-정규표현식 사용 공부 하기
		Pattern regex = Pattern.compile(evalPattern);
		Matcher matcher = regex.matcher(tmplSrc); // <-체킹을 싹하고 matcher에게 넘겨줌
		StringBuffer finalHtml = new StringBuffer();
		while (matcher.find()) { // <- matcher가 찾아라
			String varName = matcher.group(1); // now를 가지고 있음
			Object value = scope.getAttribute(varName);
			matcher.appendReplacement(finalHtml, Objects.toString(value, ""));
			// 원래 Object가 가지고 있는 toString 등이 2% 부족해서 보완해서 만든 것 => nullPointException 안뜸
			// null 대신 "" 공백 출력
		}
		matcher.appendTail(finalHtml);
		return finalHtml.toString();
	}

	private StringBuffer readTemplate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String tmplPath = req.getServletPath();
		String realPath = application.getRealPath(tmplPath);
		File tmplFile = new File(realPath);
		if(!tmplFile.exists()) {
			resp.sendError(HttpServletResponse.SC_NOT_FOUND, tmplPath+"를 찾을 수 없어요");
		  return null;
		}
		
		FileReader reader = new FileReader(tmplFile); // 1차 stream
		BufferedReader br = new BufferedReader(reader); // 2차 stream (단독개방X 반드시 1차 stream을 parameter로)
		String temp = null;
		StringBuffer tmplSrc = new StringBuffer();
		while((temp=br.readLine())!=null) {
			tmplSrc.append(temp+"\n");
		}
		return tmplSrc;
	}
}
