package kr.or.ddit.marshalling;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MarshallingTest {
	
	Object target;
	// ObjectMapper 하나로 가능
	ObjectMapper mapper;

	// 이전 이후의 기준은 test case (method)
	// 재료를 미리 준비해주는 before
	@Before
	public void setUp() throws Exception {
		System.out.println("before");
		// map이 key/value 쌍의 형태를 갖고 있기 때문에 marshalling 가능 (properties도)
		// 배열, 객체의 형태를 띄고 있으면 marshalling의 대상이 될 수 있음
		target = new LinkedHashMap<>();
		((Map)target).put("key1", "SAMPLE");
		((Map)target).put("key2", new Boolean(true));
		((Map)target).put("key3", new Double(2.3d));
		mapper = new ObjectMapper();
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("after");
	}

	@Test /*(expected) 에러 테스트 시*/
	public void test1() throws JsonProcessingException {
//		1. native -> json : marshalling - writeXXX
		String json = mapper.writeValueAsString(target);
		System.out.println(json);
		
//		2. json -> native : unmarshalling - readXXX
		// 
		Map<String, Object> map = mapper.readValue(json, Map.class);
		System.out.println(map);
	}
	
	@Test
	public void test2() throws IOException {
//		1. native -> json : marshalling - writeXXX
//		String json = mapper.writeValueAsString(target);
//		1-1. serialization : 객체의 상태를 전송이나 저장이 가능한 형태로 스트링화(byte배열로 변환)
		
		// 직렬화 작업
		File file = new File("d:/test.json");
		try(
			FileWriter writer = new FileWriter(file);
			// BufferedWriter - 2차 스트림 (1차 스트림과 연결해서 사용)
			BufferedWriter bw = new BufferedWriter(writer);
		){
//			bw.write(json); // 직렬화 작업
			mapper.writeValue(bw, target); // marshalling과 직렬화를 한꺼번에 해주는 메소드
		}
		
//		2-2. deserialization : 전송이나 저장된 매체로부터 객체의 상태를 복원하는 과정 
		try(
			// Closable 객체(resource형태) 선언문
			FileReader reader = new FileReader(file);
			BufferedReader br = new BufferedReader(reader);
		){
//			String temp = null;
//			StringBuffer readedJson = new StringBuffer();
//			while((temp = br.readLine())!=null) {
//				readedJson.append(temp);
//			}
//		2. json -> native : unmarshalling - readXXX
//			Map<String, Object> map = mapper.readValue(readedJson.toString(), Map.class);
			Map<String, Object> map = mapper.readValue(br, Map.class);
			System.out.println(map);
		}
	}
}
