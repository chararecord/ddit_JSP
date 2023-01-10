package kr.or.ddit.memo;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import kr.or.ddit.memo.conf.MemoContextConfiguration;
import kr.or.ddit.memo.service.MemoService;

@Controller
public class MemoTestView {
	private MemoService service;
	
	@Required // 주입할 수는 없지만 어떤 부분이 잘못되었는지 exception 자세히 보여줌
	@Inject
	public void setService(MemoService service) {
		this.service = service;
	}
	public void printMemoList() {
		service.retrieveMemoList().forEach(System.out::println);
	}
	
	public static void main(String[] args) {
//		ConfigurableApplicationContext context =
//				new GenericXmlApplicationContext("classpath:kr/or/ddit/memo/conf/auto/root-context.xml");
//		// context를 상속받았기 때문에 그 안에 있는 dao, service 사용 가능
//		ConfigurableApplicationContext childContext =
//				new ClassPathXmlApplicationContext(
//							new String[] {"kr/or/ddit/memo/conf/auto/servlet-context.xml"}
//							, context
//						);
//		context.registerShutdownHook();
//		childContext.registerShutdownHook();
		
		ConfigurableApplicationContext context =
			new AnnotationConfigApplicationContext(MemoContextConfiguration.class);
		context.registerShutdownHook();
		
//		MemoTestView view = childContext.getBean(MemoTestView.class);
		MemoTestView view = context.getBean(MemoTestView.class);
		view.printMemoList();
	}
}

//0. fileSystemMemoDAOImpl
//1. new keyword, singleton 다 없애기 -> 컨테이너 객체 생성할 때만 new keyword 사용
//2. Resource API 사용 (new 필요 없음)
//코드를 어떻게 바꿔야 한다 정해진 게 없으니 최대한 수업 내용을 활용하는 방식으로 숙제하기

//초급프로젝트 때 만들었던 프로젝트 있으면 그거 웹 안 쓰고 순수하게 DB만 썼으니까 거기에 Spring container 한번 붙여보셈
//초급프로젝트를 spring 방식으로 바꾸는 거 한번 해보면..^^.. 그렇게 container 최대한 사용할 것

//PDF 파일(ioc) 읽어오세요^^