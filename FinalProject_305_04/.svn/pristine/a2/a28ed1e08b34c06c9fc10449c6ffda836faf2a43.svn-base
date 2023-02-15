package kr.or.ddit.commons.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.vo.AttaFileVO;
import kr.or.ddit.vo.CommonAttaFileVO;

@Mapper
public interface AttaFileDAO {
	
	public <T extends CommonAttaFileVO> int insertAttaFiles(T vo);
	public int insertAttaFile(AttaFileVO attaFile);
	public List<AttaFileVO> selectAttaFileList(int id);
	public AttaFileVO selectAttaFile(int attaId);
	public <T> int deleteAttaFile(T vo);
}
