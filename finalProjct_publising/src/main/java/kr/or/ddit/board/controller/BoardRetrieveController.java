package kr.or.ddit.board.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.SearchVO;
import lombok.RequiredArgsConstructor;

// board/boardList.do(검색조건: 작성자, 글의내용, 전체)

@Controller
@RequiredArgsConstructor
@RequestMapping("/board") 
public class BoardRetrieveController {

	//service inject
	private final BoardService service;

	
	//화면 단순출력
	@GetMapping
	public String listUI() {
		return "board/boardList";
	}

	
	
	//리스트 페이지 
	// 출력된 화면으로 리스트 내용 뿌려주기 
	@RequestMapping("boardList.do") 
	public String boardList(
		//페이징
		//required=false : page라는 파라미터가 꼭 있을 필요는 없다 . 파라미터 없을 경우 기본 값은 1로 지정 
		@RequestParam(value="page", required=false, defaultValue="1") int currentPage
		//검색조건 
		//searchVO를 이용해서 검색조건을 가져와서 simpleCondition에 넣어서 앞단으로 넘겨줌  modelAttribute="simpleCondition"
		, @ModelAttribute("simpleCondition") SearchVO searchVO
		//req대신 model
		, Model model
	) {
		
		//페이징 
		PagingVO<BoardVO> pagingVO = new PagingVO<>();
		pagingVO.setCurrentPage(currentPage);
		pagingVO.setSimpleCondition(searchVO); //검색
		
		//service에 있는 vo내용 끌어와서 list뿌려주기 
		service.retrieveBoardList(pagingVO);

		//화면출력
		model.addAttribute("pagingVO", pagingVO);
		return "board/boardList";  
	}
	
	
	
	//view 페이지
	@RequestMapping("boardView.do")
	public String BoardView(
		@RequestParam(value="what", required=true) int boNo //int boNo는 반드시 받아와야됨 required true
		, Model model //handlerAdapter에게 전달하기 위한 reqest
	) {
		BoardVO board = service.retrieveBoard(boNo);
		model.addAttribute("board", board); //모델에 대한 정보 넘기기
		return "board/boardView";
	}
	
	

	
	
}
