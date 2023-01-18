package kr.or.ddit;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

// 어노테이션이 또 다른 어노테이션을 받고 있는 상황 (메타어노테이션)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/*-context.xml") // 2. 테스트용 가상 컨테이너 생성
@WebAppConfiguration // 3. optional, WebApplicationContext로 가상 컨테이너 생성
public @interface RootContextConfiguration {

}
