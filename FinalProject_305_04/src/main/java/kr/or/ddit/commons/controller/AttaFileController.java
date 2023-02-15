package kr.or.ddit.commons.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.commons.dao.AttaFileDAO;
import kr.or.ddit.vo.AttaFileVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class AttaFileController {
	
	@Value("#{appInfo.imageFolder}")
	private File imageFolder;
	
	@Value("#{appInfo.imageFolder}")
	private String imageFolderURL;
	
	@PostConstruct
	public void init() throws IOException {
		log.info("이미지 저장 경로 : {}", imageFolder.getCanonicalPath());
		if(!imageFolder.exists()) {
			imageFolder.mkdirs();
		}
	}
	
	@Inject
	private AttaFileDAO attaFileDAO;
	
	//파일 다운로드
	// localhost/download?fileName=2022/07/25/cd862ebd-10a2-4220-bbbb-5bbf8ffdadd7_phone01.jpg
	@ResponseBody
	@GetMapping("/download/{attaId}/{attaSn}")
	public ResponseEntity<Resource> download(
			@PathVariable String attaId
			, @PathVariable String attaSn
			, @RequestParam(value="fileName", required=false) String fileName){
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("attaId", attaId);
		map.put("attaSn", attaSn);
		
		Map<String, Object> resultMap = this.attaFileDAO.selectAttaFile(map);
		
		fileName = (String)resultMap.get("ATTA_SAVENM");
				
		//resource : 다운로드 받을 파일(자원)
		Resource resource = new FileSystemResource(
				"D:\\A_TeachingMaterial\\06_JSP_Spring\\workspace\\FinalProject_305_04\\src\\main\\webapp\\resources\\images\\attaFile\\"
				+fileName
				);
		//cd862ebd-10a2-4220-bbbb-5bbf8ffdadd7_phone01.jpg
		String resourceName = (String)resultMap.get("ATTA_FILENM");
		//header : 인코딩 정보, 파일명 정보
		HttpHeaders headers = new HttpHeaders();
		try {
			headers.add("Content-Disposition", "attachment;filename="+
					new String(resourceName.getBytes("UTF-8"),"ISO-8859-1"));
		} catch (UnsupportedEncodingException e) {
			log.info(e.getMessage());
		}
		
		return new ResponseEntity<Resource>(resource, headers, HttpStatus.OK);
	}
}
