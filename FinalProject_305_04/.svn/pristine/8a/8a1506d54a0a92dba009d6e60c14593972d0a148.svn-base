package kr.or.ddit.emp.studentInfo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.emp.studentInfo.service.StudentInfoService;
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
	
	//2개로 쪼개짐
	@RequestMapping("studentInfo")
	public String studentInfoList(
			@RequestParam(value="page", required=false, defaultValue="1") int currentPage 
			, @ModelAttribute("simpleCondition") SearchVO searchVO
			, Model model
	) {
		PagingVO<StudentVO> pagingVO = new PagingVO<>();
		pagingVO.setCurrentPage(currentPage);
		pagingVO.setSimpleCondition(searchVO);
		
		service.retrieveStudentInfoList(pagingVO);
		
		model.addAttribute("pagingVO", pagingVO);
		
		return "emp/studentInfo/studentInfoList";
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
