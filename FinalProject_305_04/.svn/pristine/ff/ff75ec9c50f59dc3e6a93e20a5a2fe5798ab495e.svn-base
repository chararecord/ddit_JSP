package kr.or.ddit.campus.notice.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.inject.Inject;

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
import org.springframework.web.filter.HiddenHttpMethodFilter;

import kr.or.ddit.campus.notice.service.NoticeService;
import kr.or.ddit.ui.PaginationRenderer;
import kr.or.ddit.validate.DeleteGroup;
import kr.or.ddit.validate.InsertGroup;
import kr.or.ddit.validate.UpdateGroup;
import kr.or.ddit.vo.AttaFileVO;
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
@Controller
@RequestMapping("/campus/notice")
public class NoticeController {
	
	@Inject
	private NoticeService service;
	
	@Resource(name="bootstrapPaginationRender")
	private PaginationRenderer renderer;
	
	@Bean
	public HiddenHttpMethodFilter hiddenHttpMethodFilter(){
		return new HiddenHttpMethodFilter();
	}
	
	/**
	 * notice 속성 생성 메소드
	 */
	@ModelAttribute("notice")
	public NoticeVO notice() {
		return new NoticeVO();
	}

	/**
	 * notice 게시판 글 목록 출력 메소드 (selectList)
	 */
	@GetMapping
	public String noticeListUI(
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
	 * notice 게시판 글 목록 출력 메소드 (selectList)
	 */
	@GetMapping(produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String noticeListData(
			@RequestParam(value="page", required=false, defaultValue="1") int currentPage
			, @ModelAttribute("simpleCondition") SearchVO searchVO
			, Model model) {
		
		PagingVO<NoticeVO> pagingVO = new PagingVO<>(10, 5);
		pagingVO.setCurrentPage(currentPage);
		pagingVO.setSimpleCondition(searchVO);
		
		service.retrieveNoticeList(pagingVO);
		model.addAttribute("pagingVO", pagingVO);
		model.addAttribute("pagingHTML", renderer.renderPagination(pagingVO));
		
		return "jsonView";
	}
	
	/**
	 * 게시글 조회 메소드
	 */
	@GetMapping("/{notiId}")
	public String noticeView(
			@PathVariable String notiId
			, Model model) {
		NoticeVO notice = service.retrieveNotice(notiId);
		model.addAttribute("notice", notice);
		return "campus/notice/noticeView";
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * notice 게시글 등록 폼
	 * @return /jsp/campus/notice/noticeForm.jsp
	 */
	@GetMapping("/form")
	public String noticeForm() {
		return "campus/notice/noticeForm";
	}
	
	/**
	 * notice 게시글 등록 메소드 (insert)
	 * @param notice
	 * @param model
	 * @return /jsp/campus/notice/noticeForm.jsp
	 */
	@PostMapping("/form")
	public String noticeInsert(
			@Validated(InsertGroup.class) @ModelAttribute("notice") NoticeVO notice
			, Model model ) {
		
		String viewName = null;
		log.info("notice>>>>>>>>{}", notice);
		int rowcnt = service.createNotice(notice);
		if(rowcnt > 0) {
			viewName = "redirect:/campus/notice/" + notice.getNotiId();
		} else {
			model.addAttribute("message", "서버 오류");
			viewName = "campus/notice/noticeForm";
		}
		return viewName;
	}
	
//////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * notice 게시글 수정 폼
	 * @return /jsp/campus/notice/noticeEdit.jsp
	 */
	@GetMapping("/form/{notiId}")
	public String noticeEditForm(
			@PathVariable String notiId
			, Model model
			) {
		log.info("notiId>>>>>{}", notiId);
		NoticeVO notice = service.retrieveNotice(notiId);
		log.info("notice>>>>>{}", notice);
		model.addAttribute("notice", notice);
		return "campus/notice/noticeEdit";
	}
	
	/**
	 * notice 게시글 수정
	 */
	@PostMapping("/form/{notiId}")
	public String noticeEdit(
			@Validated(UpdateGroup.class) @ModelAttribute("notice") NoticeVO notice
			, @PathVariable String notiId
			, Model model
			) {
		String viewName = null;
		int rowcnt = service.modifyNotice(notice);
		if(rowcnt > 0) {
			viewName = "redirect:/campus/notice/" + notiId;
		} else {
			model.addAttribute("message", "서버 오류");
			viewName = "campus/noticeForm";
		}
		return viewName;
	}
	
//////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * notice 게시글 삭제
	 */
	@DeleteMapping("/{notiId}")
	public String noticeDelete(
			@Validated(DeleteGroup.class) @ModelAttribute("notiId") String id
			, @PathVariable String notiId
			, Model model
			) {
		String viewName = null;
		int rowcnt = service.removeNotice(id);
		if(rowcnt > 0) {
			viewName = "redirect:/campus/notice";
		} else {
			model.addAttribute("message", "서버 오류");
			viewName = "campus/notice";
		}
		return viewName;
	}
	
	/**
	 * notice 파일 삭제
	 */
	@ResponseBody
	@PostMapping("/DeleteFile")
	public int DeleteFile(
			@RequestBody AttaFileVO attaFileVO
			) {
		log.info("attaFileVO : " + attaFileVO);
		
		//0 또는 1
		int result = this.service.deleteAttaFileList(attaFileVO);
		
		log.info("result : " + result);
		
		return result;		
	}
}
