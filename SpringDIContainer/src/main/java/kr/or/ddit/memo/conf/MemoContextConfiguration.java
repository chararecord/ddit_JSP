package kr.or.ddit.memo.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import kr.or.ddit.memo.MemoTestView;
import kr.or.ddit.memo.dao.FileSystemMemoDAOImpl;
import kr.or.ddit.memo.dao.MemoDAO;
import kr.or.ddit.memo.service.MemoService;

@Lazy // - 모든 bean을 lazy한 상태로 만들기
@ComponentScan("kr.or.ddit.memo")
// java config 방식은 기본적으로 annotation을 사용한다고 깔고 감-> 그래서 annotation-config 필요 X
public class MemoContextConfiguration {
	// 기본적으로 모든 Bean은 singleton 으로 사용
//	
//	@Bean // dao bean 등록
//	@Scope("prototype") // value=scopeName, scope를 prototype을 주면 prototype(지연까지)으로 사용됨
//	public MemoDAO memoDAO() {
//		return new FileSystemMemoDAOImpl(); // dao return
//	}
//	
//	// bean을 등록할 때 해당 bean의 시그니처를 자유롭게 사용할 수 있음
//	@Bean
////	@Lazy - lazy init
//	public MemoService generateService(MemoDAO dao) {
////		return new MemoService(memoDAO()); // service가 parameter로 dao 원하니까 넣어줌
//		return new MemoService(dao);
//	}
//	
//	@Bean("testView") // id 설정
//	public MemoTestView testView(MemoService service) {
//		MemoTestView view = new MemoTestView();
//		view.setService(service);
//		return view;
//	}
}
