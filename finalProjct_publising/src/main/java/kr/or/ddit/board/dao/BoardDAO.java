package kr.or.ddit.board.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.vo.PagingVO;

@Repository
@Mapper //mybatis에 의해서 이 구현체가 proxy로 사용될수있음 
public interface BoardDAO {
	
	//게시글 추가 
	public int insertBoard(BoardVO board);
	
	//전체 게시글 조회 
	public List<BoardVO> selectBoardList(PagingVO<BoardVO> pagingVO);
	
	//검색
	public int selectTotalRecord(PagingVO<BoardVO> pagingVO);
	//pagingVO 단순검색 조건과 상세 검색 조건 다 가지욋음
	  
	//한 건의 게시글 조회 
	public BoardVO selectBoard(int boNo);
	public void incrementHit(int boNo);
	
	//게시글 수정 
	public int updateBoard(BoardVO board);
	
	//게시글 삭제
	public int deleteBoard(int boNo);

}
