package kr.or.ddit.sample.controller;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import kr.or.ddit.sample.service.SampleService;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class SampleController {
	
	// 유일성을 이미 확보하고 있는 경우라면 Autowired 를 사용할 수 있지만 대신 inject 사용하자
//	@Autowired
//	@Inject - 아래 setService를 호출하지 않은 상태에서 private을 public으로 바꿔버리고 강제로 service 넣어버림
	private SampleService service;
	
	@Inject // 정확하게 setter를 통해서 주입해야 한다고 하면 이렇게 사용해야 안전
	public void setService(SampleService service) {
		this.service = service;
		log.info("주입된 service : {}", service);
	}
}
