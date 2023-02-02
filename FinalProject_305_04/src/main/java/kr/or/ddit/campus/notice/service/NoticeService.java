package kr.or.ddit.campus.notice.service;

import kr.or.ddit.vo.NoticeVO;
import kr.or.ddit.vo.PagingVO;

public interface NoticeService {
	
	/**
	 * 게시글 등록
	 * @param notice
	 * @return
	 */
	public int createNotice(NoticeVO notice);
	/**
	 * 게시글 목록 조회
	 * @param pagingVO
	 */
	public void retrieveNoticeList(PagingVO<NoticeVO> pagingVO);
	/**
	 * 게시글 단건 조회
	 * @param notiId
	 * @return
	 */
	public NoticeVO retrieveNotice(int notiId);
	/**
	 * 게시글 수정
	 * @param notice
	 * @return
	 */
	public int modifyNotice(NoticeVO notice);
	/**
	 * 게시글 삭제
	 * @param notiId
	 * @return
	 */
	public int removeNotice(int notiId);
}
