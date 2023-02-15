package kr.or.ddit.vo;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of="lectId")
public class MyLectureVO {

	
	private String assignRoomId;
	private String semeId;
	
	private SemesterVO semeVO; // 1:1
	private List<MyStudentVO> myStudentList; // has many 관계
	
	private String lectId;
	private String syllaApprId;
	private String lectNm;
	private String lectState;
	private Integer camYear;
	private Integer numClass;
	private Integer credit;
	private Integer lectHour;
	private String textbook;
	private String lectCom;
	private String note;
	private String onfLine;
	
	private String commDesc; //공통코드설명
	private String syllaMeet; //공통코드설명
	private String estaSub; //공통코드설명
	
	private MajorVO majorVO; // 학과명 , 1:1
	private UsrVO userVO; // 
	
}
