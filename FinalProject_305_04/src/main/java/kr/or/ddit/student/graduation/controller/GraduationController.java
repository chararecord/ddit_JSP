package kr.or.ddit.student.graduation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 졸업요건 컨트롤러
 * @author 민경진
 *
 */
@Controller
public class GraduationController {
	
	@RequestMapping("/student/graduation")
	public String graduation() {
		return "student/graduation";
	}
}
