package kr.or.ddit.emp.studentInfo.controller;

import javax.annotation.Resource;

import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.filter.HiddenHttpMethodFilter;

import kr.or.ddit.emp.studentInfo.service.StudentInfoService;
import kr.or.ddit.ui.PaginationRenderer;
import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.SearchVO;
import kr.or.ddit.vo.StudentVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 *  학생정보관리 컨트롤러
 * @author 민경진
 *
 */
@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/emp")
public class StudentInfoRetrieveController {

	private final StudentInfoService service;
	
	@Resource(name="bootstrapPaginationRender")
	private PaginationRenderer renderer;
	
	@Bean
	public HiddenHttpMethodFilter hiddenHttpMethodFilter(){
		return new HiddenHttpMethodFilter();
	}

	
	/*
	 * studentInfo 속성 생성 메소드
	 */
	@ModelAttribute("studentInfo")
	public StudentVO studentInfo() {
		return new StudentVO();
	}
	
	
	//List 접근할 때 목록 처음에 띄워주는 컨트롤러 (List 목록으로 보내줌)
	@RequestMapping("studentInfo")
	public String studentInfoList(
			@RequestParam(value="page", required=false, defaultValue="1") int currentPage 
			, @ModelAttribute("simpleCondition") SearchVO searchVO
			, Model model
	) {
		PagingVO<StudentVO> pagingVO = new PagingVO<>(10,5);
		pagingVO.setCurrentPage(currentPage);
		pagingVO.setSimpleCondition(searchVO);
		
		service.retrieveStudentInfoList(pagingVO);
		
		model.addAttribute("pagingVO", pagingVO);
		
		return "emp/studentInfo/studentInfoList";
	}
	
	/**
	 * studentInfo jsp AJAX를 통해 페이지 번호 클릴할 때 실행되는 메소드. 
	 * @param currentPage
	 * @param searchVO
	 * @param model
	 * @return
	 */
	@GetMapping(value="studentInfo", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String studentInfoListData(
			@RequestParam(value="page", required=false, defaultValue="1") int currentPage
			,@ModelAttribute("simpleCondition") SearchVO searchVO
			,Model model
	){
		PagingVO<StudentVO> pagingVO = new PagingVO<>(10,5);
		pagingVO.setCurrentPage(currentPage);
		pagingVO.setSimpleCondition(searchVO);
		
		service.retrieveStudentInfoList(pagingVO);
		model.addAttribute("pagingVO", pagingVO);
		model.addAttribute("pagingHTML", renderer.renderPagination(pagingVO));
		
		return "jsonView";
		
	}
	
	
	
	
	
	
	
	@RequestMapping("studentInfoView")
	public String studentInfoView(
		@RequestParam("what") int stdId
		, Model model
	) {
		
		StudentVO student = service.retrieveStudentInfo(stdId);
		
		model.addAttribute("studentInfo", student);
		
		return "emp/studentInfo/studentInfoView";
	}
}
