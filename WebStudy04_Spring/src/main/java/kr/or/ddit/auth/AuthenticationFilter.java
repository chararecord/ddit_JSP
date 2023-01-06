package kr.or.ddit.auth;

import java.io.IOException;
import java.io.InputStream;
import java.security.Principal;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;
import java.util.Properties;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;

/**
 * 보호 자원에 대한 요청인 경우, 신원 확인(session authMember)을 한 사용자인지 판단
 * 아직 롤에 대한.. 그거는.. X
 */
@Slf4j
public class AuthenticationFilter implements Filter{
	
	private Map<String, String[]> securedResources;
	public static final String SECUREDNAME = "securedResources";

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		securedResources = new LinkedHashMap<>();
		filterConfig.getServletContext().setAttribute(SECUREDNAME, securedResources);
		String filePath = filterConfig.getInitParameter("filePath");
		try(
			InputStream is = this.getClass().getResourceAsStream(filePath);
		){
			Properties props = new Properties();
			props.load(is);
			props.keySet().stream()
						.map(Object::toString) // map-stream 하나하나에 있는 객체를 변환할 때? 사용, 메소드 레퍼런스 구조
//						.collect(Collectors.toList())
						.forEach(key->{
							String value = props.getProperty(key);
							securedResources.put(key, value.split(","));
							log.info("보호 자원 [{} : {}]", key, securedResources.get(key));
						});
		} catch (Exception e) {
			throw new ServletException(e); // wrapper...
		}
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
//		request에서.. 이 사람이 authmember를 가지고 있능지 확인한다...
//		없다... 그러면 ㅇ얘는 신원확인이 안된다.... 로그인폼으로 보낸다....
//		가지고 있다... 이 사람은 로그인한 사람이다.. 그런데 보호자원에 간다고 한다.. 못가게 막는다...
//		로그인한 사람이다.. 자기 마이페이지 간단다.. 마이페이지는 괜찮다.. 봐준다...
		
		HttpServletRequest req = (HttpServletRequest) request;
		String uri = req.getServletPath();
		
		boolean pass = true;
		
		if(securedResources.containsKey(uri)) {
			Principal principal = req.getUserPrincipal();
			if(principal==null) {
				// 통과 X
				pass = false;
			}
		}
		
		if(pass) {
			// 통과 O
			chain.doFilter(request, response);
		} else {
			// 통과 X - 보호자원 요청, 신원확인 X -> loginForm 이동, redirect (인증 시스템에서는 무조건 redirect)
			String viewName = req.getContextPath() +"/login/loginForm.jsp";
			HttpServletResponse resp = (HttpServletResponse) response;
			resp.sendRedirect(viewName);
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}
}
