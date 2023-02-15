package kr.or.ddit.student.test.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.TestVO;

@Mapper
public interface TestDAO {

	
	/**
	 * 게시글 전체 개수 조회
	 * @param pagingVO
	 * @return
	 */
	public int selectTotalRecord(PagingVO<TestVO> pagingVO);
	
	
	
	/**
	 * 게시글 조회
	 */
	public List<TestVO> selectTestList(PagingVO<TestVO> pagingVO);
	
	
	
}
