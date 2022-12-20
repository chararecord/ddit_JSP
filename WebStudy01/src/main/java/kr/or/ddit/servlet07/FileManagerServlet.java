package kr.or.ddit.servlet07;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/browsing/fileManager")
public class FileManagerServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/**
		 * 1. 요청분석 - 3개의 파라미터
		 * 세개 중 단 하나라도 비어있다면 정상적인 처리구조 X -> 선택코드 넘기기
		 * 요청을 보낼 때 이상한 걸 보냈다면? -> 존재여부 확인 후 -> 선택코드 넘기기
		 * 통과를 하고 나면 실제 파일을 복사하는 작업이 이루어짐
		 * dest 파일이 있는데 또 복사 -> 성공을 할 때 마다 li태그가 계속 갱신되어야 함 그걸 갱신하는 작업을 jsp에서 해줘야함
		 */
		
		int sc = validate(req);
		Map<String, Object> modelMap = (Map<String, Object>) req.getAttribute("modelMap");
		if(sc==200) {
			// 검증통과 - 파일복사과정
			boolean result = fileManage(modelMap);
			
			req.setAttribute("result", result);
			String viewName = "/jsonView.do";
			req.getRequestDispatcher(viewName).forward(req, resp);
		} else {
			// 검증못통과
			resp.sendError(sc);
		}
	}
	
	private boolean fileManage(Map<String, Object> modelMap) throws IOException{
		File sourceFile = (File) modelMap.get("sourceFile");
		File destinationFolder = (File) modelMap.get("destinationFolder");
//		File destFile = new File(destinationFolder, sourceFile.getName());
		// Path -> 경로만을 갖고 있는 객체, 객체 생성X
		Path destFilePath = Paths.get(destinationFolder.getCanonicalPath(), sourceFile.getName());
		String command = (String) modelMap.get("command");
		System.out.println(command);
		
		Files.copy(sourceFile.toPath(), destFilePath, StandardCopyOption.REPLACE_EXISTING);
		Files.move(sourceFile.toPath(), destFilePath, StandardCopyOption.REPLACE_EXISTING);
//		Files.delete(path);
		
		return true;
	}

	private int validate(HttpServletRequest req) {
		String srcFile = req.getParameter("srcFile");
		String destFolder = req.getParameter("destFolder");
		String command = req.getParameter("command");
		
		// VO의 역할을 하고 있는 Map
		Map<String, Object> modelMap = new HashMap<>();
		req.setAttribute("modelMap", modelMap);
		
		int sc = 200;
		
		if(srcFile==null || srcFile.isEmpty()
			|| destFolder==null || destFolder.isEmpty()
			|| command==null || command.isEmpty()) {
			sc = 400;
		} else {
			ServletContext application = req.getServletContext();
			String srcPath = application.getRealPath(srcFile);
			File sourceFile = new File(srcPath);
			if(!sourceFile.exists()) {
				sc = 404;
			} else if (sourceFile.isDirectory()) {
				sc = 400;
			} else {
				// 검증통과
				modelMap.put("sourceFile", sourceFile);
			}
			
			String destPath = application.getRealPath(destFolder);
			File destinationFolder = new File(destPath);
			if(!destinationFolder.exists()) {
				sc = 404;
			} else if (destinationFolder.isFile()) {
				sc = 400;
			} else {
				// 검증통과
				modelMap.put("destinationFolder", destinationFolder);
			}
			if(!"COPY".equals(command)) {
				sc = 405;
			} else {
				modelMap.put("command", command);
			}
		}
		return sc;
	}
}
