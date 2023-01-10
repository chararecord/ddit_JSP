package kr.or.ddit.sample.dao;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository("daoOracle")
public class SampleDAOImpl_Oracle implements SampleDAO {
	
	public void init() {
		log.info("{} 객체 초기화", getClass().getSimpleName());
	}
	public void destroy() {
		log.info("{} 객체 소멸", getClass().getSimpleName());
	}
	
	private Map<String, String> dummyDB;
	
	// setter 단점 - 한번도 호출되지 않으면 injection 안될 수도 있음
	@Required // 이 setter를 통한 주입 구조는 반드시 필요하다는 의미 (꼭 필요한 주입이다~)
	@Resource(name="oracleDB")
	public void setDummyDB(Map<String, String> dummyDB) {
		this.dummyDB = dummyDB;
		log.info("{} 객체 생성, seetter 주입으로 dummyDB 객체 주입", getClass().getSimpleName());
	}

	@Override
	public String selectRawData(String primaryKey) {
		return dummyDB.get(primaryKey);
	}
}
