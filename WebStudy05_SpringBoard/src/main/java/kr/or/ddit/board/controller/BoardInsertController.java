package kr.or.ddit.board.controller;

import javax.annotation.PostConstruct;

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
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/board/boardInsert.do")
@Controller
public class BoardInsertController {
	private final BoardService service;
	
	@PostConstruct
	public void init() {
		log.info("주입된 객체 : {}", service.getClass().getName());
	}
	
	// 무조건 board라는 속성이 생성되고 get, post 감
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
			, Model model) {
		
		String viewName = null;
		if(!errors.hasErrors()) {
			int rowcnt = service.createBoard(board);
			if(rowcnt > 0) {
				viewName = "redirect:/board/boardView.do?what=" + board.getBoNo();
			} else {
				model.addAttribute("message" , "서버 오류");
				viewName = "board/boardForm";
			}
		} else {
			viewName = "board/boardForm";
	}
		return viewName;
	}
}
