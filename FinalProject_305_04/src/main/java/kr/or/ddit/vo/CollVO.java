package kr.or.ddit.vo;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author 이현주
 * @Since 2023. 2. 7.
 * <pre>
 *
 * ======[[개정이력(Modification Information)]]======
 *   수정일                    수정자                        수정내용
 * --------          --------    -----------------------
 * 2023. 2. 7.       이현주      		생성
 * 
 * Copyright (c) 2023 by DDIT All right reserved
 * </pre>
 */

@Data
@EqualsAndHashCode(of="collId")
public class CollVO implements Serializable{
	
	private String collId; // 단과대학 아이디
	private String collNm; // 단과대학명
	private String collIntro; // 단과대학소개
}
