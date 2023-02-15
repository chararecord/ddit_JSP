package kr.or.ddit.student.test.controller;


import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.ddit.student.test.service.TestService;
import kr.or.ddit.validate.InsertGroup;
import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.SearchVO;
import kr.or.ddit.vo.TestAllowVO;
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
@RequestMapping("/student/test/**")
public class TestController {

	
	private final TestService service;
	
	
	/**
	 * test 속성 생성 메소드
	 * @return
	 */
	@ModelAttribute("test")
	public TestVO test() {
		return new TestVO();
	}
	
	
	/**
	 * 시험목록
	 * @param currentPage
	 * @param simpleConition
	 * @param model
	 * @return
	 */
	@GetMapping
	public ModelAndView testList(
			@RequestParam(value="page", required=false, defaultValue="1") int currentPage
			, @ModelAttribute SearchVO simpleConition 
			, Model model 
	) {
		//목록 조회 + 전체 게시글 갯수 조회
		PagingVO<TestVO> pagingVO = new PagingVO<>(10, 5);
		pagingVO.setCurrentPage(currentPage); 
		pagingVO.setSimpleCondition(simpleConition); //검색 
		
		ModelAndView mav = new ModelAndView();
		
		List<TestVO> test =  service.retrieveTestList(pagingVO);
		
		model.addAttribute("TestVO", test);
		
		
		
		//뷰에 내보내기
		mav.addObject("pagingVO", pagingVO); //model.addAttribute("pagingVO", pagingVO);
		mav.addObject("test", test);
		mav.setViewName("student/test/test");
		
		return mav;
	}
	
	
	/**
	 * 시험응시 INSERT
	 * 시험목록 > 시험응시 컨트롤러로 이동 후 정보 저장하고 > 시험목록 > 시험상세보기 컨트롤러로 이동 
	 * @param test
	 * @param model
	 * @return
	 * 
	 *  // 시험명 클릭시 
	 *	// 시험명 클릭시 시험에 응시하시겠습니까? 팝업창 =>
	 *	// testAllow 컨트롤러로 이동 =>  insert쿼리문 실행 (넘어간 데이터들은 자동으로 allow컨트롤러에 등록됨)
	 *	// testAllow에서 testView컨트롤러로 redirect => testView로 데이터를 가지고 이동됨 
	 *	// testView컨트롤러로 이동할때 testAllow가 가지고있는 파라미터 같이 옮겨주기 
	 * 
	 * 
	 */
	
	@RequestMapping("/testAllow")
	public String testAllowInsert(
		@Validated(InsertGroup.class) @ModelAttribute("test") TestVO test
		, Model model
	) {
		
		String viewName = null;
		
		log.info("testAllow>>>>>>>>{}", test);
		int rowcnt = service.createTestAllow(test);

//		// TestView 컨트롤러로 redirect하면서 파라미터 넘기기 
		if(rowcnt > 0) {
			viewName = "redirect:/student/test/testView?testAllowId="+test.getTestAllowId(); 
		} 
		return viewName;
	}

	
	
	/**
	 * 시험상세보기
	 * @param testId
	 * @param model
	 * @return
	 */
	@RequestMapping("/testView")
	public String TestView(
	 @RequestParam(value="testAllowId",required=true) String testAllowId 
		, Model model
	) {
		
		log.info("testAllowIdsdfsdf{}=======================", testAllowId);
		TestVO test = service.retrieveTest(testAllowId);
		Map<String,String> map = service.selectTest2(testAllowId);

		model.addAttribute("test", test);
		model.addAttribute("map", map);
		
		return "student/test/testView";
	}

	

	/**
	 * 학생 시험 제출 
	 * @param test
	 * @param errors
	 * @param model
	 * @return
	 * 
	 * 0) 제출 버튼 클릭
	 * 1) 시험답안테이블(test_ans) insert
	 * 
	 * 
	 * 2) 제출한 답안(test_ans)과 시험지문 정답(test_pasg)와 비교 후 => 같으면 정답, 다르면 오답 
	 * 3) where "정답" 갯수를  *5해서 시험응시(test_allw) 시험점수 컬럼에 insert   
	 * 4) test_allw 시험점수 insert 완료후 student/test 화면으로 리다이렉트  => testAllowId를 primary key로 넘겨주기 
	 * 3) 리다이렉트 되면서 primary key testAllowId값이 동일한 테스트 일 경우 테스트 접근 못하게 막기
	 * 4) + 목록에  testAllowId값이 들어와 있을 경우 "응시완료" 텍스트 뜨게하기  
	 * 
	 * 
	 * 5) testAllowId에  insert 되면 뒤로 못가게 막기
	 * 

	 * 
	 */
	@PostMapping("/testAns")
	public String testAnsInsert(
		@Validated(InsertGroup.class) @ModelAttribute("test") TestVO test
		, Model model
	) {
		
		log.info("sdf============={}", test);
		
		String viewName = null;
		int rowcnt = service.submitStudentAns(test);
		if(rowcnt > 0) {
			viewName = "student/test";
		} else {
			model.addAttribute("message", "서버 오류");
			viewName = "campus/notice/noticeForm";
		}
		return viewName;
	}

		
	
	
	
	
}
