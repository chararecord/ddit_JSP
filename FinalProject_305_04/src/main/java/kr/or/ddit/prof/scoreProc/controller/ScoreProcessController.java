package kr.or.ddit.prof.scoreProc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author PC-17
 * @Since 2023. 2. 6.
 * <pre>
 * 성적처리 컨트롤러
 * ======[[개정이력(Modification Information)]]======
 *   수정일          수정자             수정내용
 * --------          --------    -----------------------
 * 2023. 2. 6.       서범수        성적처리 컨트롤러 생성
 *
 * Copyright (c) 2023 by DDIT All right reserved
 * </pre>
 */
@Controller
public class ScoreProcessController {
	
	@RequestMapping("/prof/scoreProcess")
	public String scoreProcess() {
		return "prof/scoreProcess/scoreProcess";
	}
}
