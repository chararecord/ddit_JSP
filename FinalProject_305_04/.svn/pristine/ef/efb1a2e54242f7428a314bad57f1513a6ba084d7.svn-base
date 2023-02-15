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
@EqualsAndHashCode(of="asgnSubmId")
@ToString
public class AssignmentSubmitVO  implements Serializable {
	private String asgnSubmId;//과제제출아이디
	private String curlectId;//수강강의아이디
	private String asgnId;//과제아이디
	private String assignSdate;//과제제출일자
	private String assignCont;//과제제출내용
	private Integer assignScore;//과제점수
}
