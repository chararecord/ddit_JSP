package kr.or.ddit.common.pdf.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PdfController {

	@RequestMapping("/pdf")
	public String pdf(
		Model model
	) {
		List<String> list = new ArrayList<String>();
		list.add("경");
		list.add("진");
		list.add("이");
		list.add("의");
		list.add("테");
		list.add("스");
		list.add("트");
		
		// view 에게 전달할 데이터 저장
		model.addAttribute("list", list);
		
		// view name return
		return "common/pdf";
	}
}
