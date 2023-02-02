package kr.or.ddit.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

/**
 * 메뉴 VO
 * @author 민경진
 * @Since 2023. 2. 2.
 * <pre>
 *
 * ======[[개정이력(Modification Information)]]======
 *   수정일                    수정자                        수정내용
 * --------          --------    -----------------------
 * 2023. 2. 2.       PC-04        ★★★작성해주세요★★★
 *
 * Copyright (c) 2023 by DDIT All right reserved
 * </pre>
 */
@Data
@EqualsAndHashCode(of="menuCode")
@RequiredArgsConstructor
public class MenuVO {
	private String menuId;
	private String parentId;
	private String menuName;
	private String menuUrl;
}
