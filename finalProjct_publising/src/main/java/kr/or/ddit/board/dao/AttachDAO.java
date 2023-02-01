package kr.or.ddit.board.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.board.vo.AttatchVO;
import kr.or.ddit.board.vo.BoardVO;



@Mapper //mybatis에 의해서 이 구현체가 proxy로 사용될수있음 
public interface AttachDAO {
   
	//게시글과 첨부파일의 관계 1:다 -  하나의 게시글에 여러개의 첨부파일이 있을수있음 
	public int insertAttatches(BoardVO board); //다섯개의 첨부파일이 포함되어있었따? 그럼 5가 반환되어야됨 

	//첨부파일이 포함된 게시글리스트
	public List<AttatchVO> selectAttachList(int boNo);
	
	//첨부파일이 포함된 게시글 하나 조회
	public AttatchVO selectAttach(int attNo);
	
	//한개의 첨부파일 삭제
	public int deleteAttaches(BoardVO board);
}
