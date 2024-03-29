package kr.or.ddit.board.dao;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.vo.PagingVO;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@RunWith(SpringRunner.class) //junit 컨텍스트 형성
@ContextConfiguration("file:webapp/WEB-INF/spring/*-context.xml") //가상 컨테이너 만들기 
@WebAppConfiguration
public class BoardDAOTest  {
	

	@Inject
	private BoardDAO boardDAO;

	private PagingVO<BoardVO> pagingVO;

	@Before
	public void setUp() {
		pagingVO = new PagingVO<>();
		pagingVO.setCurrentPage(1);
	}
	

	//@Test
	public void testInsertBoard() {
		fail("Not yet implemented");
	}

	//@Test
	public void testSelectBoardList() {

		List<BoardVO> dataList =   boardDAO.selectBoardList(pagingVO);
		assertNotEquals(0, dataList.size()); //절대 0이어서는 안되고 list의 사이즈 보냄 

	
	}

	//@Test
	public void testSelectTotalRecord() {
		fail("Not yet implemented");
	}

	@Test
	public void testSelectBoard() {
		
		BoardVO board= boardDAO.selectBoard(125);
		assertNotNull(board);
		board.getAttachList()
		     .stream().forEach(System.out::println);
		
		
		
		
	}

	//@Test
	public void testUpdateBoard() {
		fail("Not yet implemented");
	}

	//@Test
	public void testDeleteBoard() {
		fail("Not yet implemented");
	}

}
