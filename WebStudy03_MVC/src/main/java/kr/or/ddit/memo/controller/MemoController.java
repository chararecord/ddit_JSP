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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import kr.or.ddit.memo.dao.MemoDAOImpl;
import kr.or.ddit.mvc.annotation.RequestMethod;
import kr.or.ddit.mvc.annotation.resolvers.RequestParam;
import kr.or.ddit.mvc.annotation.stereotype.Controller;
import kr.or.ddit.mvc.annotation.stereotype.RequestMapping;
import kr.or.ddit.memo.dao.MemoDAO;
import kr.or.ddit.vo.MemoVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MemoController {
	
//	private MemoDAO dao = FileSystemMemoDAOImpl.getInstance();
//	private MemoDAO dao = DataBaseMemoDAOImpl.getInstance();
	private MemoDAO dao = new MemoDAOImpl(); // 결합력
	
	@RequestMapping("/memo")
	public String memoList(
			//TODO 이것도.. 함 해봐.. 츄라이 츄라이..
//			@RequestHeader("Accept") String accept
			HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
		log.info("accept header : {}", accept);
		if(accept.contains("xml")) {
			resp.sendError(HttpServletResponse.SC_NOT_ACCEPTABLE);
			return null;
		}
		
//		2. 모델확보
		List<MemoVO> memoList = dao.selectMemoList();
//		3. 모델공유
		req.setAttribute("memoList", memoList);
//		4. 뷰선택
		return "forward:/jsonView.do";
	}
	
	@RequestMapping(value="/memo", method=RequestMethod.POST)
	public String memoInsert(HttpServletRequest req) throws ServletException, IOException {
//		Post(비동기)-(SC_300)Redirect-Get : PRG pattern (accept 헤더는 유지된다)
		
		MemoVO memo = getMemoFromRequest(req); // 메모 객체 만들어서 가져와야함
		dao.insertMemo(memo);
		// req에 대한 정보를 남겨놓을 필요가 없음 -> redirect 어때? req 관련된 정보는 남겨놓을 필요가 없으니까
		return "redirect:/memo";
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
	@RequestMapping(value="/memo", method=RequestMethod.PUT)
	public String doPut(HttpServletRequest req) throws ServletException, IOException {
		return "";
	}
	
	// 삭제
	@RequestMapping(value="/memo", method=RequestMethod.DELETE)
	public String doDelete(HttpServletRequest req) throws ServletException, IOException {
		return "";
	}
}
