package kr.or.ddit.student.assignment.service;

import kr.or.ddit.vo.AssignmentVO;
import kr.or.ddit.vo.CurrLectVO;

public interface AssignmentService {

	
	/**
	 * 과제 목록 게시물 조회 
	 * @param curlectId
	 */
	public CurrLectVO retrieveAssignmentList(String curlectId);

	
	/**
	 * 과제 게시물 단건 조회
	 * @param asgnId
	 */
	public AssignmentVO retrieveAssignment(String asgnId);
	
	
	
	
	
}
