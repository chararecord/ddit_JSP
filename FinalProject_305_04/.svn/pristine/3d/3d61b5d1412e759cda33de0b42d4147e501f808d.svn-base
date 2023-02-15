package kr.or.ddit.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of="stdId")
public class MyStudentVO extends UsrVO{

	
	private Integer stdId;
	private String majorId;
	private Integer profId;
	private String entDate;
	
	private MajorVO majorVO;
	private CollVO collVO;
	private ProfessorVO professorVO;
	
	private Integer camYear; // 마지막 변동된 학년 정보 . 학적 변동 정보는 record의  list로 넣어야함
}
