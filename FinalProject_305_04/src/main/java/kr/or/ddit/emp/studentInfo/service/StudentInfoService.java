package kr.or.ddit.emp.studentInfo.service;

import java.util.List;

import kr.or.ddit.vo.CollVO;
import kr.or.ddit.vo.MajorVO;
import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.ProfessorVO;
import kr.or.ddit.vo.RecordVO;
import kr.or.ddit.vo.SemesterVO;
import kr.or.ddit.vo.StudentVO;

public interface StudentInfoService {

	/**
	 * 게시글 목록 조회
	 * @param pagingVO
	 */
	public void retrieveStudentInfoList(PagingVO<StudentVO> pagingVO);
	/**
	 * 게시글 단건 조회
	 * @param notiId
	 * @return
	 */
	public StudentVO retrieveStudentInfo(int stdId);
	

	/**
	 * 게시글 등록
	 * @param notice
	 * @return
	 */
	public int createUserStudentInfo(StudentVO userId);
	public int createStuStudentInfo(StudentVO userId);
	public int createRecordStudentInfo(StudentVO userId);
	//전체 받아오기
	public String createStuTotalStudentInfo(StudentVO userId);
	
	
	
	/**
	 * 업데이트하기
	 * @param userId
	 * @return
	 */
	public int updateStuStudentInfo(StudentVO userId);
	public int updateUserStudentInfo(StudentVO userId);
	public RecordVO updateSelectRecordStudentInfo(int userId);
	//전체 받아오기
	public String updateStuTotalStudentInfo(StudentVO userId);
	
	
	/**
	 * 단과대학 셀렉트박스로 가져오기
	 * @return
	 */
	public List<CollVO> retrieveCollList();
	
	
	/**
	 * 학과 셀렉트박스
	 * @param collVO
	 * @return
	 */
	public List<MajorVO> selectMajorList(CollVO collVO);
	
	/**
	 * 교수 셀렉트박스
	 * @param majorVO
	 * @return
	 */
	public List<ProfessorVO> selectProList(MajorVO majorVO);
	
	/**
	 * 학기아이디 셀렉트박스로 가져오기
	 * @return
	 */
	public List<SemesterVO> selectSemeList();
}






















