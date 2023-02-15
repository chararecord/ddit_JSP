package kr.or.ddit.student.record.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.ddit.student.record.dao.RecordDAO;
import kr.or.ddit.vo.CollVO;
import kr.or.ddit.vo.MajorVO;
import kr.or.ddit.vo.RecordVO;
import kr.or.ddit.vo.SemesterVO;
import kr.or.ddit.vo.StudentVO;
import lombok.extern.slf4j.Slf4j;

/**
 * @author 장은호
 * @Since 2023. 2. 14.
 * <pre>
 *
 * ======[[개정이력(Modification Information)]]======
 *   수정일                    수정자                        수정내용
 * --------          --------    -----------------------
 * 2023. 2. 14.       장은호        		생성
 *
 * Copyright (c) 2023 by DDIT All right reserved
 * </pre>
 */
@Slf4j
@Service
public class RecordServiceImpl implements RecordService {

	@Inject
	private RecordDAO recordDAO;


	@Override
	public StudentVO retrieveRecordList(int stdId) {
		StudentVO savedData = recordDAO.selectRecordList(stdId);
		return savedData;
	}

	
	@Override
	public int createRecord(RecordVO record) {
		String recNm = record.getRecNm();
		int rowcnt = 0;
		
//		StudentVO storedStudentData = retrieveRecordList(record.getStdId());
//		log.info("얍얍{}", storedStudentData);
		
		
		// 입학, 편입 - 학생 등록 페이지에서 처리
		
		// 휴학
		if(recNm.equals("휴학")) {
			StudentVO savedData = retrieveRecordList(record.getStdId());
			log.info("얍얍{}", savedData);
			
			record.setRecStatus("3");	// 바로 승인
			rowcnt = recordDAO.insertRecord(record);
		}
		
		// 복학
//		if(recNm.equals("복학")) {
//			List<RecordVO> storedRecords = retrieveRecordList(record.getStdId());
//			log.info("얍얍{}", storedRecords);
//			RecordVO latestRecord = storedRecords.get(1);
//			log.info("======{}", latestRecord);
//			// 가장 최근 학적 구분이 휴학인 경우
//			if(!latestRecord.getRecNm().equals("휴학")) {
//				return rowcnt;
//			} 
//			record.setRecStatus("3");	// 바로 승인
//			rowcnt = recordDAO.insertRecord(record);
//		}

		// 전과
		// 자퇴

		
		// 학년 진급
		
		
		// 수료
		// 졸업
		return rowcnt;
	}


	// 전체 단과대학 목록
	@Override
	public List<CollVO> retrieveCollegeList() {
		return recordDAO.selectCollegeList();
	}

	// 선택 단과대학의 학과 목록 
	@Override
	public List<MajorVO> retrieveMajorList(CollVO collVO) {
		List<MajorVO> majorList = recordDAO.selectMajorList(collVO);
		return majorList;
	}


	@Override
	public SemesterVO retrieveSemester() {
		SemesterVO semesterVO = recordDAO.selectSemester();
		return semesterVO;
	}


	@Override
	public SemesterVO retrieveNextSemester(SemesterVO semesterVO) {
		SemesterVO nextSemester = recordDAO.selectNextSemester(semesterVO);
		return nextSemester;
	} 

	

}
