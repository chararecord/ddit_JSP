package kr.or.ddit.di;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class VariousDITestView{
	
	public static void main(String[] args) {
//		1. 컨테이너 객체 생성
		ConfigurableApplicationContext context = new GenericXmlApplicationContext("kr/or/ddit/di/conf/VariousDI-Context.xml");
		
//		2. 필요없으면 자동으로 소멸되는 구조
		context.registerShutdownHook();
		
//		3. 등록되어 있는 모든 bean들은 라이프사이클 콜백을 가져야 함 ( 객체 초기화, 소멸 log 확인 가능해야함)
//		4. 등록해놨던 유일한 bean을 현재 메인 메소드 안에서 주입을 받아.. 그리고 그 빈이 가지고 있는 property 상태를 확인하도록 로그 출력
		VariousDIVO vo1 = context.getBean("vo1", VariousDIVO.class);
		VariousDIVO vo2 = context.getBean("vo2", VariousDIVO.class);
		log.info("주입된 객체 : {}", vo1);
		log.info("주입된 객체 : {}", vo2);
	}
}
