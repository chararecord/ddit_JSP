package kr.or.ddit.student.scholarship.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.ddit.student.scholarship.dao.ScholarshipDAO;
import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.ScholarshipVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ScholarshipServiceImpl implements ScholarshipService {

	@Inject
	private ScholarshipDAO scholarshipDAO;
	
	// 장학금 내역 조회
	@Override
	public void retrieveScholarshipList(PagingVO<ScholarshipVO> pagingVO) {
		pagingVO.setTotalRecord(scholarshipDAO.selectTotalRecord(pagingVO)); //전체 글 갯수 조회
		pagingVO.setDataList(scholarshipDAO.selectScholarshipList(pagingVO));// 목록조회
	}

}
