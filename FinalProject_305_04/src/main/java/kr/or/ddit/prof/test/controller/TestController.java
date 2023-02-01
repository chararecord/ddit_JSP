package kr.or.ddit.prof.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 시험 컨트롤러
 * @author 민경진
 *
 */
@Controller
public class TestController {

	@RequestMapping("/prof/test")
	public String test() {
		return "prof/test";
	}
}
