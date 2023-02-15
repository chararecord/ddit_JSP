package kr.or.ddit.campus.notice.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import kr.or.ddit.campus.notice.dao.NoticeDAO;
import kr.or.ddit.commons.dao.AttaFileDAO;
import kr.or.ddit.vo.AttaFileVO;
import kr.or.ddit.vo.NoticeVO;
import kr.or.ddit.vo.PagingVO;
import lombok.extern.slf4j.Slf4j;
import oracle.security.crypto.fips.RNGTest;

@Slf4j
@Service
public class NoticeServiceImpl implements NoticeService {

	@Inject
	private NoticeDAO noticeDAO;
	@Inject
	private AttaFileDAO attaFileDAO;
	
	@Value("#{appInfo.saveFiles}")
	private File saveFiles;
	
	@PostConstruct
	public void init() throws IOException {
		log.info("첨부파일 저장 경로 : {}", saveFiles.getCanonicalPath());
	}
	
	@Override
	public int createNotice(NoticeVO notice) {
		int rowcnt = noticeDAO.insertNotice(notice);
		rowcnt += processAttaFilelist(notice);
		return rowcnt;
	}

	private int processAttaFilelist(NoticeVO notice) {
		List<AttaFileVO> attaFileList = notice.getAttaFileList();
		if(attaFileList==null || attaFileList.isEmpty()) {return 0;}
		int rowcnt = attaFileDAO.insertAttaFiles(notice);
//		int rowcnt = 0;
		log.info("notiId1111111111 {}", notice.getNotiId());
		try {
			// 일반 포문으로 바꾸고 인덱스 잡아서 집어넣으면 순서도 해결 가
			for(AttaFileVO attaFile : attaFileList) {
//				attaFile.setAttaId(notice.getNotiId());
//				rowcnt = attaFileDAO.insertAttaFile(attaFile);
				attaFile.saveTo(saveFiles);
			}
			return rowcnt;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	@Override
	public void retrieveNoticeList(PagingVO<NoticeVO> pagingVO) {
		pagingVO.setTotalRecord(noticeDAO.selectTotalRecord(pagingVO));
		pagingVO.setDataList(noticeDAO.selectNoticeList(pagingVO));
	}

	@Override
	public NoticeVO retrieveNotice(int notiId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int modifyNotice(NoticeVO notice) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int removeNotice(int notiId) {
		// TODO Auto-generated method stub
		return 0;
	}

}
