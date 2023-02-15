package kr.or.ddit.student.record.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.RecordVO;

/**
 * @author 장은호
 * @Since 2023. 2. 2.
 * <pre>
 *
 * ======[[개정이력(Modification Information)]]======
 *   수정일                    수정자                        수정내용
 * --------          --------    -----------------------
 * 2023. 2. 2.       장은호        		생성
 *
 * Copyright (c) 2023 by DDIT All right reserved
 * </pre>
 */
@Mapper
public interface RecordDAO {
	
	/**
	 * 학적 내역 목록 조회
	 * @param pagingVO
	 * @return 전체 학적 내역 수
	 */
	public List<RecordVO> selectRecordList(PagingVO<RecordVO> pagingVO);

	/**
	 * 해당 학적아이디에 해당하는 학적 한 건을 조회
	 * @param recoId
	 * @return 존재하지 않으면 null 반환
	 */
//	public RecordVO selectRecord(String recoId);
	
	
	/**
	 * 학적 전체 개수 조회
	 * @param pagingVO
	 * @return
	 */
	public int selectTotalResults(PagingVO<RecordVO> pagingVO);
//	selectResultsList;
//	insertRecord;
//	updateRecord;
}
