package kr.or.ddit.prof.lectroom.service;

import java.util.List;

import kr.or.ddit.vo.AttendVO;
import kr.or.ddit.vo.LectureVO;
import kr.or.ddit.vo.MyLectureVO;
import kr.or.ddit.vo.ProfessorVO;

/**
 * 교수의 나의 강의 목록 조회
 * @author 이현주
 * @Since 2023. 2. 7.
 * <pre>
 *
 * ======[[개정이력(Modification Information)]]======
 *   수정일                    수정자                        수정내용
 * --------          --------    -----------------------
 * 2023. 2. 7.       이현주       			생성
 *
 * Copyright (c) 2023 by DDIT All right reserved
 * </pre>
 */
public interface ProfLectListService {
	
	
	/**
	 * 나의 강의 목록 조회(교수)
	 */
	public List<ProfessorVO> retrieveProfLectList(int profId, String semeId);
	
	/**
	 * 나의 강의를 듣는 학생 목록 조회(교수)
	 */
	public MyLectureVO retrieveProfStdList(String lectId);
	

	/**
	 * 나의 강의를 듣는 학생들 출결 관리(교수)
	 */
	public List<AttendVO> retrieveAttendManage(int stdId, String lectId);
	
	
	/**
	 * 출결 관리(update)
	 * @param attendStat
	 * @return
	 */
	public int modifyAttendManage(AttendVO attendVO);
	
}
