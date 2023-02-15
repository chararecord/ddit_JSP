package kr.or.ddit.student.test.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.TestAllowVO;
import kr.or.ddit.vo.TestVO;

public interface TestService {

	
	/**
	 * 게시글 목록 조회 + 전체 게시글 갯수 조회
	 * @param pagingVO
	 * @return 
	 */
	public List<TestVO> retrieveTestList(PagingVO<TestVO> pagingVO);
	
	

	
	/**
	 * 시험응시 insert
	 * @param test
	 * @return
	 */
	public int createTestAllow(TestVO test);
	
	
	/**
	 * 시험 상세조회
	 * @param testId
	 * @return 
	 */
	public TestVO retrieveTest(String testAllowId);
	
	
	/**
	 * 학생제출답안  insert
	 * @param test
	 * @return
	 */
	public int submitStudentAns(TestVO test);



	/**
	 * 시험 상세조회2 
	 * @param testAllowId
	 * @return Map<String,String>
	 */
	public Map<String, String> selectTest2(String testAllowId);
	

	
	
	
}
