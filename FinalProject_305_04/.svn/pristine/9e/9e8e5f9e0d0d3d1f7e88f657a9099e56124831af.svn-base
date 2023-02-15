package kr.or.ddit.vo;

import java.io.Serializable;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 학생 객체
 * @author 장은호
 * @Since 2023. 2. 3.
 * <pre>
 *
 * ======[[개정이력(Modification Information)]]======
 *   수정일                    수정자                        수정내용
 * --------          --------    -----------------------
 * 2023. 2. 3.       장은호        		생성
 *
 * Copyright (c) 2023 by DDIT All right reserved
 * </pre>
 */
@Data
@EqualsAndHashCode(of="stdId")
@ToString
public class StudentVO implements Serializable {
	private Integer stdId;
	private String majorId;
	private Integer profId;
	private String entDate;
	private String entType;
	
	private List<RecordVO> recordList;
}

