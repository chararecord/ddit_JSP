package kr.or.ddit.student.tuition.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 등록금 컨트롤러
 * @author 민경진
 *
 */
@Controller
public class TuitionController {

	@RequestMapping("/student/tuition")
	public String tuition() {
		return "student/tuition";
	}
}
