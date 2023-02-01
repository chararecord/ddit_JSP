package kr.or.ddit.board.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.validate.InsertGroup;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@RequestMapping("/board/boardInsert.do")
public class BoardInsertController {

	private final BoardService service;
	
	//이게 먼저 실행되면서 아래 메소드들보다 먼저 board라는 메소드가 먼저 생김 <form:form modelAttribute="board">
	@ModelAttribute("board")
	public BoardVO board() {
		return new BoardVO();
	}
	
	
	@GetMapping
	public String boardForm() {
		return "board/boardForm";
	}
	
	@PostMapping
	public String boardInsert(
	    @Validated(InsertGroup.class) @ModelAttribute("board") BoardVO board
		, Errors errors
		, Model model
	
	) {
		String viewName = null;
		if(!errors.hasErrors()) {
			int rowcnt = service.createBoard(board);
			if(rowcnt>0) {
				viewName = "redirect:/board/boardView.do?what="+board.getBoNo();
			}else {//문제가 생겼을 경우
				model.addAttribute("message", "서버오류, 조금있다 다시!");
				viewName = "board/boardForm";
			}
		}else {
			viewName = "board/boardForm";
		}
		return viewName;
	}
	
}
