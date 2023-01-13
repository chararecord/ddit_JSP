package kr.or.ddit.board.service;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;

import kr.or.ddit.board.dao.BoardDAO;
import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.vo.PagingVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BoardServiceImplTest extends Ab {

	@Inject
	private BoardService service;
	@Inject
	private BoardDAO dao;
	@Inject
	private BoardVO vo;
	@Inject
	private PagingVO<BoardVO> pagingVO;
	
	@Before
	public void setUp() throws Exception {
		vo = new BoardVO();
		vo.setBoNo(1);
		vo.setBoTitle("테스트");
		vo.setBoWriter("테스트");
		vo.setBoIp("111.111.111.111");
		vo.setBoPass("1111");
	}

	@Test
	public void testCreateBoard() {
		fail("Not yet implemented");
	}

	@Test
	public void testRetrieveBoardList() {
		pagingVO.setCurrentPage(1);
		pagingVO.setTotalRecord(dao.selectTotalRecord(pagingVO));
		List<BoardVO> boardList = dao.selectBoardList(pagingVO);
		log.info("boardList : {}", boardList);
	}

	@Test
	public void testRetrieveBoard() {
		fail("Not yet implemented");
	}

	@Test
	public void testModifyBoard() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveBoard() {
		fail("Not yet implemented");
	}

	@Test
	public void testRetrieveForDownload() {
		fail("Not yet implemented");
	}

	@Test
	public void testBoardServiceImpl() {
		fail("Not yet implemented");
	}

}
