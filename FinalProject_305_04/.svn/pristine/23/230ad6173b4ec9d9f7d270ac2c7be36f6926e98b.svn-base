package kr.or.ddit.student.lectList.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.vo.LectureVO;
import kr.or.ddit.vo.StudentVO;


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
	 * @param pagingVO
	 * @return
	 */
	public List<LectureVO> selectLectList(int stdId);
}
