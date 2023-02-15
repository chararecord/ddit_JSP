package kr.or.ddit.prof.lectroom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ddit.prof.lectroom.service.ProfLectListService;
import kr.or.ddit.validate.UpdateGroup;
import kr.or.ddit.vo.AttendVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;



/**
 * 교수의 학생들 출결 관리 컨트롤러
 * @author 이현주
 * @Since 2023. 2. 6.
 * <pre>
 *
 * ======[[개정이력(Modification Information)]]======
 *   수정일                    수정자                        수정내용
 * --------          --------    -----------------------
 * 2023. 2. 6.       이현주	       	생성
 * 2023. 2. 9.		 이현주			수정
 *
 * Copyright (c) 2023 by DDIT All right reserved
 * </pre>
 */

/**
 * @return
 */
@Slf4j
@RequiredArgsConstructor
@RequestMapping("prof/")
@Controller
public class ProfAttnedManageController {

	
	@Autowired
	private final ProfLectListService service;
	
	@ModelAttribute
	public AttendVO profAttend() {
		return new AttendVO();
	}
	
	
	/**
	 * 한 학생의 상세 출결 현황 조회
	 * @param stdId
	 * @param lectId
	 * @param model
	 * @return
	 */
	@GetMapping("lectroom/profAttendManage")
	public String lectList(
			@RequestParam(value="stdId", required=true) int stdId
			,@RequestParam(value="lectId", required=true) String lectId
			, Model model
			) {
	
		List<AttendVO> attendVO = service.retrieveAttendManage(stdId, lectId);
		
		log.info("AttendVO{}", attendVO);
		model.addAttribute("attendVO", attendVO);
		
		return "prof/lectroom/profAttendManage";
	}
	
	/**
	 * 출결 관리(update)
	 * @param attendVO
	 * @return
	 */
	@ResponseBody
	@PostMapping("lectroom/profAttendManage")
	public AttendVO lectUpdate(
		@RequestBody AttendVO attendVO
		, Model model
	){
		System.out.println("attendVO 뭐임" + attendVO);
		
		int chgCnt = service.modifyAttendManage(attendVO);
		System.out.println("chgCnt값 얼마임?" + chgCnt);

		
		return attendVO;
	}
	
}
