package kr.or.ddit.board.vo;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Default;

import kr.or.ddit.validate.DeleteGroup;
import kr.or.ddit.validate.UpdateGroup;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(of="boNo")
@ToString(exclude= {"boContent", "boPass"})
public class BoardVO implements Serializable {
	
	private int rnum; //의사 숫자 컬럼 출력
	
	
	@NotNull(groups={UpdateGroup.class, DeleteGroup.class})
	private Integer boNo;

	@NotBlank
	private String boTitle;
	@NotBlank
	private String boWriter;
	@NotBlank
	private String boIp;
	@Email
	private String boMail;
	@NotBlank(groups= {Default.class, DeleteGroup.class})
	@JsonIgnore
	private transient String boPass; //@JsonIgnore, transient: 이것만 제외하기 
	private String boContent;
	private String boDate;
	private Integer boHit;
	

	private List<AttatchVO> attachList;//has many관계 board가 attach를 가지고있어야됨 
	private int[] deleteAttNos; // 게시글 수정시, 삭제할 첨부파일 번호는 유지 
	
	
	private int attCount; //한 페이지 내에 첨부파일 갯수 출력 
	
	private MultipartFile[] boFiles; //첨부파일 
	
	private int startAttNo;
	
	public void setBoFiles(MultipartFile[] boFiles) { //첨부파일 여러개 
		if(boFiles!=null && boFiles.length > 0) { //배열이 존재할 경우
			this.boFiles = boFiles;
			this.attachList =  Arrays.stream(boFiles)
								   .filter((f)->!f.isEmpty()) //비어있지 않은 part만 걸러내겠다 
								   .map((f)-> {
									   return new AttatchVO(f);
								   }).collect(Collectors.toList());
		}
	}
	
	
}
