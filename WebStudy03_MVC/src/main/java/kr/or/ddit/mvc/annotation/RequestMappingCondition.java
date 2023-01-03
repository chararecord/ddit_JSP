package kr.or.ddit.mvc.annotation;

import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * immutable 객체 형태로 값을 변경하지 않음
 */
@Getter // 한번 객체를 생성한 이후에 이 값들을 절대 바꾸지 않겠다
@EqualsAndHashCode // 키로 사용할 객체는 반드시 equals가 있어야 함
public class RequestMappingCondition {
	private String url;
	private RequestMethod method;
	public RequestMappingCondition(String url, RequestMethod method) {
		super();
		this.url = url;
		this.method = method;
	}
	@Override
	public String toString() {
		return String.format("%s[%s]", url, method);
	}
}
