package kr.or.ddit.student.record.service;

import java.util.List;

import kr.or.ddit.vo.CollVO;
import kr.or.ddit.vo.MajorVO;
import kr.or.ddit.vo.RecordVO;
import kr.or.ddit.vo.SemesterVO;
import kr.or.ddit.vo.StudentVO;

/**
 * @author 장은호
 * @Since 2023. 2. 14.
 * <pre>
 *
 * ======[[개정이력(Modification Information)]]======
 *   수정일                    수정자                        수정내용
 * --------          --------    -----------------------
 * 2023. 2. 14.       장은호            생성
 *
 * Copyright (c) 2023 by DDIT All right reserved
 * </pre>
 */
public interface RecordService {

	/**
	 * 한 학생의 개인 정보 및 학적 정보 조회
	 * @param stdId
	 * @return 학적 목록
	 */
	public StudentVO retrieveRecordList(int stdId);
	
	/**
	 * 학생의 학적 변동 신청
	 * @param record
	 * @return
	 */
	public int createRecord(RecordVO record);
	
	
	/**
	 * 전체 단과대학 목록 조회
	 * @return
	 */
	public List<CollVO> retrieveCollegeList();
	
	
	/**
	 * 단과대학 내 학과 목록 조회
	 * @param collvo
	 * @return
	 */
	public List<MajorVO> retrieveMajorList(CollVO collVO);
	
	public SemesterVO retrieveSemester();
	
	public SemesterVO retrieveNextSemester(SemesterVO semesterVO);
	
	
	/**
	 * 해당 학생의 학적 목록 조회
	 * @param pagingVO
	 */
//	public StudentVO retrieveStudentRecordList(int stdId);
	
}
