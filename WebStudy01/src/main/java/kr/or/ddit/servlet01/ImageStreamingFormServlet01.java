package kr.or.ddit.servlet01;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value="/01/imageForm.do")
			// initParams= {@WebInitParam(name="imageFolder", value="D:\\contents\\images")})
public class ImageStreamingFormServlet01 extends HttpServlet {
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
		
		File folder = new File(imageFolder);
		// 현재 폴더 안에 있는 자식 폴더 가져오는 method
		File[] imageFiles = folder.listFiles((dir, name)->{
			String mime = application.getMimeType(name);
			return mime !=null && mime.startsWith("image/");
		});
		StringBuffer content = new StringBuffer();
		content.append("<html>             \n");
		content.append("	<body>         \n");
		content.append(String.format("<form action='%s/imageStreaming.do'>\n", req.getContextPath()));
		content.append("		<select name='image'>   \n");
		
		String pattern = "<option>%s</option>\n";
		for(File tmp : imageFiles) {
			content.append(String.format(pattern, tmp.getName()));
		}
		
		content.append("		</select>  \n");
		content.append("<input type='submit' value='전송' />");
		content.append("</form>");
		content.append("	</body>        \n");
		content.append("</html>            \n");
		
		// try with resource 구문 소괄호가 resource구문 (알아서 close 해줌)
		try( 
		PrintWriter out = resp.getWriter();
		){
			out.println(content);
		}
	}
}
