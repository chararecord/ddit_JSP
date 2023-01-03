package kr.or.ddit.prod.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.mybatis.MybatisUtils;
import kr.or.ddit.vo.BuyerVO;
import kr.or.ddit.vo.ProdVO;

public class OthersDAOImpl implements OthersDAO {
	
	private SqlSessionFactory sqlSessionFactory = MybatisUtils.getSqlSessionFactory();

	@Override
	public List<Map<String, Object>> selectLprodList() {
		try(
			SqlSession sqlSession = sqlSessionFactory.openSession();
		){
			OthersDAO mapperProxy = sqlSession.getMapper(OthersDAO.class);
			List<Map<String, Object>> lprodList = mapperProxy.selectLprodList();
			sqlSession.commit();
			return lprodList;
		}
	}

	@Override
	public List<BuyerVO> selectBuyerList(String buyerLgu) {
		try(
			SqlSession sqlSession = sqlSessionFactory.openSession();
		){
			OthersDAO mapperProxy = sqlSession.getMapper(OthersDAO.class);
			List<BuyerVO> buyerList = mapperProxy.selectBuyerList(buyerLgu);
			sqlSession.commit();
			return buyerList;
		}
	}
}
