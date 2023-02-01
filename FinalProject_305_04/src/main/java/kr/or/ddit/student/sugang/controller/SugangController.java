package kr.or.ddit.student.sugang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 성적이의신청 컨트롤러
 * @author 민경진
 *
 */
@Controller
public class SugangController {

	@RequestMapping("/student/sugang")
	public String sugang() {
		return "student/sugang";
	}
}
