package kr.or.ddit.emp.scholarshipManage.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.ScholarshipVO;

@Mapper
public interface ScholarshipEmpDAO {
	
	/**
	 * 게시글 개수 조회
	 * @param pagingVO
	 * @return
	 */
	public int selectTotalRecord(PagingVO<ScholarshipVO> pagingVO);
	
	
	public List<ScholarshipVO> selectScholarshipList(PagingVO<ScholarshipVO> pagingVO);
	
}
