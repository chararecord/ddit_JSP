package kr.or.ddit.filter;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BlindFilter implements Filter {
	
	private Map<String, String> blindMap;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		log.info("{} 초기화", this.getClass().getName());
		blindMap = new LinkedHashMap<>();
		blindMap.put("127.0.0.1", "나니까 블라인드 하쥐마");
		blindMap.put("0:0:0:0:0:0:0:1", "나니까 블라인드 하쥐마");
		blindMap.put("192.168.35.89", "나니까 블라인드 하쥐마");
		blindMap.put("192.168.35.23", "서빈이니까 블라인드");
		blindMap.put("192.168.35.24", "시윤이니까 블라인드");
		blindMap.put("192.168.35.72", "쌤 쉬는시간 주세요...... 블라인드");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
//		1. 클라이언트의 ipAddr이 필요하다.
//		2. 그 addr을 기준으로 대상여부 판단
//		3. 아니라면 정상적으로 서비스 이용할 수 있게 하고
//		4. 대상자라면 통과시키면 안된다. 블라인드 사유를 알려주면서 당신은 ~~한 이유로 블라인드 처리되었다는 메시지 필요
		log.info("blind filter 동작시작");
		String ipAddr = request.getRemoteAddr();
		if(blindMap.containsKey(ipAddr)) {
			// 블라인드 대상자
			log.info("당신은 딱 걸렸습니다 {} 의 이유로 지나가지 못합니다.", blindMap.get(ipAddr));
			String reason = blindMap.get(ipAddr);
			String message = String.format("당신은 %s 사유로 블라인드 처리", reason);
			request.setAttribute("message", message);
			String viewName = "/WEB-INF/views/commons/messageView.jsp";
			request.getRequestDispatcher(viewName).forward(request, response);
		} else {
			// 통과
			chain.doFilter(request, response); // 다음 필터나 최종 자원으로 제어권 옮김
		}
		log.info("blind filter 동작종료");
	}

	@Override
	public void destroy() {
		log.info("{} 소멸", this.getClass().getName());
	}
}
