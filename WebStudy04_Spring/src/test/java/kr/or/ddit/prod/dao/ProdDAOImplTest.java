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
	
	private ProdVO prod = new ProdVO();
	private ProdDAO dao = new ProdDAOImpl();
	private PagingVO<ProdVO> pagingVO;
	
	@Before
	public void setUp() {
		pagingVO = new PagingVO<>();
		pagingVO.setCurrentPage(1);
		prod.setProdId("P101");
		prod.setProdName("야매제품");
		prod.setProdLgu("P101");
		prod.setProdBuyer("P10101");
		prod.setProdCost(3000);
		prod.setProdPrice(3000);
		prod.setProdSale(3000);
		prod.setProdOutline("테스트로 만든 제품");
		prod.setProdImg("이미지경로");
		prod.setProdTotalstock(1);
		prod.setProdProperstock(1);
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
	
	@Test
	public void testInsertProd() {
		int insertProd = dao.insertProd(prod);
		log.info("insertProd : {}", insertProd);
		log.info("prod : {}", prod);
		System.out.println(prod.getProdId());
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
