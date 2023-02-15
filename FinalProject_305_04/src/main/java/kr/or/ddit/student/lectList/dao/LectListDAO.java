package kr.or.ddit.student.lectList.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import kr.or.ddit.vo.MyLectureVO;
import kr.or.ddit.vo.MyStudentVO;


/**
 * @author 이현주
 * @Since 2023. 2. 6.
 * <pre>
 *
 * ======[[개정이력(Modification Information)]]======
 *   수정일                    수정자                        수정내용
 * --------          --------    -----------------------
 * 2023. 2. 6.       이현주        		생성
 *
 * Copyright (c) 2023 by DDIT All right reserved
 * </pre>
 */

@Mapper
public interface LectListDAO {

	/**
	 * 게시글 목록 조회
	 * @param stdId
	 * @return
	 */
	public List<MyStudentVO> selectLectList(@Param("stdId") int stdId, @Param("semeId") String semeId);
}
