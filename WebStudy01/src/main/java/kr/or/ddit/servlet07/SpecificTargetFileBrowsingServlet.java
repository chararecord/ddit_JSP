
package kr.or.ddit.servlet07;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/browsing/getFileList")
public class SpecificTargetFileBrowsingServlet extends HttpServlet{
	private ServletContext application;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		application = config.getServletContext();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/**
		 * 통과했다 -> parameter를 가지고 해당 자원을 응답 데이터에 포함해서 가야함 참고해야되는 코드는 다 imagestreamingservlet이 가지고 있다
		 * 1. 요청분석
		 * target parameter - 존재여부 검증
	 	 * 통과를 하지 못했다 -> 요청처리 불가(상태코드)
		 * 4. viewName 선택
		 * 5. view 이동
		 */
		
//		1.
		String target = req.getParameter("target");
		if(target==null || target.isEmpty()) {
			resp.sendError(HttpServletResponse.SC_BAD_REQUEST); // null이나 공백은 받지않아 400
			return;
		}
		String targetPath = application.getRealPath(target);
		File targetFolder = new File(targetPath);
		if(!targetFolder.exists()) {
			resp.sendError(HttpServletResponse.SC_NOT_FOUND); // 못찾겠어 404]
			return;
		}
		if(targetFolder.isFile()) {
			resp.sendError(HttpServletResponse.SC_BAD_REQUEST); // 야 우린 폴더만 받아 파일은 안 받아; 400
			return;
		}
		
//		2.
		File[] fileList = targetFolder.listFiles(); // 우리가 원하는 구조도, 형태도 아니야
		List<FileWrapper> wrapperList = Arrays.stream(fileList)
												.map(file->new FileWrapper(file, application))
												.collect(Collectors.toList());
		
//		3.
		req.setAttribute("files", wrapperList);
		
//		4.
		String viewName = "/jsonView.do";
		
//		5.
		req.getRequestDispatcher(viewName).forward(req, resp);
	}
}