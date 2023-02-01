package kr.or.ddit.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.vo.BoardVO;
import lombok.RequiredArgsConstructor;


//BoardRetrieveController안에 모아놨기 때문에 필요 없는 파일임 



/*
@RequiredArgsConstructor
@Controller
public class BoardViewController {
	
	private final BoardService service;
	
	
	@RequestMapping("/board/boardView.do")
	public String BoardView(
		@RequestParam(value="what", required=true) int boNo //int boNo는 반드시 받아와야됨 required true
		, Model model //handlerAdapter에게 전달하기 위한 reqest
	) {
		BoardVO board = service.retrieveBoard(boNo);
		model.addAttribute("board", board); //모델에 대한 정보 넘기기
		return "board/boardView";
	}
	
	
	
	

}
*/