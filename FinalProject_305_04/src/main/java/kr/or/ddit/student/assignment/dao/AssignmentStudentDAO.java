package kr.or.ddit.student.assignment.dao;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import kr.or.ddit.vo.AssignmentVO;
import kr.or.ddit.vo.CurrLectVO;

@Mapper
public interface AssignmentStudentDAO {

	
	/**
	 * 과제 목록 게시물 조회 
	 * @param curlectId
	 * @return
	 */
	public CurrLectVO selectAssignmentList(@Param("curlectId") String curlectId);
	
	
	/**
	 * 과제 상세조회 
	 * @return
	 */
	public AssignmentVO selectAssignmentView(@Param("asgnId") String asgnId);
	
	
	
	
	
	
	
	
}