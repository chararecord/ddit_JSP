package kr.or.ddit.student.scholarship.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.student.scholarship.service.ScholarshipService;
import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.ScholarshipVO;
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
 * 2023. 2. 3 		  이현주		수정
 *
 * Copyright (c) 2023 by DDIT All right reserved
 * </pre>
 */
@Slf4j
@RequiredArgsConstructor
@Controller
public class ScholarshipController {
	
	private final ScholarshipService service;
	
	@RequestMapping("/student/scholarship")
	public String scholarshipList(
			@RequestParam(value="page", required=false, defaultValue="1") int currentPage
			, @ModelAttribute("simpleCondition") SearchVO searchVO
			, Model model ) {
		PagingVO<ScholarshipVO> pagingVO = new PagingVO<>(10, 5);
		pagingVO.setCurrentPage(currentPage);
		pagingVO.setSimpleCondition(searchVO);
		
		service.retrieveScholarshipList(pagingVO);
		model.addAttribute("pagingVO", pagingVO);
		
		return "student/scholarship/scholarship";
	}
}
