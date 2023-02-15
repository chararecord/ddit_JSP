package kr.or.ddit.vo;

import java.io.Serializable;
import java.util.List;

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
public class SchHistVO implements Serializable {

	@NotNull
	private String schHistId; //장학금내역아이디
	@NotNull
	private Integer stdId; //아이디(학번)
	@NotNull
	private List<ScholarshipVO> scholarshipList; //장학금아이디
	private String beneDate; //수혜일
	
	//조인컬럼 변수
//	private vo명타입 vo필드변수이름; 
}
