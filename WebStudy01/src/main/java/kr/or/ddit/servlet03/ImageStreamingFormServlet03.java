package kr.or.ddit.servlet03;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 현재 컨트롤러가 받아야하는 요청의 종류
 * 1. UI 제공하기 위한 요청
 * 2. 데이터를 제공해야되는 요청
 *
 */
@WebServlet("/03/imageForm.do")
public class ImageStreamingFormServlet03 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// application.getMimeType(arg0)
		String imageFolder = getServletContext().getInitParameter("imageFolder");

		// resp.setContentType("text/html;charset=UTF-8");

		File folder = new File(imageFolder);
		File[] imageFiles = folder.listFiles((dir, name)->{
			String mime = getServletContext().getMimeType(name);
			return mime !=null && mime.startsWith("image/");
		});
		
		// req.setAttribute("imageFiles", imageFiles);
		
		// 대부분의 개발자는 파라미터만 처리하면 된다고 생각하지만 그 외에 여러가지가 있다
		String accept = req.getHeader("Accept");
		if(accept.contains("json")) {
			// 2. 데이터를 제공해야되는 요청
			// Marshalling (중프때는 gson을 사용했지만 우리는 직접 해볼거에요)
			String json = marshalling(imageFiles);
			resp.setContentType("application/json");
			try(
				PrintWriter out = resp.getWriter();
			){
				out.print(json);
			}
			
		} else {
			// 1. UI 제공하기 위한 요청
			// jsp는 html이기 때문에 else로
			String viewName = "/WEB-INF/views/02/imageForm_ajax.jsp";
			req.getRequestDispatcher(viewName).forward(req, resp);
		}
		
	}

	// 파일 이름과 MIMEType 포함시킬것
	private String marshalling(File[] imageFiles) {
		StringBuffer json = new StringBuffer();
		json.append("[");
		String ptrn = "\"%s\":\"%s\"";
				
		for(File tmp : imageFiles) {
			String name = tmp.getName();
			String mime = getServletContext().getMimeType(name);
			json.append("{");
			json.append(String.format(ptrn, "name", name));
			json.append(",");
			json.append(String.format(ptrn, "mime", mime));
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
