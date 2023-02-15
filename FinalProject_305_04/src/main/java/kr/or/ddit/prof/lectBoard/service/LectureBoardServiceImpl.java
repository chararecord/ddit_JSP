package kr.or.ddit.prof.lectBoard.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import kr.or.ddit.commons.dao.AttaFileDAO;
import kr.or.ddit.prof.lectBoard.dao.LectureBoardDAO;
import kr.or.ddit.vo.AttaFileVO;
import kr.or.ddit.vo.LectBoardVO;
import kr.or.ddit.vo.LectureVO;
import kr.or.ddit.vo.PagingVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class LectureBoardServiceImpl implements LectureBoardService {

	@Inject
	private LectureBoardDAO lbDAO;
	@Inject
	private AttaFileDAO attaFileDAO;
	
	@Value("#{appInfo.imageFolder}")
	private File imageFolder;
	
	@Value("#{appInfo.imageFolder}")
	private String imageFolderURL;
	
	@PostConstruct
	public void init() throws IOException {
		log.info("첨부파일 저장 경로 : {}", imageFolder.getCanonicalPath());
	}
	
	@Override
	public LectureVO retrieveLectInfo(String lectId) {
		LectureVO lectInfo = lbDAO.selectLectInfo(lectId);
		if(lectInfo == null) {
			throw new RuntimeException();
		}
		return lectInfo;
	}

	@Override
	public void retrieveLectBoardList(PagingVO<LectBoardVO> pagingVO) {
		pagingVO.setTotalRecord(lbDAO.selectTotalRecord(pagingVO));
		pagingVO.setDataList(lbDAO.selectLectBoardList(pagingVO));
		
	}

	@Override
	public LectBoardVO retreiveLectBoard(String lectBoardId) {
		LectBoardVO lectBoard = lbDAO.selectLectBoard(lectBoardId);
		if(lectBoard==null) {
			throw new RuntimeException();
		}
		lbDAO.incrementHit(lectBoardId);
		return lectBoard;
	}

	@Override
	public int createLectBoard(LectBoardVO lectBoard) {
		int rowcnt = lbDAO.insertLectBoard(lectBoard);
		rowcnt += processAttaFilelist(lectBoard);
		return rowcnt;
	}
	
	private int processAttaFilelist(LectBoardVO lectBoard) {
		log.info("lectBoard**************{}", lectBoard);
		List<AttaFileVO> attaFileList = lectBoard.getAttaFileList();
		if(attaFileList==null || attaFileList.isEmpty()) {return 0;}
		attaFileList.stream().forEach(attaFile -> {
			attaFile.setImageFolder(imageFolderURL);
			attaFile.setAttaId(lectBoard.getLectBoardId());
		});
		log.info("lectBoard=============={}", lectBoard);
		int rowcnt = attaFileDAO.insertLectBoardFiles(lectBoard);
		try {
			for(AttaFileVO attaFile : attaFileList) {
				attaFile.saveTo(imageFolder);
			}
			return rowcnt;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public int modifyLectBoard(LectBoardVO lectBoard) {
		int rowcnt = lbDAO.updateLectBoard(lectBoard);
		rowcnt += processAttaFilelist(lectBoard);
		return rowcnt;
	}

	@Override
	public int removeLectBoard(String lectBoardId) {
		int rowcnt = lbDAO.deleteLectBoard(lectBoardId);
		return rowcnt;
	}

	@Override
	public int deleteAttaFileList(AttaFileVO attaFileVO) {
		return this.attaFileDAO.deleteAttaFileList(attaFileVO);
	}

	@Override
	public Map<String, Object> downloadFile(Map<String, Object> map) {
		return attaFileDAO.selectAttaFile(map);
	}
}
