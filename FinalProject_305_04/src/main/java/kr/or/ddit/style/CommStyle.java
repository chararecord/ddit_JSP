package kr.or.ddit.style;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/style")
public class CommStyle {

	@RequestMapping("/cmpt.do")
	public String style() {
		return "style/commStyle";
	}
	
	@RequestMapping("/tab.do")
	public String tab() {
		return "style/tab";
	}
	

	
}
