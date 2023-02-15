package kr.or.ddit.emp.tuitionManage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.student.scholarship.service.ScholarshipService;
import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.ScholarshipVO;
import kr.or.ddit.vo.SearchVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
/**
 * @author 민경진
 * @Since 2023. 2. 2.
 * <pre>
 *
 * ======[[개정이력(Modification Information)]]======
 *   수정일                    수정자                        수정내용
 * --------        --------    -----------------------
 * 2023. 2. 2.       민경진             생성
 * 2023. 2. 3 		  이현주		수정
 *
 * Copyright (c) 2023 by DDIT All right reserved
 * </pre>
 */
@Slf4j
@Controller
public class TuitionEmpController {
	
//	private final ScholarshipService service;
	
	@RequestMapping("/emp/tuitionManage")
	
	public String tuitionManageList() {
			
		return "emp/tuitionManage/tuitionManage";
	}
}
