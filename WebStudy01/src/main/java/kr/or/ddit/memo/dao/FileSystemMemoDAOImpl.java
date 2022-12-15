package kr.or.ddit.memo.dao;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.MemoVO;

public class FileSystemMemoDAOImpl implements MemoDAO {
	// 싱글톤
	private static FileSystemMemoDAOImpl instance;
	public static FileSystemMemoDAOImpl getInstance() {
		if(instance==null) {
			instance = new FileSystemMemoDAOImpl();
		}
		return instance;
	}	
	
	private File dataBase = new File("d:/memos.dat");
	private Map<Integer, MemoVO> memoTable;
	
	// 복원작업 - 역직렬화
	private FileSystemMemoDAOImpl(){
		try(
			FileInputStream fis = new FileInputStream(dataBase);
			BufferedInputStream bis = new BufferedInputStream(fis);
			ObjectInputStream ois = new ObjectInputStream(bis);
		){
			memoTable = (Map<Integer, MemoVO>) ois.readObject();
		} catch (Exception e) {
			System.err.println(e.getMessage());
			this.memoTable = new HashMap<>();
		}
	}

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
			FileOutputStream fos = new FileOutputStream(dataBase);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			ObjectOutputStream oos = new ObjectOutputStream(bos);
		){
			oos.writeObject(memoTable);
		} catch (Exception e) {
			// 상태코드 발생시 500번대 될건데 그걸 runtimeException으로 변경
			throw new RuntimeException(e);
		}
	}
}
