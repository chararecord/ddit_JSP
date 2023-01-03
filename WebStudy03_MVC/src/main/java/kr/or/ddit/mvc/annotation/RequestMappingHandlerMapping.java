package kr.or.ddit.mvc.annotation;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.mvc.annotation.stereotype.Controller;
import kr.or.ddit.mvc.annotation.stereotype.RequestMapping;
import kr.or.ddit.mvc.utils.ReflectionUtils;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RequestMappingHandlerMapping implements HandlerMapping {
	// 핸들러 정보 수집 -> map 만듦
	// 수집된 정보를 기반으로 현재 요청을 처리할 수 있는 핸들러 정보 검색
	
	private Map<RequestMappingCondition, RequestMappingInfo> handlerMap; // front 뒤 핸들러 정보 수집
	
	public RequestMappingHandlerMapping (String...basePackages) {
		 handlerMap = new LinkedHashMap<>();
		 scanBasePackages(basePackages);
	}

	private void scanBasePackages(String[] basePackages) {
		ReflectionUtils.getClassesWithAnnotationAtBasePackages(Controller.class, basePackages)
			.forEach((handlerClass, controller)->{
				try {
					Object commandHandler = handlerClass.newInstance();
					ReflectionUtils.getMethodsWithAnnotationAtClass(
							handlerClass, RequestMapping.class, String.class
					).forEach((handlerMethod, requestMapping)->{
						RequestMappingCondition mappingCondition = new RequestMappingCondition(requestMapping.value(), requestMapping.method());
						RequestMappingInfo mappingInfo = new RequestMappingInfo(mappingCondition, commandHandler, handlerMethod);
						handlerMap.put(mappingCondition, mappingInfo);
						log.info("수집된 핸들러 정보 : {}", mappingInfo);
					});
				} catch (Exception e) {
					log.error("핸들러 클래스 스캔 중 문제 발생", e);
				}
			});
	}

	@Override
	public RequestMappingInfo findCommandHandler(HttpServletRequest request) {
		String url = request.getServletPath();
		RequestMethod method = RequestMethod.valueOf(request.getMethod().toUpperCase());
		
		RequestMappingCondition mappingCondition = new RequestMappingCondition(url, method);
		return handlerMap.get(mappingCondition);
	}

}
