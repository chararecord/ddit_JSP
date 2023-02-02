package kr.or.ddit.campus.notice.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.ddit.campus.notice.dao.NoticeDAO;
import kr.or.ddit.vo.NoticeVO;
import kr.or.ddit.vo.PagingVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class NoticeServiceImpl implements NoticeService {

	@Inject
	private NoticeDAO noticeDAO;
	
	@Override
	public int createNotice(NoticeVO notice) {
		// TODO Auto-generated method stub
		return 0;
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
