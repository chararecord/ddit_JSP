package kr.or.ddit.emp.profInfo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *  교수정보관리 컨트롤러
 * @author 민경진
 *
 */
@Controller
public class ProfessorInfoController {

	@RequestMapping("/emp/profInfo")
	public String profInfo() {
		return "emp/profInfo";
	}
}
