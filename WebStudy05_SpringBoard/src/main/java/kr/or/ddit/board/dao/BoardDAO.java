package kr.or.ddit.board.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.vo.PagingVO;

@Mapper
public interface BoardDAO {
	public int insertBoard(BoardVO board);
	/**
	 * 게시글 목록 조회
	 * @param pagingVO
	 * @return 조건에 맞는 레코드가 없는 경우, 없다고 하기
	 */
	public List<BoardVO> selectBoardList(PagingVO<BoardVO> pagingVO);
	public int selectTotalRecord(PagingVO<BoardVO> pagingVO);
	public BoardVO selectBoard(int boNo);
	public int updateBoard(BoardVO board);
	public int deleteBoard(int boNo);
}
