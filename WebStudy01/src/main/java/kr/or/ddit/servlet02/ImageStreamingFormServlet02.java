package kr.or.ddit.servlet02;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/02/imageForm.do")
public class ImageStreamingFormServlet02 extends HttpServlet {
	private ServletContext application; // init()은 단 한번 실행되는 메소드기 때문에 얘도 단 한번만 생성되는 싱글톤 객체
	private String imageFolder;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config); // ServletContext 개체를 만든다
		application = getServletContext();
		imageFolder = application.getInitParameter("imageFolder");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8"); // 마임 설정시 출력스트림을 개방하기 전에 먼저 설정해야함
		
		// information 만드는 중~~
		
		File folder = new File(imageFolder);
		// 현재 폴더 안에 있는 자식 폴더 가져오는 method
		File[] imageFiles = folder.listFiles((dir, name)->{
			String mime = application.getMimeType(name);
			return mime !=null && mime.startsWith("image/");
		});
		
		String pattern = "<option>%s</option>\n";
		StringBuffer options = new StringBuffer();
		for(File tmp : imageFiles) {
			options.append(String.format(pattern, tmp.getName()));
		}
		
		req.setAttribute("cPath", req.getContextPath());
		req.setAttribute("options", options);
		
		String imagePath = "/01/imageForm.tmpl";
		// req.getRequestDispatcher(imagePath).forward(req, resp);
		String viewName = "/WEB-INF/views/01/imageForm.jsp";
		req.getRequestDispatcher(viewName).forward(req, resp);
		
	}
}
