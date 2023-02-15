package kr.or.ddit.student.record.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.vo.CollVO;
import kr.or.ddit.vo.MajorVO;
import kr.or.ddit.vo.RecordVO;
import kr.or.ddit.vo.SemesterVO;
import kr.or.ddit.vo.StudentVO;

/**
 * @author 장은호
 * @Since 2023. 2. 2.
 * <pre>
 *
 * ======[[개정이력(Modification Information)]]======
 *   수정일                    수정자                        수정내용
 * --------          --------    -----------------------
 * 2023. 2. 2.       장은호        		생성
 * 2023. 2. 14.      장은호                   selectRecordList, insertRecord, 	
 * 									selectCollegeList, selectMajorList, 
 * 									selectSemester, selectNextSemester 추가
 *
 * Copyright (c) 2023 by DDIT All right reserved
 * </pre>
 */
@Mapper
public interface RecordDAO {
	
	// 한 학생의 학적
	
	/**
	 * 한 학생의 개인 정보 및 학적 정보 조회
	 * @param stdId
	 * @return 해당 학생의 전체 개인 정보와 학적 정보
	 */
	public StudentVO selectRecordList(int stdId);

	/**
	 * 학생의 학적 변동 신청
	 * @param record
	 * @return 신청 성공된 건수
	 */
	public int insertRecord(RecordVO record);
	
	// 전체 단과대학 목록 조회
	public List<CollVO> selectCollegeList();
	
	// 선택 단과대학 내 학과 목록 조회
	public List<MajorVO> selectMajorList(CollVO collVO);

	// 가까운 해당 학사연도(휴학)
	public SemesterVO selectSemester();
	
	// 다음 학사연도
	public SemesterVO selectNextSemester(SemesterVO semesterVO);
	
	
	
	/**
	 * 해당 학생의 학적 내역 전체 개수 조회
	 * @param pagingVO
	 * @return
	 */
//	public int selectStudentTotalResults(int stdId);
	
	
	
	
	
	
//	selectResultsList;
//	updateRecord;

	
	// 전체 학생의 학적
	
	/**
	 * 학적 전체 개수 조회
	 * @param pagingVO
	 * @return
	 */
//	public int selectTotalResults(PagingVO<StudentVO> pagingVO);
	
}
