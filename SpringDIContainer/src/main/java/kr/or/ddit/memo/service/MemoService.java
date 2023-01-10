package kr.or.ddit.memo.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.ddit.memo.dao.FileSystemMemoDAOImpl;
import kr.or.ddit.memo.dao.MemoDAO;
import kr.or.ddit.vo.MemoVO;

@Service
public class MemoService {
	
	// 생성자 - 주입 받아야 되는 대상이 반드시 잇어야 할 경우
	// setter - 주입 받아야 되는 대상의 필요 여부가 option일 경우
	private MemoDAO dao;
	
	@Inject // 이 생성자를 반드시 호출해야할 때 이 위에 바로 사용 private에 쓰면 public으로 풀어버림
	public MemoService(MemoDAO dao) {
		super();
		this.dao = dao;
	}

	public List<MemoVO> retrieveMemoList(){
		return dao.selectMemoList();
	}
}
