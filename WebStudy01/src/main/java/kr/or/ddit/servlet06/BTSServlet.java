package kr.or.ddit.servlet06;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value="/bts", loadOnStartup=1)
public class BTSServlet extends HttpServlet {
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		ServletContext application = config.getServletContext();
		application.setAttribute("btsMembers", getBtsMemberList());
	}
	
	public Map<String, String[]> getBtsMemberList() {
		Map<String, String[]> members = new LinkedHashMap<>();
		int idx = 1;
		members.put("B00"+idx++,new String[] {"RM", "/WEB-INF/views/bts/rm.jsp"});
		members.put("B00"+idx++,new String[] {"진", "/WEB-INF/views/bts/jin.jsp"});
		members.put("B00"+idx++,new String[] {"슈가", "/WEB-INF/views/bts/suga.jsp"});
		members.put("B00"+idx++,new String[] {"제이홉", "/WEB-INF/views/bts/jhop.jsp"});
		members.put("B00"+idx++,new String[] {"지민", "/WEB-INF/views/bts/jimin.jsp"});
		members.put("B00"+idx++,new String[] {"뷔", "/WEB-INF/views/bts/bui.jsp"});
		members.put("B00"+idx++,new String[] {"정국", "/WEB-INF/views/bts/jungkuk.jsp"});
		return members;
	}
	
	public String[] getMemberContent(String code) {
		String[] content = getBtsMemberList().get(code);
		System.out.println(content);
		return content;
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1~5 컨트롤러 작업
//		우선 저 배열에 있는 code와 string 네임을 가지고 option에 뿌려줄 수 있도록 한다.
//		그러려면 code와 name을 공유해야 한다.
//		선택하면 그 선택에 맞는 jsp로 이동하도록 뷰를 선택한다.
		
		// 2. 모델확보
		Map<String, String[]> bts = getBtsMemberList();
		
		// 3. 모델 공유
		req.setAttribute("bts", bts);
		
		// 4. view 선택
		String viewName = "/jsonView.do";
		
		// 5. view 이동
		req.getRequestDispatcher(viewName).forward(req, resp); // 현재 req를 그대로 유지하는 구조
	}
}
