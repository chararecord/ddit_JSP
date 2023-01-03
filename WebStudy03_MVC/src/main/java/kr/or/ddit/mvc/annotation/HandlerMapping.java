package kr.or.ddit.mvc.annotation;

import javax.servlet.http.HttpServletRequest;

public interface HandlerMapping {
	/**
	 * 현재 요청의 조건(RequestMappingCondition)에 맞는 -식별자-
	 * 핸들러 정보(핸들러 객체 + 핸들러 메소드 : RequestMappingInfo)를 검색 -값-
	 * @param request
	 * @return
	 */
	public RequestMappingInfo findCommandHandler(HttpServletRequest request);
}
