package kr.or.ddit.memo.dao;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import kr.or.ddit.vo.MemoVO;

public class MemoDAOImplTest {
	
	private MemoDAO dao = new MemoDAOImpl();
	private MemoVO memo;
	
	@Before
	public void setUp() throws Exception {
		memo = new MemoVO();
		memo.setCode(1);
		memo.setWriter("작성자33");
		memo.setContent("내용33");
//		String date = String.format("%1$ty-%1$tm-%1$td %1$tH:%1$tM:%1$tS", LocalDateTime.now());
//		memo.setDate(date);
		
	}

	@Test
	public void testSelectMemoList() {
		List<MemoVO> memoList = dao.selectMemoList();
		memoList.stream()
				.forEach(System.out::println);
//				.forEach(singleMemo->{
//					System.out.println(singleMemo);
//				});
	}

	@Test
	public void testInsertMemo() {
		int cnt = dao.insertMemo(memo);
		System.out.println(cnt);
	}
	
	@Test
	public void testUpdateMemo() {
		int cnt = dao.updateMemo(memo);
	}
	
	@Test
	public void testDeleteMemo() {
		int cnt = dao.deleteMemo(0);
	}

}
