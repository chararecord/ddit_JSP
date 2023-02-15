package kr.or.ddit.vo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.ibatis.type.Alias;
import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

/**
 * @author 민경진
 * @Since 2023. 2. 6.
 * <pre>
 *
 * ======[[개정이력(Modification Information)]]======
 *   수정일                    수정자                        수정내용
 * --------          --------    -----------------------
 * 2023. 2. 6.       PC-04        ★★★작성해주세요★★★
 *
 * Copyright (c) 2023 by DDIT All right reserved
 * </pre>
 */
@Data
@Alias("CommonAttaFileVO")
public abstract class CommonAttaFileVO {
	
	private List<AttaFileVO> attaFileList;
	private String[] delAttaIds;				// 게시글 수정시 삭제할 첨부파일 번호 유지
	private int attaCount;
	private MultipartFile[] files;
	private int startAttaSn;
	public void setFiles(MultipartFile[] files) {
		if(files!=null && files.length > 0) {
			this.files = files;
			this.attaFileList = Arrays.stream(files)
										.filter((f)->!f.isEmpty())
										.map((f)->{
											return new AttaFileVO(f);
										}).collect(Collectors.toList());
		}
	}
	public abstract String getAttaId();
}
