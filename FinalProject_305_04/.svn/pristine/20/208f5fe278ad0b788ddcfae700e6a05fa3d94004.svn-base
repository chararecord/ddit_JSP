package kr.or.ddit.vo;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author 이현주
 * @Since 2023. 2. 8.
 * <pre>
 *
 * ======[[개정이력(Modification Information)]]======
 *   수정일                    수정자                        수정내용
 * --------          --------    -----------------------
 * 2023. 2. 8.       이현주        			생성
 *
 * Copyright (c) 2023 by DDIT All right reserved
 * </pre>
 */
@Data
@ToString
@EqualsAndHashCode(of="attendId")
public class AttendVO implements Serializable{

	
	@NotNull
	private String attendId; // 출결 아이디
	@NotNull
	private String curlectId; // 수강강의 아이디
	private String attendDate; // 출결일
	private String attendStat; // 출결 상태
	
	private String lectNm; // 강의명

	private String semeYear; // 학사년도
	private String seme; //학기
	
}
