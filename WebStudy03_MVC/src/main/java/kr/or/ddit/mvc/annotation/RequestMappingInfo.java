package kr.or.ddit.mvc.annotation;

import java.lang.reflect.Method;

import lombok.Getter;
import lombok.ToString;

/**
 * immutable
 * value로 올 객체라 비교 할 필요 X -> equals X
 */
@Getter
@ToString
public class RequestMappingInfo {
	private RequestMappingCondition mappingCodition; // 어떤 요청
	private Object commandHandler; 					 // controller annotation을 가지고 있는 class 객체
	private Method handlerMethod;					 // method 정보

	public RequestMappingInfo(RequestMappingCondition mappingCodition, Object commandHandler, Method handlerMethod) {
		super();
		this.mappingCodition = mappingCodition;
		this.commandHandler = commandHandler;
		this.handlerMethod = handlerMethod;
	}
}
