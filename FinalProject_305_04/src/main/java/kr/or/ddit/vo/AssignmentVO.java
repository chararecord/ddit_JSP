package kr.or.ddit.vo;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.validate.DeleteGroup;
import kr.or.ddit.validate.UpdateGroup;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author 이선민
 * @Since 2023. 2. 14.
 * <pre>
 *
 * ======[[개정이력(Modification Information)]]======
 *   수정일                    수정자                        수정내용
 * --------        --------    -----------------------
 * 2023. 2. 14.       이선민             생성
 *
 * Copyright (c) 2023 by DDIT All right reserved
 * </pre>
 */
@Data
@EqualsAndHashCode(of="asgnId")
@ToString
public class AssignmentVO  implements Serializable {
	private int rnum;
	@NotNull(groups={UpdateGroup.class, DeleteGroup.class})
	private String asgnId; //과제아이디
	private String lectId; //강의코드
	private String assignNm;//과제명
	private String assignRdate;//과제등록일자
	private String assignDdate;//과제마감일자
	private String assignCont;//과제내용
	
	
	
	
	
	
	
}
