package kr.or.ddit.board.service;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ddit.board.dao.AttatchDAO;
import kr.or.ddit.board.dao.BoardDAO;
import kr.or.ddit.board.exception.AuthenticationException;
import kr.or.ddit.board.exception.NotExistBoardException;
import kr.or.ddit.board.vo.AttatchVO;
import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.vo.PagingVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BoardServiceImpl implements BoardService {
	
	@Inject
	private BoardDAO boardDAO;
	@Inject
	private AttatchDAO attatchDAO;
	@Inject
	private PasswordEncoder encoder;
	
	@Value("#{appInfo.saveFiles}")
	private File saveFiles;
	
	@PostConstruct
	public void init() throws IOException {
		log.info("EL로 주입된 첨부파일 저장 경로 : {}", saveFiles.getCanonicalPath());
	}
	
	private int processAttatchList(BoardVO board) {
		List<AttatchVO> attatchList = board.getAttatchList();
		if(attatchList==null || attatchList.isEmpty()) {return 0;}
		// 1. metadata 저장 - DB (ATTATCH) - rollback 가능 
		int rowcnt = attatchDAO.insertAttatches(board); //★2
		// 2. binary 저장 - Middle Tier : (D:/saveFiles)
		try { //★3
			for(AttatchVO attatch : attatchList) {
//				if(1==1)
//					throw new RuntimeException("강제 발생 예외");
				attatch.saveTo(saveFiles);
			}
			return rowcnt;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
//	@Transactional
	@Override
	public int createBoard(BoardVO board) {
		String plain = board.getBoPass();
		String encoded = encoder.encode(plain);
		board.setBoPass(encoded);
		int rowcnt = boardDAO.insertBoard(board); //★1
		// 첨부파일 등록
		rowcnt += processAttatchList(board);
		return rowcnt;
	}

	@Override
	public void retrieveBoardList(PagingVO<BoardVO> pagingVO) {
		 pagingVO.setTotalRecord(boardDAO.selectTotalRecord(pagingVO));
		 pagingVO.setDataList(boardDAO.selectBoardList(pagingVO));
	}

	@Override
	public BoardVO retrieveBoard(int boNo) {
		BoardVO board = boardDAO.selectBoard(boNo);
		if(board==null) {
			throw new NotExistBoardException(boNo);
		}
		boardDAO.incrementHit(boNo);
		return board;
	}

	@Override
	public int modifyBoard(BoardVO board) {
 		BoardVO savedBoard = boardDAO.selectBoard(board.getBoNo());		// DB Board
 		// 입력받은 board 정보로 DB 조회했는데 null 이거나 blank이면 NotExist
 		if(savedBoard==null)
 			throw new NotExistBoardException(board.getBoNo());
 		boardAuthenticate(board.getBoPass(), savedBoard.getBoPass());
// 		1. board update
 		int rowcnt = boardDAO.updateBoard(board);
// 		2. new attatch insert (metadata, binary)
 		rowcnt += processAttatchList(board);
 		int[] delAttNos = board.getDelAttNos();
 		Arrays.sort(delAttNos);
 		if(delAttNos!=null && delAttNos.length>0) {
// 		3. delete attatch(metadata, binary)
 			rowcnt += attatchDAO.deleteAttatches(board);		// metadata 삭제
 			String[] delAttSavenames = savedBoard.getAttatchList().stream()
 					.filter(attatch->{
 						// 포함되었다면 인덱스, 포함되지 않았다면 음수 리턴
 						return Arrays.binarySearch(delAttNos, attatch.getAttNo()) >= 0;
//						}).map(attatch->attatch.getAttSavename()) // body가 없어서 간단하게 줄일 수 있음
 					}).map(AttatchVO::getAttSavename)
 					.toArray(String[]::new);
 			for(String saveName : delAttSavenames) {
 				FileUtils.deleteQuietly(new File(saveFiles, saveName));
 			}
 		}
 		
		return rowcnt;
	}


	private void boardAuthenticate(String inputPass, String savedPass) {
		if(!encoder.matches(inputPass, savedPass)) {
			throw new AuthenticationException("비밀번호 인증 실패");
		}
	}

	@Override
	public int removeBoard(int boNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public AttatchVO retrieveForDownload(int attNo) {
		// TODO Auto-generated method stub
		return null;
	}

}
