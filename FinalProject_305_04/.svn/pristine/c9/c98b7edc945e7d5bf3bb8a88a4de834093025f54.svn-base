package kr.or.ddit.student.test.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.student.test.service.TestService;
import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.TestVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author 이선민
 * @Since 2023. 2. 2.
 * <pre>
 *
 * ======[[개정이력(Modification Information)]]======
 *   수정일                    수정자                        수정내용
 * --------        --------    -----------------------
 * 2023. 2. 1.       민경진             생성
 * 2023. 2. 2.       이선민             시험목록조회
 *
 * Copyright (c) 2023 by DDIT All right reserved
 * </pre>
 */

@Slf4j
@RequiredArgsConstructor
@Controller
public class TestController {

	
	private final TestService service;
	
	
	@RequestMapping("/student/test")
	public String testList(
			Model model 
	) {
		
		//목록 조회 + 전체 게시글 갯수 조회
		PagingVO<TestVO> pagingVO = new PagingVO<>(10, 5);
		service.retrieveTestList(pagingVO);
		
		//뷰에 내보내기
		model.addAttribute("pagingVO", pagingVO);
		return "student/test";
	}
	
	
	
	
	
}
