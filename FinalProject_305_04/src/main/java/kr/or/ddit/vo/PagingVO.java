package kr.or.ddit.vo;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 페이징과 관련된 모든 데이터를 가진 클래스
 * @author 민경진
 * @Since 2023. 2. 2.
 * <pre>
 *
 * ======[[개정이력(Modification Information)]]======
 *   수정일                    수정자                        수정내용
 * --------        --------    -----------------------
 * 2023. 2. 2.       민경진             생성
 *
 * Copyright (c) 2023 by DDIT All right reserved
 * </pre>
 * @param <T>
 */
@Getter
@NoArgsConstructor
@ToString
public class PagingVO<T> {
	
	public PagingVO(int screenSize, int blockSize) {
		super();
		this.screenSize = screenSize;
		this.blockSize = blockSize;
	}
	
	private int totalRecord;		// DB에서 조회, 총 개수
	private int screenSize = 10;
	private int blockSize = 5;
	
	private int currentPage;
	
	private int totalPage;
	private int startRow;
	private int endRow;
	private int startPage;
	private int endPage;
	
	private List<T> dataList;
	
	private SearchVO simpleCondition;	// 단순 키워드 검색
	private T detailCondition;			// 상세 검색
	
	public void setDetailCondition(T detailCondition) {
		this.detailCondition = detailCondition;
	}
	public void setSimpleCondition(SearchVO simpleCondition) {
		this.simpleCondition = simpleCondition;
	}
	public void setDataList(List<T> dataList) {
		this.dataList = dataList;
	}
	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
		totalPage = (totalRecord + (screenSize - 1)) / screenSize;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
		endRow = currentPage * screenSize;
		startRow = endRow - (screenSize - 1);
		endPage = ((currentPage + (blockSize - 1)) / blockSize) * blockSize;
		startPage = endPage - (blockSize - 1);
	}
	public int getEndPage() {
		return endPage > totalPage ? totalPage : endPage;
	}
}
