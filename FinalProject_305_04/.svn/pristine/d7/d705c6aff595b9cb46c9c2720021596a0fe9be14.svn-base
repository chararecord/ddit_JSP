package kr.or.ddit.prof.lectSylla.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.vo.BuildingVO;
import kr.or.ddit.vo.LectRoomVO;
import kr.or.ddit.vo.SemesterVO;
import kr.or.ddit.vo.SubMajorVO;
import kr.or.ddit.vo.SyllabusVO;

/**
 * @author PC-17
 * @Since 2023. 2. 7.
 * <pre>
 *
 * ======[[개정이력(Modification Information)]]======
 *   수정일          수정자             수정내용
 * --------          --------    -----------------------
 * 2023. 2. 7.       서범수      	생성
 *
 * Copyright (c) 2023 by DDIT All right reserved
 * </pre>
 */

@Mapper
public interface LectureSyllabusDAO {
	
	/**
	 * 강의 계획서 목록 조회
	 * @param profId
	 * @return
	 */
	public List<SyllabusVO> selectSyllabusList(int profId);
	

	/**
	 * 교수의 소속 학과의 학과과목 리스트 조회
	 * @param professorVO
	 * @param semesterVO
	 * @return
	 */
	public List<SubMajorVO> selectSubMajorList(HashMap<String, String> map);
	
	
	/**
	 * 학사년도 리스트 조회
	 * @return
	 */
	public List<SemesterVO> selectSemesterList();
	
	/**
	 * 건물 리스트 조회
	 * @return
	 */
	public List<BuildingVO> selectBuildingList();
	
	/**
	 * 건물목록 중 한 건물을 선택하면 강의실 목록 가져오기
	 * @return
	 */
	public List<LectRoomVO> selectLectRoomList(BuildingVO buildingVO);
	
	/**
	 * 강의계획서 등록
	 * @param syllabusVO
	 * @return
	 */
	public int insertLectSyllabus(SyllabusVO syllabusVO);
	
	/**
	 * 강의승인 테이블에 등록할 강의계획서 아이디 조회
	 * @param syllabusVO
	 * @return
	 */
	public List<SyllabusVO> selectSyllaAppr(SyllabusVO syllabusVO);
	
	/**
	 * 강의계획서 등록 후 강의승인 테이블에 등록
	 * @param syllabusVO
	 * @return
	 */
	public int insertSyllaAppr(SyllabusVO syllabusVO);
	
}
