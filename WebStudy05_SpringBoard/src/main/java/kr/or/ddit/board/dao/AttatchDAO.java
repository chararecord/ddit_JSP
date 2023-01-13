package kr.or.ddit.board.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.board.vo.AttatchVO;
import kr.or.ddit.board.vo.BoardVO;

@Mapper
public interface AttatchDAO {
	public int insertAttatches(BoardVO board);
	// BoardVO, AttatchVO - 이미 has many 관계로 엮었으니 BoardVO
	public List<AttatchVO> selectAttatchList(int boNo);
	public AttatchVO selectAttatch(int attNo);
	// 다운로드 할 때 파일명 보이잖아? 그 경우
	public int deleteAttatches(BoardVO board); // delAttNos의 length와 int 일치
}
