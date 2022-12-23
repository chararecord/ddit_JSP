package kr.or.ddit.memo.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import kr.or.ddit.memo.dao.DataBaseMemoDAOImpl;
import kr.or.ddit.memo.dao.FileSystemMemoDAOImpl;
import kr.or.ddit.memo.dao.MemoDAO;
import kr.or.ddit.vo.MemoVO;

@WebServlet("/memo")
public class MemoControllerServlet extends HttpServlet{
	
//	private MemoDAO dao = FileSystemMemoDAOImpl.getInstance();
	private MemoDAO dao = DataBaseMemoDAOImpl.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*
		우선 ajax로 비동기 요청을 보낸다. 왜? 메모 리스트를 가져오기 위해서
		1.요청분석을 한다. 가져온 req 헤더 안에 accept 부분에서 원하는 data resp 타입이 뭔지
		2.모델을 확보한다. dao에 적어뒀던 셀렉트 메소드가 있으니까 그걸 사용하자
		3.모델을 공유한다. setAttribute로 결과물 공유할 것
		4.뷰선택
		5.뷰이동
		 */
		
//		1. 요청분석 - 
		String accept = req.getHeader("Accept");
//		
//		2. 모델확보
		List<MemoVO> memoList = dao.selectMemoList();
		System.out.println(memoList);
		
//		3. 모델공유
		req.setAttribute("memoList", memoList);
		
//		4. 뷰선택
		String viewName = null;
		if(accept.contains("json")) {
			viewName = "/jsonView.do";
		} else if(accept.contains("xml")) {
			resp.sendError(HttpServletResponse.SC_NOT_ACCEPTABLE);
			return;
		}
		
//		5. 뷰이동
		req.getRequestDispatcher(viewName).forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		Post(비동기)-(SC_300)Redirect-Get : PRG pattern (accept 헤더는 유지된다)
		
		MemoVO memo = getMemoFromRequest(req); // 메모 객체 만들어서 가져와야함
		String accept = req.getHeader("Accept");
		int tmp = dao.insertMemo(memo);
		// req에 대한 정보를 남겨놓을 필요가 없음 -> redirect 어때? req 관련된 정보는 남겨놓을 필요가 없으니까
		
//		String viewName = null;
//		if(accept.contains("json")) {
//			viewName = "/jsonView.do";
//		} else if(accept.contains("xml")) {
//			resp.sendError(HttpServletResponse.SC_NOT_ACCEPTABLE);
//			return;
//		}
		// redirect
		resp.sendRedirect(req.getContextPath() + "/memo");
	}
	
	private MemoVO getMemoFromRequest(HttpServletRequest req) throws IOException {
		/*
		req로 인서트 값의 목록을 받았다. 그 값을 어떻게 해줘야 하는가?
		getParameter로 꺼낸 걸 또 담아서 return? 메모 객체를 만드는 법..
		*/
		String contentType = req.getContentType();
		MemoVO memo = null;
		if(contentType.contains("json")) {
			try(
				BufferedReader br = req.getReader();	// body content read 용 입력 스트림
			){
				memo = new ObjectMapper().readValue(br, MemoVO.class); // 역직렬화 + unmarshalling
			}
		} else if (contentType.contains("xml")) {
			try(
				BufferedReader br = req.getReader();	// body content read 용 입력 스트림
			){
				memo = new XmlMapper().readValue(br, MemoVO.class); // 역직렬화 + unmarshalling
			}
		} else { // parameter로 온 경우
			memo = new MemoVO();
			memo.setWriter(req.getParameter("writer"));
			memo.setContent(req.getParameter("content"));
			memo.setDate(req.getParameter("date"));
		}
		return memo;
		// 역직렬화 -> unmarshalling
//		try(
//			BufferedReader br = req.getReader(); // reader로 읽어들이겠다
		
// 		){
//			MemoVO memo = new MemoVO();		
//			String tmp = null;
//			StringBuffer strJson = new StringBuffer();
//			while((tmp = br.readLine()) != null) {
//				strJson.append(tmp+"\n");
//			}
//			ObjectMapper mapper = new ObjectMapper();			
//			memo = mapper.readValue(strJson.toString(), MemoVO.class);	
//					
//			System.out.println(memo);
//			return memo;
//		} 
	}

	// 수정
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
	
	// 삭제
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
}
