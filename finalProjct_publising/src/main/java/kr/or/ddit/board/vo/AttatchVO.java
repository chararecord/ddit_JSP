package kr.or.ddit.board.vo;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@EqualsAndHashCode(of="attNo")
@NoArgsConstructor 
@ToString(exclude="realFile")
public class AttatchVO implements Serializable {

	
	@JsonIgnore
	private transient MultipartFile realFile; //transient : 출력할때 배제시키겠다
	
	//AttatchVO을 이 파일의 adapter처럼 활용할 수 있음 
	//클라이언트가 보내주는 정보를 받을 때 사용 
	//서버가 보내주는 정보를 받을 때 사용하는 건 => 기본생성자  @NoArgsConstructor
	public AttatchVO(MultipartFile realFile) {
		super();
		this.realFile = realFile;
		this.attFilename = realFile.getOriginalFilename(); //원본파일명
		this.attSavename = UUID.randomUUID().toString(); //저장할 때 자동으로 미리 savename이 결정됨
		this.attMime = realFile.getContentType(); //메타데이터 만들어짐 
		this.attFilesize = realFile.getSize();
		this.attFancysize = FileUtils.byteCountToDisplaySize(attFilesize);
	}

	private Integer attNo;
	private Integer boNo;
	private String attFilename;
	private String attSavename;
	private String attMime;
	private Long attFilesize; //파일사이즈가 클수도있으니까 long
	private String attFancysize;
	private Integer attDownload;
	
	public void saveTo(File saveFolder) throws IOException {
		if(realFile==null || realFile.isEmpty()) return; // 저장할 필요 없을 경우라면
		realFile.transferTo(new File(saveFolder, attSavename));
	}
	
}
