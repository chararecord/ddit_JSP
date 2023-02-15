package kr.or.ddit.emp.studentInfo.controller;

import java.util.List;

import javax.naming.AuthenticationException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ddit.emp.studentInfo.service.StudentInfoService;
import kr.or.ddit.validate.UpdateGroup;
import kr.or.ddit.vo.CollVO;
import kr.or.ddit.vo.MajorVO;
import kr.or.ddit.vo.ProfessorVO;
import kr.or.ddit.vo.SemesterVO;
import kr.or.ddit.vo.StudentVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/emp/studentInfoEdit.do")
public class StudentInfoUpdateController {
	
	private final StudentInfoService service;
	
	@GetMapping
	public String updateForm(@RequestParam("what") int userId, Model model) {
		StudentVO student = service.retrieveStudentInfo(userId);
		model.addAttribute("studentInfo", student);
		
		//단과 셀렉트박스로 띄우기
		List<CollVO> collVO = service.retrieveCollList();
		model.addAttribute("collVO", collVO);
		
		//학기아이디 셀렉트박스로 띄우기
		List<SemesterVO> semesterVO = service.selectSemeList();
		model.addAttribute("semesterVO", semesterVO);
		
		return "emp/studentInfo/studentInfoEdit";
	}
	
	
	
	
	@PostMapping
	public String studentInfoUpdate(
		@Validated(UpdateGroup.class) @ModelAttribute("studentInfo") StudentVO studentVO
		, Errors errors
		, Model model
	) throws AuthenticationException {
		String viewName = null;
		if(!errors.hasErrors()) {
			String rowcnt = service.updateStuTotalStudentInfo(studentVO);
			if(rowcnt == "OK") {
				viewName = "redirect:/emp/studentInfoView.do?what="+studentVO.getUserId();
				
			}else {
				model.addAttribute("message", "서버 오류, 쫌따 다시");
				viewName = "emp/studentInfo/studentInfoEdit";
			}
		} else {
			viewName = "emp/studentInfo/studentInfoEdit";
		}
		return viewName;
		
	}
	
	
	 
	
	/**
	 * 단과 셀렉트를 통한 학과 리스트 출력
	 * @param 
	 * @return
	 */
	@ResponseBody
	@PostMapping("/selectList")
	public List<MajorVO> selectMajorList(@RequestBody CollVO collVO) {
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
		List<ProfessorVO> data = service.selectProList(majorVO);
		return data;
	}
	
}
