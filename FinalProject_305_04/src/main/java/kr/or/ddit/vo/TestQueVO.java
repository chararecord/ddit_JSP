package kr.or.ddit.vo;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import kr.or.ddit.validate.DeleteGroup;
import kr.or.ddit.validate.UpdateGroup;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;



/**
 * 
 * @author 이선민
 * @Since 2023. 2. 2.
 * <pre>
 *
 * ======[[개정이력(Modification Information)]]======
 *   수정일                    수정자                        수정내용
 * --------          --------    -----------------------
 * 2023. 2. 6.       이선민               생성
 *
 * Copyright (c) 2023 by DDIT All right reserved
 * </pre>
 */


@Data
@ToString
@EqualsAndHashCode(of="testQueId")
@NoArgsConstructor
public class TestQueVO implements Serializable {


	@NotNull
	private String testQueId;
	@NotNull
	private String testId;
	private String testNum;
	private String testQue;
	
	//지문
	private List<TestPasgVO> pasgList; //has many 관계 (1:N)
}
