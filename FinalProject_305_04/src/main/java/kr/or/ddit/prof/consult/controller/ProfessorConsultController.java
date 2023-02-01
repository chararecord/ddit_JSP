package kr.or.ddit.prof.consult.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *  학생 상담 컨트롤러(교수)
 * @author 민경진
 *
 */
@Controller
@RequestMapping("/prof/consult")
public class ProfessorConsultController {

	@RequestMapping("/on")
	public String onConsult() {
		return "prof/onConsult";
	}
	
	@RequestMapping("/on/detail")
	public String onConsultdetail() {
		return "prof/onConsultDetail";
	}
	
	@RequestMapping("/off")
	public String offConsult() {
		return "prof/offConsult";
	}
}
