package kr.or.ddit.servlet04.service;

public class CalculateServiceImpl implements CalculateService {

	// 덧셈
	@Override
	public int plus(int x, int y) {
		int rst = x + y;
		return rst;
	}
	
	// 뺄셈
	@Override
	public int minus(int x, int y) {
		int rst = x - y;
		return rst;
	}
	
	// 곱셈
	@Override
	public int multiply(int x, int y) {
		int rst = x * y;
		return rst;
	}

	// 나눗셈
	@Override
	public int divide(int x, int y) {
		int rst = x / y;
		return rst;
	}

}
