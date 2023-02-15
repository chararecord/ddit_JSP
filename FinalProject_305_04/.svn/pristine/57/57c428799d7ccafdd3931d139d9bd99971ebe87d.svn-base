package kr.or.ddit.vo;

import java.beans.Transient;
import java.io.Serializable;

import javax.validation.constraints.NotNull;

import kr.or.ddit.validate.DeleteGroup;
import kr.or.ddit.validate.UpdateGroup;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 사용자 객체
 * @author 장은호
 * @Since 2023. 2. 3.
 * <pre>
 *
 * ======[[개정이력(Modification Information)]]======
 *   수정일                    수정자                        수정내용
 * --------          --------    -----------------------
 * 2023. 2. 3.       장은호        		생성
 *
 * Copyright (c) 2023 by DDIT All right reserved
 * </pre>
 */
@Data
@EqualsAndHashCode(of="userId")
@ToString(exclude= {"userPass", "userRrn1", "userRrn2"})
@NoArgsConstructor
public class UsrVO implements Serializable {
	@NotNull(groups= {UpdateGroup.class, DeleteGroup.class})
	private Integer userId;
	private String userNm;
	private String userNmEn;
	private transient String userPass;
	private transient String userRrn1;
	private transient String userRrn2;
	private String userPhone;
	private String userPost;
	private String userAddr;
	private String userDetailAddr;
	private String userEmail;
	private String userBank;
	private String userAcctHd;
	private String userAcctNo;
	private String userGender;
	private String userNtl;
	private String userBir;
	private String userRole;
	private String userType;
}
