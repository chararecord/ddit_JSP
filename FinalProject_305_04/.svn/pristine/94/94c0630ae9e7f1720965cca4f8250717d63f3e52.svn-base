package kr.or.ddit.vo;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author 이현주
 * @Since 2023. 2. 3.
 * <pre>
 *
 * ======[[개정이력(Modification Information)]]======
 *   수정일                    수정자                        수정내용
 * --------        --------    -----------------------
 * 2023. 2. 3.       이현주             생성
 *
 * Copyright (c) 2023 by DDIT All right reserved
 * </pre>
 */

@Data
@EqualsAndHashCode(of="scholarshipId")
@ToString
public class ScholarshipVO implements Serializable {

@NotNull
private int rnum;

@NotNull	
private String scholarshipId; // 장학금아이디

@NotBlank
private String schsNm; //장학금명
@NotBlank
private int schsAmount; //장학금액
@NotBlank
private String selectCrit; //선정기준
	
	



}
