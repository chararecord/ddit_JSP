package kr.or.ddit.student.test.service;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.ddit.student.test.dao.TestDAO;
import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.TestAllowVO;
import kr.or.ddit.vo.TestVO;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service
public class TestServiceImpl implements TestService {
	
	@Inject
	private TestDAO testDAO;

	
	
	/**
	 * 시험 목록 조회 
	 */
	@Override
	public List<TestVO> retrieveTestList(PagingVO<TestVO> pagingVO) {
		
		pagingVO.setTotalRecord(testDAO.selectTotalRecord(pagingVO)); //전체 게시글 갯수 조회
		List<TestVO> testList = testDAO.selectTestList(pagingVO);
		pagingVO.setDataList(testDAO.selectTestList(pagingVO)); //목록 조회
		
		return testList;
	}


	/**
	 * 시험 응시 INSERT
	 */
	@Override
	public int createTestAllow(TestVO test) {
		//log.info("insert allow>>>>>. {} ", test);

		int rowcnt = testDAO.insertTestAllow(test);
		return rowcnt;
	}
	
	
	/**
	 * 시험 상세조회 
	 */
	@Override
	public TestVO retrieveTest(String testId) {
		TestVO test = testDAO.selectTest(testId);
		//log.info("뷰!!!!!!!!!!! >>>>>. {} ", test);
		if(test == null) {
			throw new RuntimeException(String.format("%s는 없는 시험",testId));
		}
		return test;
	}

	/**
	 * 시험 상세조회2 
	 * @param testAllowId
	 * @return Map<String,String>
	 */
	@Override
	public Map<String,String> selectTest2(String testAllowId){
		return testDAO.selectTest2(testAllowId);
	}
	
	/**
	 * 학생제출답안  insert
	 */
	@Override
	public int submitStudentAns(TestVO test) {
		
		log.info("학생제출답안 !!!!!!!!!! {}", test);
		int rowcnt = testDAO.inserStudentAns(test);
		return rowcnt;
	}

	
	
	
	
	
	
	
}
