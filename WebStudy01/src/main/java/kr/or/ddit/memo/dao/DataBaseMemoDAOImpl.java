package kr.or.ddit.memo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import kr.or.ddit.db.ConnectionFactory;
import kr.or.ddit.vo.DataBasePropertyVO;
import kr.or.ddit.vo.MemoVO;
import sun.security.jca.GetInstance.Instance;

public class DataBaseMemoDAOImpl implements MemoDAO {
	
	private DataBaseMemoDAOImpl() {
		super();
	}
	
	// 전역변수가 없을 때 싱글톤O -> 데이터가 어그러지는 상황 방지
	// 메모리 공간을 절약하기 위해 사용
	private static DataBaseMemoDAOImpl Instance;
	public static DataBaseMemoDAOImpl getInstance() {
		if(Instance==null) {
			Instance = new DataBaseMemoDAOImpl();
		}
		return Instance;
	}

	@Override
	public List<MemoVO> selectMemoList() {
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT * FROM TBL_MEMO ");
		try(
			Connection conn = ConnectionFactory.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		){
			ResultSet rs = pstmt.executeQuery();
			List<MemoVO> list = new ArrayList<>();
			while(rs.next()){
				MemoVO vo = new MemoVO();
				vo.setCode(rs.getInt("code"));
				vo.setWriter(rs.getString("writer"));
				vo.setContent(rs.getString("content"));
				vo.setDate(rs.getString("date"));
				list.add(vo);
			}
			return list;
		} catch(SQLException e){
			throw new RuntimeException(e); /* 예외정보 바꿔치기 */
		}
	}

	@Override
	public int insertMemo(MemoVO memo) {
		StringBuffer sql = new StringBuffer();
//		sql.append(" INSERT INTO TBL_MEMO (CODE,WRITER,CONTENT, \"DATE\") VALUES (MEMO_SEQ.NEXTVAL, ?,?,?) ");
		sql.append(" INSERT INTO TBL_MEMO (CODE,WRITER,CONTENT) VALUES (MEMO_SEQ.NEXTVAL, ?,?) ");
		try(
			Connection conn = ConnectionFactory.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		){
			pstmt.setString(1, memo.getWriter());
			pstmt.setString(2, memo.getContent());
//			pstmt.setString(3, memo.getDate());
			return pstmt.executeUpdate();
		} catch(SQLException e){
			throw new RuntimeException(e); /* 예외정보 바꿔치기 */
		}
	}

	@Override
	public int updateMemo(MemoVO memo) {
		StringBuffer sql = new StringBuffer();
		sql.append(" UPDATE TBL_MEMO SET WRITER = ?, CONTENT = ? WHERE CODE = ? ");
		try(
			Connection conn = ConnectionFactory.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		){
			if(StringUtils.isNotBlank(memo.toString())) {
				pstmt.setString(1, memo.getWriter());
				pstmt.setString(2, memo.getContent());
				pstmt.setInt(3, memo.getCode());
			}
			return pstmt.executeUpdate();
		} catch(SQLException e){
			throw new RuntimeException(e); /* 예외정보 바꿔치기 */
		}
	}

	@Override
	public int deleteMemo(int code) {
		StringBuffer sql = new StringBuffer();
		sql.append(" DELETE FROM TBL_MEMO WHERE CODE=? ");
		try(
			Connection conn = ConnectionFactory.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		){
			if(code!=0) {
				pstmt.setInt(1, code);
			}
			return pstmt.executeUpdate();
		} catch(SQLException e){
			throw new RuntimeException(e); /* 예외정보 바꿔치기 */
		}
	}

}
