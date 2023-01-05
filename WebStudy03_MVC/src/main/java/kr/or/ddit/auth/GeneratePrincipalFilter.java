package kr.or.ddit.auth;

import java.io.IOException;
import java.security.Principal;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpSession;

import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.MemberVOWrapper;

public class GeneratePrincipalFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		MemberVO authMember = (MemberVO) session.getAttribute("authMember");
		if(authMember!=null) {
			HttpServletRequest modifiedReq = new HttpServletRequestWrapper(req) {
				@Override
				public Principal getUserPrincipal() {
					HttpServletRequest adaptee = (HttpServletRequest) getRequest(); // adaptee 꺼냄
					MemberVO realMember = (MemberVO) adaptee.getSession().getAttribute("authMember");
					// 우리가 만든 객체의 적요범위가 어디까지인지 모르기 때문에 지역변수보다는 객체를 생성해줌
					return new MemberVOWrapper(realMember); // null이 아니라 우리가 만든 principal이 반환됨
				}
			}; // 익명객체 정의
			chain.doFilter(modifiedReq, response); // 중간에 필터링된 것(수정된 req를 넘기니까)
		} else {
			chain.doFilter(request, response); // 원본 요청과 응답을 그대로 넘김 - 필터링을 안 한 것
		}
	}

	@Override
	public void destroy() {
	}
}
