package kr.or.ddit.vo;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import kr.or.ddit.validate.DeleteGroup;
import kr.or.ddit.validate.InsertGroup;
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
 * 2023. 2. 2.       이선민               생성
 * 2023. 2. 6.       이선민               수정
 *
 * Copyright (c) 2023 by DDIT All right reserved
 * </pre>
 */


@Data
@ToString
@EqualsAndHashCode(of="testId")
@NoArgsConstructor
public class TestVO implements Serializable {

	//넘버링
	private int rnum;  
	
	//시험
	@NotNull
	private String testId;
	@NotBlank
	private String examId;
	@NotBlank
	private String lectId;
	private String testNm;
	private Date testRdate;
	private String testStime;
	private String testEtime;
	private String testMeet;
	private String testDate;
	
	private String lectNm;
	

	//문제
	private List<TestQueVO> queList; //has many 관계 (1:N)

	//시험응시
	private String testAllowId;
	private String curlectId;
	private Integer testScore; 
	
	private TestAllowVO testAllow; //has a 관계 - 거래처명
	

	
	
}
