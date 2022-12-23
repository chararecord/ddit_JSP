package kr.or.ddit.servlet09.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import kr.or.ddit.db.ConnectionFactory;
import kr.or.ddit.vo.DataBasePropertyVO;

public class DataBasePropertyDAOImpl implements DataBasePropertyDAO {

	@Override
	public List<DataBasePropertyVO> selectPropertyList(String propertyName) {
		// driver class loading : oracle.jdbc.driver.OracleDriver
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT PROPERTY_NAME, PROPERTY_VALUE, DESCRIPTION ");
		sql.append(" FROM DATABASE_PROPERTIES ");
		if(StringUtils.isNotBlank(propertyName)) {
			sql.append(" WHERE PROPERTY_NAME = ? "); // 쿼리파라미터
		}
		
		try(
			Connection conn = ConnectionFactory.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
//			Statement stmt = conn.createStatement();
		){
//			ResultSet rs = stmt.executeQuery(sql.toString());
			if(StringUtils.isNotBlank(propertyName)) {
				pstmt.setString(1, propertyName);
			}
			ResultSet rs = pstmt.executeQuery();
			List<DataBasePropertyVO> list = new ArrayList<>();
			while(rs.next()){
				DataBasePropertyVO vo = new DataBasePropertyVO();
				vo.setPropertyName(rs.getString("property_name"));
				vo.setPropertyValue(rs.getString("property_value"));
				vo.setDescription(rs.getString("description"));
				list.add(vo);
			}
			return list;
		} catch(SQLException e){
			throw new RuntimeException(e); /* 예외정보 바꿔치기 */
		}
	}
}
