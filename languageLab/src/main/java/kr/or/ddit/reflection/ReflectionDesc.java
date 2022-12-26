package kr.or.ddit.reflection;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

import kr.or.ddit.reflect.ReflectionTest;
import kr.or.ddit.vo.MemberVO;

/**
 * Reflection (java.lang.reflect)
 *  : 객체의 타입(어떤 클래스로부터 파생되었는지), 객체의 속성(상태, 행동) 들을 역으로 추적하는 작업
 *  : 특정 데이터 타입에 종속되는 형태 X
 */
public class ReflectionDesc {
	public static void main(String[] args) {
		Object dataObj = ReflectionTest.getObject();
		System.out.println(dataObj);
		Class<?> objType = dataObj.getClass(); // 객체의 구체적 타입을 모른다
		System.out.println(objType.getName());
		
		Field[] fields = objType.getDeclaredFields();
//		Arrays.stream(fields)
//				.forEach(System.out::println); // 필드 하나하나에 접근
		Method[] methods = objType.getDeclaredMethods();
//		Arrays.stream(methods)
//				.forEach(System.out::println); // 필드 하나하나에 접근
		
		
		//IllegalAccessException -> 내부적으로 기본생성자 사용중, 생성자의 modifier가 private이라면 접근X이기 때문에
		try {
			Object newObj = objType.newInstance();
			Arrays.stream(fields)
					.forEach(fld->{
//						fld.setAccessible(true); // private -> public 풀어주기 (좋은방식XX)
						String fldName = fld.getName(); // mem_id, getMem_id, setMem_id (필드명 get)
						try {
							PropertyDescriptor pd = new PropertyDescriptor(fldName, objType); // 전역변수 한개의 정보 갖고있음
							Method getter = pd.getReadMethod(); // getter
							Method setter = pd.getWriteMethod(); // setter
							// getter
//							Object fldValue = fld.get(dataObj); // dataObj에서 fld에 해당하는 값을 꺼내겠어
							Object fldValue = getter.invoke(dataObj);
							// setter
//							fld.set(newObj, fldValue); // 복사끝
							setter.invoke(newObj, fldValue);
							
						} catch (IllegalArgumentException | IllegalAccessException e) {
							e.printStackTrace();
						} catch (IntrospectionException e) { // IntrospectionException - reflection 대상이 javaBean 규약에 맞춰 만들어지지 않았을 때
							e.printStackTrace();
						} catch (InvocationTargetException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} 
					});
			System.out.println(newObj);
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}
}
