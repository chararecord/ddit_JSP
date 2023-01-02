package kr.or.ddit.prod.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;

import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.ProdVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ProdDAOImplTest {
	
	private ProdVO prod;
	private ProdDAO dao = new ProdDAOImpl();
	private PagingVO<ProdVO> pagingVO;
	
	@Before
	public void setUp() {
		pagingVO = new PagingVO<>();
		pagingVO.setCurrentPage(1);
	}
	
	@Test
	public void testSelectTotalRecord() {
		int tr = dao.selectTotalRecord(pagingVO);
		assertNotEquals(0, tr); // 성공하면 test 성공
	}
	
	@Test
	public void testSelectProdList() {
		List<ProdVO> prodList = dao.selectProdList(pagingVO);
		assertEquals(10, prodList.size());
		log.info("prodList : {}", prodList);
	}

//	@Test
//	public void test() {
//		ProdVO prod = dao.selectProd("P101000001");
//		assertNotNull(prod);
//		log.info("buyer : {}", prod.getBuyer());
//		prod.getMemberSet().stream()
//				.forEach(user->{
//					log.info("구매자 : {}", user);
//				});
//	}
}
