package kr.or.ddit.student.attend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ddit.student.attend.dao.AttendDAO;
import kr.or.ddit.vo.AttendVO;
import kr.or.ddit.vo.LectureVO;

/**
 * @author 이현주
 * @Since 2023. 2. 8.
 * <pre>
 *
 * ======[[개정이력(Modification Information)]]======
 *   수정일                    수정자                        수정내용
 * --------          --------    -----------------------
 * 2023. 2. 8.      이현주     			생성
 *
 * Copyright (c) 2023 by DDIT All right reserved
 * </pre>
 */
@Service
public class AttendServcieImpl implements AttendService {

	@Autowired
	AttendDAO attendDAO;
	
	
	@Override
	public List<AttendVO> retrieveAttendList(int stdId, String lectId) {
		// TODO Auto-generated method stub
		return this.attendDAO.selectAttendList(stdId, lectId);
	}

}
