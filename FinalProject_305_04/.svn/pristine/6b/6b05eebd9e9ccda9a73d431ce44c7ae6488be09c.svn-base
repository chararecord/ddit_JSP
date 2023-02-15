package kr.or.ddit.student.attend.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.vo.AttendVO;


/**
 * 출결 현황 조회(학생)
 * @author 이현주
 * @Since 2023. 2. 8.
 * <pre>
 *
 * ======[[개정이력(Modification Information)]]======
 *   수정일                    수정자                        수정내용
 * --------          --------    -----------------------
 * 2023. 2. 8       이현주        			생성
 * 
 * Copyright (c) 2023 by DDIT All right reserved
 * </pre>
 */

@Mapper
public interface AttendDAO {

	/**
	 * 출결 현황 조회(학생)
	 * @param stdId
	 * @return
	 */
	public List<AttendVO> selectAttendList(@Param("stdId") int stdId, @Param("lectId") String lectId);
	
	
}
