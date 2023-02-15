package kr.or.ddit.emp.studentInfo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.vo.CollVO;
import kr.or.ddit.vo.MajorVO;
import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.ProfessorVO;
import kr.or.ddit.vo.RecordVO;
import kr.or.ddit.vo.SemesterVO;
import kr.or.ddit.vo.StudentVO;

/**
 * @author 송지은
 * @Since 2023. 2. 2.
 * <pre>
 *
 * ======[[개정이력(Modification Information)]]======
 *   수정일                      수정자                        수정내용
 * --------          --------    -----------------------
 * 2023. 2. 2.       송지은        	    생성
 *
 * Copyright (c) 2023 by DDIT All right reserved
 * </pre>
 */
@Mapper
public interface StudentInfoDao {
	
	/**
	 * 게시글 개수 조회
	 * @param pagingVO
	 * @return
	 */
	public int selectTotalRecord(PagingVO<StudentVO> pagingVO);
	/**
	 * 조회수 증가
	 * @param notiId
	 */
	public void incrementHit(int notiId);
	
	/**
	 * 목록
	 * @param pagingVO
	 * @return
	 */
	public List<StudentVO> selectStudentInfoList(PagingVO<StudentVO> pagingVO);
	
	/**
	 * 상세조회
	 * @param studentId
	 * @return
	 */
	public StudentVO selectStudentInfo(int stdId);
	
	
	
	
	
	/**
	 * 등록하기 (user, student, record)
	 * @param userId
	 * @return
	 */
	public int insertUserStudentInfo(StudentVO userId);
	public int insertStuStudentInfo(StudentVO userId);
	public int insertRecordStudentInfo(StudentVO userId);
	
	
	/**
	 * 업데이트하기(user, student, record)
	 * @param userId
	 * @return
	 */
	public int updateStuStudentInfo(StudentVO userId);
	public int updateUserStudentInfo(StudentVO userId);
	public RecordVO updateSelectRecordStudentInfo(int userId);
	
	
	/**
	 * 단과 목록 셀렉트박스로 가져오기
	 * @return
	 */
	public List<CollVO> selectCollList();
	
	/**
	 * 단과 선택을 통한 학과 목록 셀렉트박스로 가져오기
	 * @param collVO
	 * @return
	 */
	public List<MajorVO> selectMajorList(CollVO collVO);
	
	/**
	 * 학과 선택을 통한 교수 셀렉트박스로 가져오기
	 * @param collVO
	 * @return
	 */
	public List<ProfessorVO> selectProList(MajorVO majorVO);
	
	/**
	 * 학기아이디 목록 셀렉트박스로 가져오기
	 * @return
	 */
	public List<SemesterVO> selectSemeList();
	
	
	
}




















