package kr.or.ddit.student.lectSylla.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 강의공지사항 컨트롤러
 * @author 민경진
 *
 */
@Controller
public class LectureSyllabusController {
	
	@RequestMapping("/student/lectSylla")
	public String lectSylla() {
		return "student/lectSylla";
	}
}
