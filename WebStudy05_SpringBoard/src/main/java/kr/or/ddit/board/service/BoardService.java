package kr.or.ddit.board.service;

import kr.or.ddit.board.vo.AttatchVO;
import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.vo.PagingVO;

public interface BoardService {
	public int createBoard(BoardVO board);
	public void retrieveBoardList(PagingVO<BoardVO> pagingVO);
	/**
	 * 
	 * @param boNo
	 * @return 존재여부(NotExistBoardException)
	 */
	public BoardVO retrieveBoard(int boNo);
	/**
	 * 게시글 수정
	 * @param board
	 * @return 존재여부(NotExistBoardException), 인증성공여부(AuthenticationException), rowcnt
	 */
	public int modifyBoard(BoardVO board); // 예외 발생으로 오류 알려주기
	/**
	 * @param boNo
	 * @return 존재여부(NotExistBoardException), 인증성공여부(AuthenticationException), rowcnt
	 */
	public int removeBoard(int boNo);
	
	public AttatchVO retrieveForDownload(int attNo);
}
