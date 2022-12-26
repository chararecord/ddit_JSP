package kr.or.ddit.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import kr.or.ddit.db.ConnectionFactory;
import kr.or.ddit.vo.MemberVO;

public class MemberDAOImpl extends AbstractJDBCDAO implements MemberDAO{
	
	private Map<String, Statement> statementMap; // Statement 쿼리 객체를 만들어서 넣고, key로 접근해 쿼리 사용할 수도 있음

	@Override
	public int insertMember(MemberVO member) {
		// TODO Auto-generated method stub
		return 0;
	}
//	
//	@Override
//	public <T> T resultBindingForOneRecord(ResultSet rs, Class<T> resultType) {
//		try {
//			// reflection은 불확실성을 기반으로 한다. 언제든지 예외가 발생할 수 있는 잠재성 있는 코드
//			T resultObject = resultType.newInstance();
//			
//			MemberVO member = (MemberVO) resultObject;
//			member.setMemId(rs.getString("mem_id"));
//			member.setMemName(rs.getString("mem_name"));
//			member.setMemBir(rs.getString("mem_bir"));
//			member.setMemZip(rs.getString("mem_zip"));
//			member.setMemAdd1(rs.getString("mem_add1"));
//			member.setMemAdd2(rs.getString("mem_add2"));
//			member.setMemHometel(rs.getString("mem_hometel"));
//			member.setMemComtel(rs.getString("mem_comtel"));
//			member.setMemHp(rs.getString("mem_hp"));
//			member.setMemMail(rs.getString("mem_mail"));
//			member.setMemJob(rs.getString("mem_job"));
//			member.setMemLike(rs.getString("mem_like"));
//			member.setMemMemorial(rs.getString("mem_memorial"));
//			member.setMemMemorialday(rs.getString("mem_memorialday"));
//			member.setMemMileage(rs.getInt("mem_mileage"));
//			member.setMemDelete(rs.getString("mem_delete"));
//			
//			return resultObject;
//		} catch (Exception e) {
//			throw new RuntimeException(e);
//		}
//	}
	
	@Override
	public List<MemberVO> selectMemberList() {
//		1. 
		StringBuffer sql = new StringBuffer();
//		sql.append(" SELECT * ");
		sql.append(" SELECT MEM_ID, MEM_PASS, MEM_NAME, MEM_REGNO1, MEM_REGNO2, MEM_BIR, MEM_ZIP, MEM_ADD1, MEM_ADD2, MEM_HOMETEL, ");
		sql.append(" MEM_COMTEL, MEM_HP, MEM_MAIL, MEM_JOB, MEM_LIKE, MEM_MEMORIAL, MEM_MEMORIALDAY, MEM_MILEAGE, MEM_DELETE ");
		sql.append(" FROM MEMBER "); 
		
		return selectList(sql.toString(), MemberVO.class);
	}
	
	@Override
	public MemberVO selectMember(String memId) {
//		1. 
		StringBuffer sql = new StringBuffer();
		
		sql.append(" SELECT                                                                                                   ");
	    sql.append(" MEM_ID, MEM_PASS, MEM_NAME, MEM_REGNO1, MEM_REGNO2,                                                      ");
	    sql.append(" TO_CHAR(MEM_BIR, 'YYYY-MM-DD') MEM_BIR,                                                                  ");
	    sql.append(" MEM_ZIP, MEM_ADD1, MEM_ADD2, MEM_HOMETEL, MEM_COMTEL, MEM_HP, MEM_MAIL, MEM_JOB, MEM_LIKE, MEM_MEMORIAL, ");
	    sql.append(" TO_CHAR(MEM_MEMORIALDAY, 'YYYY-MM-DD') MEM_MEMORIALDAY,                                                  ");
	    sql.append(" MEM_MILEAGE, MEM_DELETE                                                                                  ");
		sql.append(" FROM MEMBER                                                                                              ");
		sql.append(" WHERE MEM_ID = ?                                                                                    ");
		
		return selectOne(sql.toString(), MemberVO.class, memId);
	}

	@Override
	public int updateMember(MemberVO member) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteMember(String memId) {
		// TODO Auto-generated method stub
		return 0;
	}
}
