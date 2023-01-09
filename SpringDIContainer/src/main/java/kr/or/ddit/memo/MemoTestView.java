package kr.or.ddit.memo;

import kr.or.ddit.memo.controller.MemoService;

public class MemoTestView {
	public static void main(String[] args) {
		MemoService service = new MemoService();
		service.retrieveMemoList().forEach(System.out::println);
	}
}

//0. fileSystemMemoDAOImpl
//1. new keyword, singleton 다 없애기 -> 컨테이너 객체 생성할 때만 new keyword 사용
//2. Resource API 사용 (new 필요 없음)
//코드를 어떻게 바꿔야 한다 정해진 게 없으니 최대한 수업 내용을 활용하는 방식으로 숙제하기

//초급프로젝트 때 만들었던 프로젝트 있으면 그거 웹 안 쓰고 순수하게 DB만 썼으니까 거기에 Spring container 한번 붙여보셈
//초급프로젝트를 spring 방식으로 바꾸는 거 한번 해보면..^^.. 그렇게 container 최대한 사용할 것

//PDF 파일(ioc) 읽어오세요^^