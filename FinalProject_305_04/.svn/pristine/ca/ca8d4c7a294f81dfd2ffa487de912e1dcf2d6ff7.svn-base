package kr.or.ddit.student.record.contoller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ddit.student.record.service.RecordService;
import kr.or.ddit.vo.CollVO;
import kr.or.ddit.vo.MajorVO;
import kr.or.ddit.vo.RecordVO;
import kr.or.ddit.vo.SemesterVO;
import kr.or.ddit.vo.StudentVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 학적조회 컨트롤러
 * @author 민경진
 *
 */
@Slf4j
@RequiredArgsConstructor
@Controller
public class RecordController {
	
	private final RecordService service;
	
	
	/**
	 * 해당 학생의 학적 정보 목록 출력 메소드
	 * @param stdId
	 * @param model
	 * @return 
	 */
	@GetMapping("/student/record")
	public String recordList(
		@RequestParam(value="stdId", required=true) int stdId
		, Model model
	) {
		StudentVO savedData = service.retrieveRecordList(stdId);
		if(savedData==null) {
			return "error/500";
		}
		
		model.addAttribute("studentInfo", savedData);

		return "student/record/record";
	}
	
	
	
	@GetMapping("/student/record/insert")
	public String recordInsert(
		@RequestParam(value="stdId", required=true) int stdId
		, Model model
	) {
		StudentVO studentInfo = service.retrieveRecordList(stdId);
		
		List<CollVO> collegeList = service.retrieveCollegeList();
		model.addAttribute("collegeList", collegeList);
		
//		LocalDate now = LocalDate.now();
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
//		String formatedNow = now.format(formatter);
		SemesterVO semesterVO = service.retrieveSemester();
		model.addAttribute("semesterVO", semesterVO);
		
		SemesterVO nextSemesterVO = service.retrieveNextSemester(semesterVO);
		model.addAttribute("nextSemesterVO", nextSemesterVO);
		
		model.addAttribute("studentInfo", studentInfo);
		return "student/record/recordInsert";
	}
	
	
	@ResponseBody
	@PostMapping(value="/student/record/insert", produces="application/json;charset=utf-8")
	public Map<String, Object> recordInsertProcess(
		@RequestBody RecordVO record
		, Model model
	) {
		
		log.info("==찍어보자 {}", record.toString());
		
		service.createRecord(record);
		StudentVO savedInfo = service.retrieveRecordList(record.getStdId());
		Map<String, Object> studentInfo = new HashMap<>();
		studentInfo.put("savedInfo", savedInfo);
		
		return studentInfo;
	}
	
	@ResponseBody
	@PostMapping("/student/selectMajorList")
	public List<MajorVO> selectMajorList(
		@RequestBody CollVO collVO
	) {
		List<MajorVO> data = service.retrieveMajorList(collVO);
		return data;
	}
	
	
	
	
}
