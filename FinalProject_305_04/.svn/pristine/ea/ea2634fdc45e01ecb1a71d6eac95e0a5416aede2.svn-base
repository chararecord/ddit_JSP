package kr.or.ddit.campus.notice.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.vo.NoticeVO;
import kr.or.ddit.vo.PagingVO;

@Mapper
public interface NoticeDAO {
	
	/**
	 * 게시글 개수 조회
	 * @param pagingVO
	 * @return
	 */
	public int selectTotalRecord(PagingVO<NoticeVO> pagingVO);
	/**
	 * 조회수 증가
	 * @param notiId
	 */
	public void incrementHit(int notiId);
	
	public List<NoticeVO> selectNoticeList(PagingVO<NoticeVO> pagingVO);
	public NoticeVO selectNotice(int notiId);
	public int updateNotice(NoticeVO notice);
	public int deleteNotice(int notiId);
}
