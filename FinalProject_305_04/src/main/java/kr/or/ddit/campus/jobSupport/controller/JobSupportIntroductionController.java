package kr.or.ddit.campus.jobSupport.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *  취업지원센터(자기소개서첨삭) 컨트롤러
 * @author 민경진
 *
 */
@Controller
public class JobSupportIntroductionController {

	@RequestMapping("/campus/jobSupport/introduction")
	public String introduction() {
		return "campus/introduction";
	}
}
