package kr.or.ddit.prof.lectBoard.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.vo.LectBoardVO;
import kr.or.ddit.vo.LectureVO;
import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.ProfessorVO;

@Mapper
public interface LectureBoardDAO {

	/**
	 * 교수+강의정보 조회
	 * @param profId
	 * @return {@link ProfessorVO}
	 */
	public LectureVO selectLectInfo(String lectId);
	/**
	 * 게시글 개수 조회
	 * @param pagingVO
	 * @return
	 */
	public int selectTotalRecord(PagingVO<LectBoardVO> pagingVO);
	/**
	 * 게시글 목록 조회
	 * @param pagingVO
	 * @return
	 */
	public List<LectBoardVO> selectLectBoardList(PagingVO<LectBoardVO> pagingVO);
	/**
	 * 게시글 상세 조회
	 * @param lectBoardId
	 * @return
	 */
	public LectBoardVO selectLectBoard(String lectBoardId);
	/**
	 * 조회수 증가
	 * @param lectNotiId
	 */
	public void incrementHit(String lectBoardId);
	/**
	 * 게시글 등록
	 * @param lectNotice
	 * @return
	 */
	public int insertLectBoard(LectBoardVO lectBoard);
	/**
	 * 게시글 수정
	 * @param lectNotice
	 * @return
	 */
	public int updateLectBoard(LectBoardVO lectBoard);
	/**
	 * 게시글 삭제
	 * @param lectNotiId
	 * @return
	 */
	public int deleteLectBoard(String lectBoardId);	
}
