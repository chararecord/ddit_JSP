package kr.or.ddit.prod.controller;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.mvc.annotation.RequestMethod;
import kr.or.ddit.mvc.annotation.resolvers.ModelAttribute;
import kr.or.ddit.mvc.annotation.resolvers.RequestParam;
import kr.or.ddit.mvc.annotation.resolvers.RequestPart;
import kr.or.ddit.mvc.annotation.stereotype.Controller;
import kr.or.ddit.mvc.annotation.stereotype.RequestMapping;
import kr.or.ddit.mvc.multipart.MultipartFile;
import kr.or.ddit.prod.dao.OthersDAO;
import kr.or.ddit.prod.dao.OthersDAOImpl;
import kr.or.ddit.prod.service.ProdService;
import kr.or.ddit.prod.service.ProdServiceImpl;
import kr.or.ddit.validate.UpdateGroup;
import kr.or.ddit.validate.ValidationUtils;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.ProdVO;
import lombok.extern.slf4j.Slf4j;

// /prod/prodUpdate.do(GET, POST)

@Slf4j
@Controller
public class ProdUpdateController {
	
	private ProdService service = new ProdServiceImpl();
	private OthersDAO othersDAO = new OthersDAOImpl();
	
	private void addAttribute(HttpServletRequest req) {
		req.setAttribute("lprodList", othersDAO.selectLprodList());
		req.setAttribute("buyerList", othersDAO.selectBuyerList(req.getParameter("buyerLgu")));
	}
	
	@RequestMapping("/prod/prodUpdate.do")
	public String prodForm(@RequestParam("what") String prodId, HttpServletRequest req){
		ProdVO prod = service.retrieveProd(prodId);
		req.setAttribute("prod", prod);
		addAttribute(req);
		return "prod/prodForm";
	}
	
	@RequestMapping(value="/prod/prodUpdate.do", method=RequestMethod.POST)
	public String prodUpdate(
			@ModelAttribute("prod") ProdVO prod
			, @RequestPart(value="prodImage", required=false) MultipartFile prodImage
			, HttpServletRequest req) throws IOException {
		addAttribute(req);
		prod.setProdImage(prodImage);
		
//		1. 저장
		String saveFolderURL = "/resources/prodImages"; // 저장경로와 관련된 건 properties 파일로 빼놓고 관리하는 게 좋음
		ServletContext application = req.getServletContext();
		String saveFolderPath = application.getRealPath(saveFolderURL);
		File saveFolder = new File(saveFolderPath);
		if(!saveFolder.exists()) {
			saveFolder.mkdirs();
		}
		prod.saveTo(saveFolder);
		
//		if(prodImage!=null && !prodImage.isEmpty()) {
////			1. 저장
//			String saveFolderURL = "/resources/prodImages"; // 저장경로와 관련된 건 properties 파일로 빼놓고 관리하는 게 좋음
//			ServletContext application = req.getServletContext();
//			String saveFolderPath = application.getRealPath(saveFolderURL);
//			File saveFolder = new File(saveFolderPath);
//			if(!saveFolder.exists()) {
//				saveFolder.mkdirs();
//			}
////			2. metadata 추출 - 있으면
//			String saveFilename = UUID.randomUUID().toString();
//			prodImage.transferTo(new File(saveFolder, saveFilename));
////			3. DB 저장 : prodImg
//			prod.setProdImg(saveFilename);
//		}
		String viewName = null;
		
		Map<String, List<String>> errors = new LinkedHashMap<>();
		req.setAttribute("errors", errors);
		boolean valid = ValidationUtils.validate(prod, errors, UpdateGroup.class);
		if(valid) {
			ServiceResult result = service.modifyProd(prod);
			switch (result) {
			case NOTEXIST:
				req.setAttribute("message", "비밀번호 오류");
				throw new RuntimeException();
			case FAIL:
				req.setAttribute("message", "서버에 문제 있음. 다시 수정ㄱㄱ");
				viewName = "prod/prodForm";
				break;
			default:
				ProdVO modifiedProd = service.retrieveProd(prod.getProdId());
				viewName = "redirect:/prod/prodView.do?what=" + prod.getProdId();
				break;
			}
		} else {
			viewName = "prod/prodForm";
		}
		return viewName;
	}
}
