package kr.or.ddit.vo;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 학생의 학적 내역 정보 한 건을 담기 위한 객체
 * @author 장은호
 * @Since 2023. 2. 2.
 * <pre>
 *
 * ======[[개정이력(Modification Information)]]======
 *   수정일                    수정자                        수정내용
 * --------          --------    -----------------------
 * 2023. 2. 2.       장은호        	  VO생성
 * 2023. 2. 10.      장은호               rnum 추가
 * 2023. 2. 11.      장은호               recYear, recSeme, recPeriod 삭제
 * 2023. 2. 14.      장은호               semester 추가
 * Copyright (c) 2023 by DDIT All right reserved
 * </pre>
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(of="recoId")
public class RecordVO implements Serializable {
	private int rnum;
	@NotBlank
	private String recoId;		// 학적아이디
	@NotNull
	private Integer stdId;		// 아이디(학번)
	@NotBlank
	private String semeId;		// 학사연도아이디
	@NotNull
	private Integer camYear;	// 학년
	@NotBlank
	private String recNm;		// 학적구분
	private String recUpdate;	// 학적변경일
	private String recReason;	// 사유
	private String recDate;		// 신청일
	private String recStatus;	// 신청상태
	private String rejReason;	// 반려사유
	
	private SemesterVO semester; // 학사연도
}
