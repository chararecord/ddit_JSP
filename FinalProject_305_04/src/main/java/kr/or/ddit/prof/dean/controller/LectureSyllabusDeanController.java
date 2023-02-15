package kr.or.ddit.prof.dean.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ddit.prof.dean.service.LectureSyllabusDeanService;
import kr.or.ddit.vo.SyllabusVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author 서범수
 * @Since 2023. 2. 13.
 * <pre>
 *
 * ======[[개정이력(Modification Information)]]======
 *   수정일           수정자                수정내용
 * --------          --------    -----------------------
 * 2023. 2. 13.       PC-17        강의계획서 조회(학과장) 컨트롤러
 *
 * Copyright (c) 2023 by DDIT All right reserved
 * </pre>
 */
@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/prof")
public class LectureSyllabusDeanController {

	@Autowired
	private final LectureSyllabusDeanService service;
	
	@GetMapping("/deanSyllaView")
	public String lectSyllaViewDean(
			Model model
		) {
		
		List<SyllabusVO> syllabusVO = service.retrieveDeanSyllaList();
//		System.out.println("syllabusVO값 뭔지 알아보자 : " + syllabusVO);
		log.info("syllabusVO", syllabusVO);
		model.addAttribute("syllabusVO", syllabusVO);
		
		return "prof/lectSylla/lectSyllaManage";
	}
	
	@PostMapping("/detailSylla")
	@ResponseBody
	public Map<String, Object> detailSylla(
			@RequestBody SyllabusVO syllabusVO
			, Model model
		){
		log.info("디테일 계획서 진입");
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		SyllabusVO syllaOne = service.retrieveDeanSylla(syllabusVO);
		System.out.println("syllaOne 값 뭔지 알아보자: " + syllaOne);
		resultMap.put("syllabus", syllaOne);
		
		return resultMap;
	}
	
}
