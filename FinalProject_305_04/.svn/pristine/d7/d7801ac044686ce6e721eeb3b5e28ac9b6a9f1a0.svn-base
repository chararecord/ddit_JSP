package kr.or.ddit.student.test.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.ddit.student.test.dao.TestDAO;
import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.TestVO;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service
public class TestServiceImpl implements TestService {
	
	@Inject
	private TestDAO testDAO;

	
	//게시글 목록 조회 
	@Override
	public void retrieveTestList(PagingVO<TestVO> pagingVO) {
		pagingVO.setTotalRecord(testDAO.selectTotalRecord(pagingVO)); //전체 게시글 갯수 조회
		pagingVO.setDataList(testDAO.selectTestList(pagingVO)); //목록 조회
	}
	
	
	
	
}
