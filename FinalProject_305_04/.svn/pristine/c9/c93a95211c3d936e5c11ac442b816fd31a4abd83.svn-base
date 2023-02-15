package kr.or.ddit.vo;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotNull;

import kr.or.ddit.validate.DeleteGroup;
import kr.or.ddit.validate.UpdateGroup;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 수강강의
 * @author 이선민
 * @Since 2023. 2. 8.
 * <pre>
 *
 * ======[[개정이력(Modification Information)]]======
 *   수정일                    수정자                        수정내용
 * --------          --------    -----------------------
 * 2023. 2. 8.       이선민        		생성
 * 2023. 2. 8.       이현주        		수정
 *
 * Copyright (c) 2023 by DDIT All right reserved
 * </pre>
 */
@Data
@EqualsAndHashCode(of="curlectId")
@ToString
public class CurrLectVO implements Serializable {
	
	@NotNull
	private String curlectId;
	@NotNull
	private Integer stdId;
	@NotNull
	private String lectId;
	private String finScore;
	
	//출결
	private List<AttendVO> attendtList; //has many 관계 (1:N)
	
	// 강의
	private List<LectureVO> lectureList; //has many 관계 (1:N)
	
	// 학생
	private List<StudentVO> studentList; //has many 관계 (1:N)
	
	
}
