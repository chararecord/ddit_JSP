package kr.or.ddit.campus.notice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.campus.notice.service.NoticeService;
import kr.or.ddit.validate.InsertGroup;
import kr.or.ddit.vo.NoticeVO;
import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.SearchVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author 민경진
 * @Since 2023. 2. 2.
 * <pre>
 *
 * ======[[개정이력(Modification Information)]]======
 *   수정일                    수정자                        수정내용
 * --------        --------    -----------------------
 * 2023. 2. 2.       민경진             생성
 *
 * Copyright (c) 2023 by DDIT All right reserved
 * </pre>
 */
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/campus/notice/**")
@Controller
public class NoticeController {
	
	private final NoticeService service;
	
	/**
	 * notice 속성 생성 메소드
	 * @return noticeVO
	 */
	@ModelAttribute("notice")
	public NoticeVO notice() {
		return new NoticeVO();
	}

	/**
	 * notice 게시판 글 목록 출력 메소드 (selectList)
	 * @param currentPage
	 * @param searchVO
	 * @param model
	 * @return /jsp/campus/notice/notice.jsp
	 */
	@GetMapping
	public String noticeList(
			@RequestParam(value="page", required=false, defaultValue="1") int currentPage
			, @ModelAttribute("simpleCondition") SearchVO searchVO
			, Model model ) {
		PagingVO<NoticeVO> pagingVO = new PagingVO<>(10, 5);
		pagingVO.setCurrentPage(currentPage);
		pagingVO.setSimpleCondition(searchVO);
		
		service.retrieveNoticeList(pagingVO);
		
		model.addAttribute("pagingVO", pagingVO);
		
		return "campus/notice/notice";
	}
	
	/**
	 * notice 게시글 등록 폼
	 * @return /jsp/campus/notice/noticeForm.jsp
	 */
	@GetMapping("/insert")
	public String noticeForm() {
		return "campus/notice/noticeForm";
	}
	
	/**
	 * notice 게시글 등록 메소드 (insert)
	 * @param notice
	 * @param model
	 * @return
	 */
	@PostMapping("/insert")
	public String noticeInsert(
			@Validated(InsertGroup.class) @ModelAttribute("notice") NoticeVO notice
			, Model model) {
		
		String viewName = null;
		log.info("notice>>>>>>>>{}", notice);
		int rowcnt = service.createNotice(notice);
		if(rowcnt > 0) {
			viewName = "redirect:/campus/notice";
////		} else {
////			model.addAttribute("message", "서버 오류");
////			viewName = "campus/notice/noticeForm";
		}
		return viewName;
	}
}
