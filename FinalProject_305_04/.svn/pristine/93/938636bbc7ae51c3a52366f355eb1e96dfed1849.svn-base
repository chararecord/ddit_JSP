package kr.or.ddit.prof.lectBoard.controller;

import javax.annotation.Resource;

import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.filter.HiddenHttpMethodFilter;

import kr.or.ddit.prof.lectBoard.service.LectureBoardService;
import kr.or.ddit.ui.PaginationRenderer;
import kr.or.ddit.validate.DeleteGroup;
import kr.or.ddit.validate.InsertGroup;
import kr.or.ddit.validate.UpdateGroup;
import kr.or.ddit.vo.AttaFileVO;
import kr.or.ddit.vo.LectBoardVO;
import kr.or.ddit.vo.LectureVO;
import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.SearchVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author 민경진
 * @Since 2023. 2. 8.
 * <pre>
 *
 * ======[[개정이력(Modification Information)]]======
 *   수정일                    수정자                        수정내용
 * --------        --------    -----------------------
 * 2023. 2. 8.       민경진               생성
 *
 * Copyright (c) 2023 by DDIT All right reserved
 * </pre>
 */
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/prof/lectBoard")
@Controller
public class LectureBoardController {
	
	private final LectureBoardService service;
	
	@Resource(name="bootstrapPaginationRender")
	private PaginationRenderer renderer;
	
	@Bean
	public HiddenHttpMethodFilter hiddenHttpMethodFilter(){
		return new HiddenHttpMethodFilter();
	}
	
	
	/**
	 * lectBoard 속성 생성 메소드 - form에 바인딩할 빈 모델 객체 생성
	 */
	@ModelAttribute("lectBoard")
	public LectBoardVO lectBoard() {
		return new LectBoardVO();
	}
	
	/**
	 * lectBoard 게시판 글 목록 출력 메소드 (selectList)
	 */
	@GetMapping("/{lectId}")
	public String lectInfoUI(
			@RequestParam(value="page", required=false, defaultValue="1") int currentPage
			, @PathVariable String lectId
			, @ModelAttribute("simpleCondition") SearchVO searchVO
			, Model model
			) {
		PagingVO<LectBoardVO> pagingVO = new PagingVO<>(10, 5);
		pagingVO.setCurrentPage(currentPage);
		pagingVO.setSimpleCondition(searchVO);
		
		service.retrieveLectBoardList(pagingVO);
		LectureVO lectInfo = service.retrieveLectInfo(lectId);
		
		model.addAttribute("lectInfo", lectInfo);
		model.addAttribute("pagingVO", pagingVO);
		model.addAttribute("pagingHTML", renderer.renderPagination(pagingVO));
		
		return "prof/lectBoard/lectBoard";
	}
	
	/**
	 * lectBoard 게시판 글 목록 출력 메소드 (ajax)
	 */
	@GetMapping(value="/{lectId}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String lectInfoAndList(
			@RequestParam(value="page", required=false, defaultValue="1") int currentPage
			, @PathVariable String lectId
			, @ModelAttribute("simpleCondition") SearchVO searchVO
			, Model model
			) {
		PagingVO<LectBoardVO> pagingVO = new PagingVO<>(10, 5);
		pagingVO.setCurrentPage(currentPage);
		pagingVO.setSimpleCondition(searchVO);
		
		service.retrieveLectBoardList(pagingVO);
		LectureVO lectInfo = service.retrieveLectInfo(lectId);
		log.info("dataList>>>>>>>>>>>>>>{}",pagingVO.getDataList());
		model.addAttribute("lectInfo", lectInfo);
		model.addAttribute("pagingVO", pagingVO);
		model.addAttribute("pagingHTML", renderer.renderPagination(pagingVO));
		
		return "jsonView";
	}
	
