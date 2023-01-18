package kr.or.ddit.mybatis;

import static org.junit.Assert.*;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import lombok.extern.slf4j.Slf4j;

@Slf4j
// 가상 컨테이너 만들기
@RunWith(SpringRunner.class) // 1단계
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/datasource-context.xml") // 2단계
@WebAppConfiguration // 3단계
public class DataSourceTest {
	
	@Inject
	private DataSource dataSource;

	@Test
	public void test() {
		log.info("주입된 DataSource : {}", dataSource);
	}
}
