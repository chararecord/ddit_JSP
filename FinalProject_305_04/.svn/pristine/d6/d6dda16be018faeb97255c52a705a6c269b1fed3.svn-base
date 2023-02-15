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
	public void incrementHit(String notiId);
	
	/**
	 * 게시글 목록 조회
	 * @param pagingVO
	 * @return
	 */
	public List<NoticeVO> selectNoticeList(PagingVO<NoticeVO> pagingVO);
	public NoticeVO selectNotice(String notiId);
	/**
	 * 게시글 등록
	 * @param notice
	 * @return
	 */
	public int insertNotice(NoticeVO notice);
	/**
	 * 게시글 수정
	 * @param notice
	 * @return
	 */
	public int updateNotice(NoticeVO notice);
	/**
	 * 게시글 삭제
	 * @param notiId
	 * @return
	 */
	public int deleteNotice(String notiId);
}
