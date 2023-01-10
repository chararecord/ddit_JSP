package kr.or.ddit.file.controller;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.ddit.vo.FileTestVO;

@Controller
@RequestMapping("/fileUpload")
public class FileController {
	@Inject
	private WebApplicationContext context;
	private Resource saveFolderRes;
	private File saveFolder;
	
	@PostConstruct
	public void init() throws IOException {
		saveFolderRes = context.getResource("classpath:kr/or/ddit/file");
		saveFolder = saveFolderRes.getFile();
	}
	
	@GetMapping
	public String fileForm() {
		return "file/uploadForm";
	}
	
	@PostMapping
	// modelAttribute(request에 저장하는거)
	public String fileProcessCase2(@ModelAttribute("fileVO") FileTestVO commandObject
			, RedirectAttributes redirectAttributes) throws IllegalStateException, IOException { // 핸들러가 멀티파트데이터까지 싹 넣어줌(part, meta data 전부 포함)
		commandObject.file1SaveTo(saveFolder);
		commandObject.file2SaveTo(saveFolder);
		redirectAttributes.addFlashAttribute("result", commandObject);
		return "redirect:/fileUpload";
	}
	
//	@PostMapping
	public String fileProcessCase1(
		@RequestParam String textParam
		, @RequestParam String dateParam
		, @RequestPart MultipartFile file1
		, @RequestPart MultipartFile[] file2
		, RedirectAttributes redirectAttributes
	) throws IllegalStateException, IOException {
//	1. uploadForm에서 결과는 result에서 꺼내와야 한다.
//	2. savename을 다르게 해야 한다. -
//		2-1. 일단 savename을 따로 만들자.
//	3. file2는 안에 있는 데이터 값이 가변적이다...
		Map<String, Object> result = new LinkedHashMap<>();
		result.put("textParam", textParam);
		result.put("dateParam", dateParam);
		
		if(!file1.isEmpty()) {
			File dest = new File(saveFolder, UUID.randomUUID().toString());
			file1.transferTo(dest);
			result.put("file1", Collections.singletonMap("savename", dest.getName()));
		}
		
		result.put("file2", Arrays.stream(file2)
									.filter((f)->!f.isEmpty())
									.map((f)->{
										try {
											File dest = new File(saveFolder, UUID.randomUUID().toString());
											f.transferTo(dest);
											return Collections.singletonMap("savename", dest.getName());
										} catch (IOException e) {
											throw new RuntimeException(e);
										}
									}).collect(Collectors.toList())
					);
//		session.setAttribute("result", result);
		// 꺼내는 순간 바로 삭제됨
		redirectAttributes.addFlashAttribute("result", result);
		return "redirect:/fileUpload";
	}
	
}
