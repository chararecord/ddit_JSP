package kr.or.ddit.student.curLect.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 수강중인 강의 목록 컨트롤러
 * @author 민경진
 *
 */
@Controller
public class CurrentLectureController {
	
	@RequestMapping("/student/curLect")
	public String curLect() {
		return "student/curLect";
	}
}
