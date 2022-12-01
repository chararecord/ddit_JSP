package kr.or.ddit.servlet01;

import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.util.*;

public class ImageStreamingServletExam extends HttpServlet{
	private String imageFolder;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		imageFolder = config.getInitParameter("imageFolder"); // 파라미터로 받을 수 있는 데이터는 문자열로 제한
		System.out.printf("받은 파라미터 : %s\n", imageFolder);
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws IOException, ServletException
	{
		// MIME text
		resp.setContentType("text/html;charset=UTF-8");
		
		File dir = new File(imageFolder);
		String[] flist = dir.list();
		
		StringBuffer con = new StringBuffer();
		con.append("<html>");
		con.append("<body>");
		con.append("<form action='/WebStudy01/imageStreaming.do' method='get' id='imgform'>");
		con.append("<input type='submit' value='사진보기'>");
		con.append("</form>");
		con.append("<select name='image' form='imgform'>");
		for(int i=0; i<flist.length; i++) {
			con.append("<option value='"+flist[i]+"'>"+flist[i]+"</option>");
		}
		con.append("</select>");
		con.append("</body>");
		con.append("</html>");
		PrintWriter out = resp.getWriter();
		out.println(con);
		out.close();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}