package kr.or.ddit.student.assignment.service;


import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.ddit.student.assignment.dao.AssignmentStudentDAO;
import kr.or.ddit.vo.AssignmentVO;
import kr.or.ddit.vo.CurrLectVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AssignmentServiceImpl implements AssignmentService {
	
	@Inject
	private AssignmentStudentDAO assignmentDAO;
	
	
	/**
	 * 과제 목록 게시물 조회 
	 * @param curlectId
	 */
	@Override
	public CurrLectVO retrieveAssignmentList(String curlectId) {
		return this.assignmentDAO.selectAssignmentList(curlectId);
	}


	
	/**
	 * 과제 게시물 단건 조회
	 * @param asgnId
	 */
	@Override
	public AssignmentVO retrieveAssignment(String asgnId) {
		return this.assignmentDAO.selectAssignmentView(asgnId);
	}

	


}
