package kr.or.ddit.board.service;


import org.springframework.stereotype.Service;

import kr.or.ddit.board.vo.AttatchVO;
import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.vo.PagingVO;



public interface BoardService {
	
	
	public int createBoard(BoardVO board);
	public void  retrieveBoardList(PagingVO<BoardVO> board);


	/**
	 * 
	 * @param boNo
	 * @return 존재여부(NotExistBoardException)
	 */
	public BoardVO retrieveBoard(int boNo);
	
	
	/**
	 * 게시글 수정 - 게시글의 존재여부  + 게시글 작성자 검증 
	 * @param board
	 * @return 존재여부(NotExistBoardException), 인증성공여부(AuthenticationException)
	 */
	public int modifyBoard(BoardVO board);
	public int removeBoard(int boNo);
	
	
	public AttatchVO  retrieveForDownload(int attNo);
	
	
	
	
	
	
}
