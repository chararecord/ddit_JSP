package kr.or.ddit.designpattern.templatemethodpattern;

public abstract class TemplateClass {
	// template method
	public final void template() {
		// final - 오버라이딩 불가, 순서 변경 X
		// 순서가 정의되어 있는 템플릿 메소드
		stepOne();
		stepTwo();
		stepThree();
	}
	
	// hook method
	private void stepOne() {
		System.out.println("1단계");
	}
	protected abstract void stepTwo();
	
	private void stepThree() {
		System.out.println("3단계");
	}
}
