package kr.or.ddit.exception;

import java.io.IOException;
import java.sql.SQLException;

/**
 * 에러나 예외 (Throwable) : 예상하지 못했던 비정상적인 처리 상황
 *		- Error : 개발자가 직접 처리하지 않는 에러 계열
 *		- Exception	: 개발자가 직접 처리할 수 있는 예외 계열
 *			- checked exception (Exception) : 반드시 처리해야만 하는 예외, 예외가 발생할만한 상황이 있으면 그걸 처리해야 컴파일 에러가 나지 않음
 *				ex) IOException, SQLException
 *			- unchecked exception (RuntimeException) : 예외를 처리하지 않더라도 메소드 호출구조를 통해 JVM에게 제어권이 전달되는 예외 (에러X)
 *				ex) NullPointerException, IndexOutofBoundException
 *
 * 예외 처리 방법 **
 * 직접처리(능동처리) : try(closable object)~catch~finally
 * 위임처리(수동처리) : 메소드의 호출자에게 throws 로 예외 제어권 위임 
 * 
 * 커스텀 예외 사용 방법 **
 * 1. Exception 이나 RuntimeException 의 자식 클래스 정의(예외 클래스)
 * 2. throw 예외 인스턴스 생성
 */
public class ExceptionDesc {
	public static void main(String[] args) { // main의 호출자는 VM
//		try {
//			String data = getSampleData();
//			System.out.println(data);
//		} catch (IOException e) {
////			System.out.println(e.getMessage());
//			e.printStackTrace();
//		}
		
		try {
			System.out.println(getSampleDataWithRE());
		} catch (NullPointerException | UserNotFoundException e) {
			System.out.println(e.getMessage());
			System.out.println("정상처리ㅋ");
		}
//		System.out.println(getSampleChangeException());
	}
	
	private static String getSampleData() throws IOException {
		String data = "SAMPLE";
		if(1==1)
			throw new IOException("강제 발생 예외"); // checked 계열이기 때문에 어떤 형태로든 한번은 처리해야함
		return data;
	}
	
	private static String getSampleDataWithRE() { // 모든 unchecked의 상위
		String data = "SAMPLERE";
		if(1==1)
			throw new UserNotFoundException("강제 발생 예외"); // throws가 없어도 있는 것처럼 동작
		return data;
	}
	
	private static String getSampleChangeException() { // 모든 unchecked의 상위
		String data = "SAMPLEChangeException";
		try {
			if(1==1)
			throw new SQLException("강제 발생 예외");
			return data;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
