package kr.or.ddit.emp.studentInfo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ddit.emp.studentInfo.service.StudentInfoService;
import kr.or.ddit.validate.InsertGroup;
import kr.or.ddit.vo.BuildingVO;
import kr.or.ddit.vo.CollVO;
import kr.or.ddit.vo.MajorVO;
import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.ProfessorVO;
import kr.or.ddit.vo.SearchVO;
import kr.or.ddit.vo.SemesterVO;
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
public class StudentInfoInsertController {

	private final StudentInfoService service;
		
	/**
	 * studentInfo 속성 생성 메소드
	 * @return studentVO
	 */
	@ModelAttribute("studentInfo")
	public StudentVO studentInfo() {
		return new StudentVO();
	}
	

	
	
	/**
	 * studentInfo 게시글 등록 폼
	 * 
	 * @return emp/studentInfo/studentInfoForm
	 */
	@GetMapping("/studentInfoInsert")
	public String studentInfoForm(
		Model model
	) {
		//단과 셀렉트박스로 띄우기
		List<CollVO> collVO = service.retrieveCollList();
		model.addAttribute("collVO", collVO);
		
		//학기아이디 셀렉트박스로 띄우기
		List<SemesterVO> semesterVO = service.selectSemeList();
		model.addAttribute("semesterVO", semesterVO);
		
		return "emp/studentInfo/studentInfoForm";
	}
	
	
	

	
	
	/**
	 * studentInfo 게시글 등록 메소드 (insert)
	 * @param studentInfo
	 * @param model
	 * @return
	 */
	@PostMapping("/studentInfoInsert")
	public String studentInfoInsert(
			@Validated(InsertGroup.class) @ModelAttribute("studentInfo") StudentVO studentVO, String userId,
			 Model model) {
		String viewName = null;
		studentVO.setStdId(Integer.parseInt(userId));
		
		String rowcnt = service.createStuTotalStudentInfo(studentVO);
		if(rowcnt == "OK") {
			viewName = "redirect:/emp/studentInfoView?what="+studentVO.getUserId();
		}
		return viewName;
	}
	
	
	
	
	
	
	/**
	 * 단과 셀렉트를 통한 학과 리스트 출력
	 * @param 
	 * @return
	 */
	@ResponseBody
	@PostMapping("/selectMajorList")
	public List<MajorVO> selectMajorList(@RequestBody CollVO collVO) {
		log.info("collVO==================@@@"+ collVO);
		List<MajorVO> data = service.selectMajorList(collVO);
		return data;
	}
	
	/**
	 * 학과 셀렉트를 통한 교수 리스트 출력
	 * @param 
	 * @return
	 */
	@ResponseBody
	@PostMapping("/selectProfList")
	public List<ProfessorVO> selectProList(@RequestBody MajorVO majorVO) {
		log.info("majorVO============!!!!", majorVO);
		System.out.println("이거" + majorVO);
		List<ProfessorVO> data = service.selectProList(majorVO);
		log.info("data!!!!!!!!!!:"+data);
		return data;
	}
	
	
	
	
	
}






