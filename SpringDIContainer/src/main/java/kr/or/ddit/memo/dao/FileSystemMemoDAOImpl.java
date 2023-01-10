package kr.or.ddit.memo.dao;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;

import kr.or.ddit.vo.MemoVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class FileSystemMemoDAOImpl implements MemoDAO {
	@Inject
	private ApplicationContext context;
	// 컨테이너 자신의 reference를 넣어줌
	
	// 생성자가 실행되고 모든 injection이 끝나고 실행되는 init
	@PostConstruct // 생성하고 모든 주입이 끝난 후 실행 - lifecycle init() 메소드
	public void init() {
		dataBase = context.getResource("file:d:/memos.dat"); // prefix로 classpath:, file: 사용가능
		log.info("리소스 로딩 : {}", dataBase); // 출력되면 정상적으로 resource 찾고, 메모페이지 로딩된다는 소리
		try(
			InputStream fis = dataBase.getInputStream(); // 1차 스트림 개방할 필요 X
			BufferedInputStream bis = new BufferedInputStream(fis);
			ObjectInputStream ois = new ObjectInputStream(bis);
		){
			memoTable = (Map<Integer, MemoVO>) ois.readObject();
		} catch (Exception e) {
			System.err.println(e.getMessage());
			this.memoTable = new HashMap<>();
		}
	}
	
//	private File dataBase = new File("d:/memos.dat");
	private Resource dataBase;
	private Map<Integer, MemoVO> memoTable;
	
	@Override
	public List<MemoVO> selectMemoList() {
		return new ArrayList<>(memoTable.values());
	}

	@Override
	public int insertMemo(MemoVO memo) {
		
		// 가장 큰 값에다가 +1, 만약에 한 건도 없었다라면 0이란느 숫자를 먼저 만들어서 +1.. 자바 8에서 만들어진 option과 stream이라는 api를 사용해볼거에요
		int maxCode = memoTable.keySet().stream()
										.mapToInt(key->key.intValue())
										.max()		// 있으면 최대값
										.orElse(0);	// 없으면 설정해놓은 0으로 반환
		memo.setCode(maxCode+1);
		memoTable.put(memo.getCode(), memo);
		serializeMemoTable();
		return 1;
	}
	
	private void serializeMemoTable() {
		try(
			FileOutputStream fos = new FileOutputStream(dataBase.getFile());
			ObjectOutputStream oos = new ObjectOutputStream(fos);
		){
			oos.writeObject(memoTable);
		} catch (Exception e) {
			// 상태코드 발생시 500번대 될건데 그걸 runtimeException으로 변경
			throw new RuntimeException(e);
		}
	}
	
	@Override
	public int updateMemo(MemoVO memo) {
		return 0;
	}

	@Override
	public int deleteMemo(int code) {
		return 0;
	}

}
