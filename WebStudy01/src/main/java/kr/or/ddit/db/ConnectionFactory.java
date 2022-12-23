package kr.or.ddit.db;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

/**
 * Factory Object[Method] Pattern
 *	: 필요 객체의 생성을 전담하는 객체를 별도 운영하는 구조
 */
public class ConnectionFactory {
	private static String url;
	private static String user;
	private static String password;
	
	private static DataSource ds;

	
	// class가 메모리에 로딩될 때(딱 한번) 실행
	static {
		String path = "/kr/or/ddit/db/dbInfo.properties";
		
		try(
			InputStream is = ConnectionFactory.class.getResourceAsStream(path);
		){
			Properties dbInfo = new Properties();
			dbInfo.load(is);
			
			url = dbInfo.getProperty("url");
			user = dbInfo.getProperty("user");
			password = dbInfo.getProperty("password");
			
//			Class.forName(dbInfo.getProperty("driverClassName"));
			
			BasicDataSource bds = new BasicDataSource();
			bds.setDriverClassName(dbInfo.getProperty("driverClassName"));
			bds.setUrl(url);
			bds.setUsername(user);
			bds.setPassword(password);
			
			bds.setInitialSize(Integer.parseInt(dbInfo.getProperty("initialSize"))); // 맨처음 커넥션을 5개 만들어놓겠다
			bds.setMaxIdle(Integer.parseInt(dbInfo.getProperty("maxIdle"))); // 최대 놀릴 수 있는 커넥션은 5개(10개를 만들었는데 다 반납된다? 그러면 5개 빼고 5개 죽임 / initialSize = maxIdle 같아야함)
			bds.setMaxTotal(Integer.parseInt(dbInfo.getProperty("maxTotal"))); // 여섯번째 요구자가 들어오면 하나를 더 만든다. 반납된 게 있으면 그 다음 요구자에게 반납된 걸 제공 (객체 재활용)
			bds.setMaxWaitMillis(Integer.parseInt(dbInfo.getProperty("maxWait"))); // 반납된 게 없으면 2초 기다려, 2초가 지나도 반납된 게 없으면 SQLException 발생
			
			ds = bds;
			
		} catch (Exception e1) {
			throw new RuntimeException(e1);
		} /* 클래스 로더에게 이런 조건에 맞는 class를 찾은 다음 로더에 올려~ (명령) */
	}
	
	public static Connection getConnection() throws SQLException {
		
//		Connection conn = DriverManager.getConnection(url, user, password);
		return ds.getConnection(); // 커넥션 풀링 적용 완
	}
}
