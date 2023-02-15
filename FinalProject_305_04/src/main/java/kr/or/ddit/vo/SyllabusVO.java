package kr.or.ddit.vo;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author PC-17
 * @Since 2023. 2. 6.
 * 
 *        <pre>
 *
 * ======[[개정이력(Modification Information)]]======
 *   수정일           수정자           수정내용
 * --------          --------    -----------------------
 * 2023. 2. 6.       서범수        생성
 *
 * Copyright (c) 2023 by DDIT All right reserved
 *        </pre>
 */
@Data
@EqualsAndHashCode(of = "syllaId")
@ToString
public class SyllabusVO extends UsrVO{
	private String syllaId;
	private String semeId;
	private ProfessorVO professorVO;
	private String lectRoomId;
	private String subMajorId;
	private String lectNm;
	private Integer camYear;
	private Integer lectHour;
	private String hopeTime;
	private Integer hopeMax;
	private String textbook;
	private String lectCom;
	private String note;
	private String syllaMeet;

	private SemesterVO semesterVO;
	private String commDesc;
	private SubMajorVO subMajorVO;
	private BuildingVO buildingVO;
	private LectRoomVO lectRoomVO;
	private SyllaApprVO syllaApprVO;

}
