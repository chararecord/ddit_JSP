package kr.or.ddit.common.pdf.view;

import java.awt.Checkbox;

/**
 * 주석 예시를 위한 클래스
 * @author 민경진
 *
 */
public class Test {

	
	/**
	 * 테스트 성공여부를 판단하는 메소드
	 * @param name
	 * @return 
	 */
	public String check(String name) {
		//TODO 바보
		
		if(name.equals("테스트")) {
			return "테스트성공";
		}
		return "테스트실패";
	}
}
