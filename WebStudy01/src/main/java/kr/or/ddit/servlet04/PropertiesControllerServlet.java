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

import kr.or.ddit.servlet01.DescriptionServlet;

@WebServlet("/03/props/propsView.do")
public class PropertiesControllerServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// Header에서 accept만 가져와서 변수에 담아주기
		String accept = req.getHeader("Accept");
		
		// accept안에 json이 포함되어 있지 않으면
		if(accept.toLowerCase().contains("json")) {
			// native(DataStore.properties) -> json : marshalling
			// {"prop1":"value1",...}
			Properties properties = readProps();
			String prop = marshalling(properties);
			resp.setContentType("application/json;charset=UTF-8"); 
			try(
					PrintWriter out = resp.getWriter();
				){
					out.print(prop);
				}
		// accept안에 json이 포함되어 있지 않으면
		} else {
			String path = "/WEB-INF/views/03/propsView.jsp";
			req.getRequestDispatcher(path).forward(req, resp);
		}
	}
	
	// properties 파일 읽는 method
	public Properties readProps() throws IOException {
		// properties 파일을 읽기 
		Properties properties = new Properties();
		File file = new File("/kr/or/ddit/props/DataStore.properties");
		try(
			InputStream is = DescriptionServlet.class.getResourceAsStream("/kr/or/ddit/props/DataStore.properties");
			
		){
			// native 파일 안에 있는 key, value 가져오기
			properties.load(is);
		return properties;
		}
	}
	
	// mashlling 하는 method
	private String marshalling(Properties properties) {
		StringBuffer json = new StringBuffer();
		json.append("[");
		String ptrn = "\"%s\":\"%s\"";
		Enumeration<Object> en = properties.keys();
		while (en.hasMoreElements()) {
			Object key = (Object) en.nextElement();
			Object value = properties.get(key);
			json.append("{");
			json.append(String.format(ptrn, "key", key));
			json.append(",");
			json.append(String.format(ptrn, "value", value));
			json.append("}");
			json.append(",");
		}
		json.append("]");
		int lastIndex = json.lastIndexOf(",");
		if(lastIndex!=-1) {
			json.deleteCharAt(lastIndex);
		}
		return json.toString();
	}
}