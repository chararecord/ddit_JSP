package kr.or.ddit.student.objection.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 성적이의신청 컨트롤러
 * @author 민경진
 *
 */
@Controller
public class ObjectionController {

	@RequestMapping("/student/objection")
	public String objection() {
		return "student/objection";
	}
}