	/**
	 * 게시글 조회 메소드
	 */
	@GetMapping("/{lectId}/{lectBoardId}")
	public String lectBoardView(
			@PathVariable("lectId") String lectId
			, @PathVariable("lectBoardId") String lectBoardId
			, Model model) {
		LectBoardVO lectBoard = service.retreiveLectBoard(lectBoardId);
		model.addAttribute("lectBoard", lectBoard);
		
		return "prof/lectBoard/lectBoardView";
	}
	
//////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * lectBoard 게시글 등록 폼
	 */
	@GetMapping(value="/{lectId}/form")
	public String lectBoardForm(
			@PathVariable("lectId") String lectId
			) {
		return "prof/lectBoard/lectBoardForm";
	}
	
	/**
	 * lectBoard 게시글 등록 메소드 (INSERT)
	 */
	@PostMapping(value="/{lectId}/form")
	public String lectBoardInsert(
			@Validated(InsertGroup.class) @ModelAttribute("lectBoard") LectBoardVO lectBoard
			, @PathVariable("lectId") String lectId
			, Model model
			) {
		String viewName = null;
		int rowcnt = service.createLectBoard(lectBoard);
		if(rowcnt > 0) {
			viewName = "redirect:/prof/lectBoard/" + lectId + "/" + lectBoard.getLectBoardId();
		} else {
			model.addAttribute("message", "서버 오류");
			viewName = "prof/lectBoard/lectBoardForm";
		}
		return viewName;
	}
	
//////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * lectBoard 게시글 수정
	 */
	@GetMapping("/{lectId}/form/{lectBoardId}")
	public String lectBoardEditForm(
			@Validated(UpdateGroup.class) @ModelAttribute("lectBoard") LectBoardVO lecBoard
			, @PathVariable("lectId") String lectId
			, @PathVariable("lectBoardId") String lectBoardId
			, Model model
			) {
		LectBoardVO lectBoard = service.retreiveLectBoard(lectBoardId);
		model.addAttribute("lectBoard", lectBoard);
		
		return "prof/lectBoard/lectBoardEdit";
	}
	
	@PostMapping("/{lectId}/form/{lectBoardId}")
	public String lectBoardEdit(
			@Validated(UpdateGroup.class) @ModelAttribute("lectBoard") LectBoardVO lectBoard
			, @PathVariable("lectId") String lectId
			, @PathVariable("lectBoardId") String lectBoardId
			, Model model
			) {
		String viewName = null;
		int rowcnt = service.modifyLectBoard(lectBoard);
		if(rowcnt > 0) {
			viewName = "redirect:/prof/lectBoard/" + lectBoard.getLectId() + "/" + lectBoard.getLectBoardId();
		} else {
			model.addAttribute("message", "서버 오류");
			viewName = "prof/lectBoard/lectBoardEdit";
		}
		return viewName;
	}
	
//////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * lectBoard 게시글 삭제
	 */
	@DeleteMapping("/{lectId}/{lectBoardId}")
	public String lectBoardDelete(
			@Validated(DeleteGroup.class) @ModelAttribute("lectBoardId") String id
			, @PathVariable String lectId
			, @PathVariable String lectBoardId
			, Model model
			) {
		String viewName = null;
		int rowcnt = service.removeLectBoard(id);
		if(rowcnt > 0) {
			viewName = "redirect:/prof/lectBoard/" + lectId;
		} else {
			model.addAttribute("message", "서버 오류");
			viewName = "prof/lectBoard/lectBoardView";
		}
		return viewName;
	}
	
	/**
	 * notice 파일 삭제
	 */
	@ResponseBody
	@PostMapping("/{lectId}/{lectBoardId}/DeleteFile")
	public int DeleteFile(
			@RequestBody AttaFileVO attaFileVO
			, @PathVariable String lectId
			, @PathVariable String lectBoardId
			) {
		log.info("attaFileVO : " + attaFileVO);
		//0 또는 1
		int result = this.service.deleteAttaFileList(attaFileVO);
		log.info("result : " + result);
		return result;		
	}
}