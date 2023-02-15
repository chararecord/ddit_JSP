package kr.or.ddit.prof.lectroom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.prof.lectroom.service.ProfLectListService;
import kr.or.ddit.vo.LectureVO;
import kr.or.ddit.vo.MyLectureVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 본인 강의를 수강하는 학생들 목록 조회(교수) 컨트롤러
 * @author 이현주
 * @Since 2023. 2. 6.
 * <pre>
 *
 * ======[[개정이력(Modification Information)]]======
 *   수정일                    수정자                        수정내용
 * --------          --------    -----------------------
 * 2023. 2. 6.       이현주        		생성
 * 2023. 2. 7.       이현주        		수정
 *
 * Copyright (c) 2023 by DDIT All right reserved
 * </pre>
 */
@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/prof")
public class ProfAttendListController {

	@Autowired
	private final ProfLectListService service;
	
	@ModelAttribute
	public LectureVO profLectureList() {
		return new LectureVO();
	}
	
	
//	@ResponseBody
	@GetMapping(value="/lectroom/profAttendList",produces="application/json;charset=utf-8"
			)
	public String lectList(
			@RequestParam(value="lectId", required=true) String lectId
			, Model model
			) {
		log.info("학생 목록을 띄워라");
		
		MyLectureVO lectureVO = service.retrieveProfStdList(lectId);
		
		model.addAttribute("lectureVO", lectureVO);
		
		return "prof/lectroom/profAttendList";
	}
}
