package kr.or.ddit.board.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ddit.board.dao.AttachDAO;
import kr.or.ddit.board.dao.BoardDAO;
import kr.or.ddit.board.exception.NotExistBoardException;
import kr.or.ddit.board.vo.AttatchVO;
import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.vo.PagingVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BoardServiceImpl implements BoardService {
	
	@Inject
	private BoardDAO dao;
	@Inject
	private AttachDAO attachDAO;
	
	//비밀번호 암호화
	@Inject
	private PasswordEncoder encoder;
	
	
	//첨부파일등록
	@Value("#{appInfo.saveFiles}") //appInfo얘가 가지고있는 saveFiles 값을 가져온다
	private File saveFiles;
	
	@PostConstruct
	public void init() throws IOException {
		log.info("EL로 주입된 첨부파일 저장경로 : {}", saveFiles.getCanonicalPath());
	}
	private int processAttathList(BoardVO board) {
		
		List<AttatchVO> attatchList = board.getAttachList();
		if(attatchList==null || attatchList.isEmpty()) return 0;
		
		//1. metadata 저장 - DB에 저장(attach테이블)
		int rowcnt = attachDAO.insertAttatches(board);
		
		//2. binary 저장 - Middle Tier에 저장 (D:\saveFiles)
		try {
			for (AttatchVO attatch : attatchList) {
//				if(1==1)
//					throw new RuntimeException("강제 발생 예외");
				attatch.saveTo(saveFiles);
			}
			return rowcnt;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		
		
		
	}
	
	
	
	
	
	@Transactional
	@Override
	public int createBoard(BoardVO board) {
		String plain = board.getBoPass();
		String encoded = encoder.encode(plain);
		board.setBoPass(encoded);
		
		int rowcnt = dao.insertBoard(board);
		
		//첨부파일등록
		rowcnt += processAttathList(board);
		
		
		return rowcnt;
	}

	
	//목록 조회
	@Override
	public void retrieveBoardList(PagingVO<BoardVO> pagingVO) {
		//페이징 : current page, total page, data page
		pagingVO.setTotalRecord(dao.selectTotalRecord(pagingVO));
		pagingVO.setDataList(dao.selectBoardList(pagingVO)); //dao에서 바로 vo에 있는 setter 바로 호출
			
	}

	@Override
	public BoardVO retrieveBoard(int boNo) {
		BoardVO board = dao.selectBoard(boNo);
		if(board == null) {
			throw new NotExistBoardException(boNo);
		}
		dao.incrementHit(boNo);
		return board;
	}

	@Override
	public int modifyBoard(BoardVO board) {
		
		return 0;
	}

	@Override
	public int removeBoard(int boNo) {
		
		return 0;
	}

	@Override
	public AttatchVO retrieveForDownload(int attNo) {
		
		return null;
	}

}
