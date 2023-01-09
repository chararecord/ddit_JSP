package kr.or.ddit.di;

import java.util.Properties;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PropertiesContextTestView {
	public static void main(String[] args) {
//		System.getProperties().forEach((k,v)->{
//			System.out.printf("%s : %s\n", k, v);
//		});
//		System.getenv().forEach((k,v)->{
//			System.err.printf("%s : %s\n", k, v);
//		});
		
		ConfigurableApplicationContext context = new GenericXmlApplicationContext("kr/or/ddit/di/conf/Properties-Context.xml");
		context.registerShutdownHook();
		
		Properties dbInfo = context.getBean("dbInfo", Properties.class);
		log.info("dbInfo : {}", dbInfo);
		DBInfoVO vo1 = context.getBean("dbInfo1", DBInfoVO.class);
		log.info("dbInfo1 : {}", vo1);
		DBInfoVO vo2 = context.getBean("dbInfo2", DBInfoVO.class);
		log.info("dbInfo2 : {}", vo2);
	}
}
