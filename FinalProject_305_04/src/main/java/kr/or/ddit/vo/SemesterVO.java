package kr.or.ddit.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of="semeId")
public class SemesterVO {

	private String semeId;
	private String semeYear;
	private String seme;
}
