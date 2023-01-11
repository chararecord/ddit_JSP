package kr.or.ddit.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import kr.or.ddit.mybatis.MybatisUtils;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.PagingVO;

@Repository
public class MemberDAOImpl implements MemberDAO{
	private static final Logger log = LoggerFactory.getLogger(MemberDAOImpl.class);
	private SqlSessionFactory sqlSessionFactory = MybatisUtils.getSqlSessionFactory();

	@Override
	public int insertMember(MemberVO member) {
		try(
			SqlSession sqlSession = sqlSessionFactory.openSession();
		){
			MemberDAO mapperProxy = sqlSession.getMapper(MemberDAO.class);
			int rowcnt = mapperProxy.insertMember(member);
			sqlSession.commit();
			return rowcnt;
		}
	}
	
	/////////////////////////////////////////////////////////////// 페이징처리 한세트
	@Override
	public int selectTotalRecord(PagingVO<MemberVO> pagingVO) {
		try(
			SqlSession sqlSession = sqlSessionFactory.openSession();
		){
			MemberDAO mapperProxy = sqlSession.getMapper(MemberDAO.class);
			return mapperProxy.selectTotalRecord(pagingVO);
		}
	}
	
	@Override
	public List<MemberVO> selectMemberList(PagingVO<MemberVO> pagingVO) {
		try(
			SqlSession sqlSession = sqlSessionFactory.openSession();
		){
			MemberDAO mapperProxy = sqlSession.getMapper(MemberDAO.class);
			return mapperProxy.selectMemberList(pagingVO);
		}
	}
/////////////////////////////////////////////////////////////// 페이징처리 한세트
	
	@Override
	public MemberVO selectMember(String memId) {
		try(
			SqlSession sqlSession = sqlSessionFactory.openSession();
		){
			MemberDAO mapperProxy = sqlSession.getMapper(MemberDAO.class);
			MemberVO member = mapperProxy.selectMember(memId);
			sqlSession.commit();
			return member;
		}
	}

	@Override
	public int updateMember(MemberVO member) {
		try(
			SqlSession sqlSession = sqlSessionFactory.openSession();
		){
			MemberDAO mapperProxy = sqlSession.getMapper(MemberDAO.class);
			int rowcnt = mapperProxy.updateMember(member);
			sqlSession.commit();
			return rowcnt;
		}
	}

	@Override
	public int deleteMember(String memId) {
		try(
			SqlSession sqlSession = sqlSessionFactory.openSession();
		){
			MemberDAO mapperProxy = sqlSession.getMapper(MemberDAO.class);
			int rowcnt = mapperProxy.deleteMember(memId);
			sqlSession.commit();
			return rowcnt;
		}
	}
}
