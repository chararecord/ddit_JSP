package kr.or.ddit.campus.news.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *  뉴스 컨트롤러
 * @author 민경진
 *
 */
@Controller
public class NewsController {

	@RequestMapping("/campus/jobSupport/news")
	public String news() {
		return "campus/news";
	}
}
