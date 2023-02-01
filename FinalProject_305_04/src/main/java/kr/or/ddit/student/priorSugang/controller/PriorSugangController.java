package kr.or.ddit.student.priorSugang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 성적이의신청 컨트롤러
 * @author 민경진
 *
 */
@Controller
public class PriorSugangController {

	@RequestMapping("/student/priorSugang")
	public String priorSugang() {
		return "student/priorSugang";
	}
}
