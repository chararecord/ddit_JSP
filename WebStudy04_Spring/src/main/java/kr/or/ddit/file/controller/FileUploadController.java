package kr.or.ddit.file.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class FileUploadController {
	
	@RequestMapping(value = "/file/upload.do", method = RequestMethod.POST)
//	@PostMapping("/file/upload.do") spring에는 존재함
	public String upload(HttpServletRequest req, HttpSession session) throws IOException, ServletException {
		// 텍스트 데이터 처리
		String textPart = req.getParameter("textPart");
		String numPart = req.getParameter("numPart");
		String datePart = req.getParameter("datePart");
		log.info("textPart : {}", textPart);
		log.info("numPart : {}", numPart);
		log.info("datePart : {}", datePart);
		session.setAttribute("textPart", textPart);
		session.setAttribute("numPart", numPart);
		session.setAttribute("datePart", datePart);
		
		// 이진 데이터 처리
		String saveFolderURL = "/resources/prodImages";
		ServletContext application = req.getServletContext();
		String saveFolderPath = application.getRealPath(saveFolderURL);
		File saveFolder = new File(saveFolderPath);
		if(!saveFolder.exists()) {
			saveFolder.mkdirs();
		}
		
		List<String> metadata =  req.getParts().stream()
												.filter((p)->p.getContentType()!=null && p.getContentType().startsWith("image/")) // 문자파트 걸러내고 파일 파트만 남기기
												.map((p)->{
													String originalFilename = p.getSubmittedFileName();
													// 원본파일명으로는 저장하지 않는다(원본파일명이 겹칠수도, backdoor 공격방지)
													String saveFilename = UUID.randomUUID().toString();
													File saveFIle = new File(saveFolder, saveFilename);
													try {
														p.write(saveFIle.getCanonicalPath());
														String saveFileURL =  saveFolderURL + "/" + saveFilename;
														return saveFileURL; // 문자열 반환
													} catch (IOException e) {
														throw new RuntimeException(e);
													}
												}).collect(Collectors.toList());
		session.setAttribute("fileMetadata", metadata);
		
		return "redirect:/fileUpload/uploadForm.jsp";
	}
}
