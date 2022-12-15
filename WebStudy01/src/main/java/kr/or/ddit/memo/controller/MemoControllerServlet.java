package kr.or.ddit.memo.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.memo.dao.FileSystemMemoDAOImpl;
import kr.or.ddit.memo.dao.MemoDAO;
import kr.or.ddit.vo.MemoVO;

@WebServlet("/memo")
public class MemoControllerServlet extends HttpServlet{
	
	private MemoDAO dao = FileSystemMemoDAOImpl.getInstance();
	
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
//		System.out.println(memoList);
		
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
//		Post-Redirect-Get : PRG parttern
		
		String accept = req.getHeader("Accept");
		MemoVO memo = getMemoFromRequest(req); // 메모 객체 만들어서 가져와야함
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
	
	private MemoVO getMemoFromRequest(HttpServletRequest req) {
		/*
		req로 인서트 값의 목록을 받았다. 그 값을 어떻게 해줘야 하는가?
		getParameter로 꺼낸 걸 또 담아서 return? 메모 객체를 만드는 법..
		*/
		String writer = req.getParameter("writer");
		String date = req.getParameter("date");
		String content = req.getParameter("content");
		MemoVO mv = new MemoVO();
		mv.setWriter(writer);
		mv.setDate(date);
		mv.setContent(content);
		return mv;
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
