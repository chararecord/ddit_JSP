package kr.or.ddit.commons;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	// 인덱스 컨트롤ㄹ러가 되려면 web.xml에 관련된 속성 필요
	
	@RequestMapping("/index.do")
	public String index() {
		return "index";
	}
}
