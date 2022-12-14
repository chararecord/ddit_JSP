package kr.or.ddit.prod.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.mvc.annotation.RequestMethod;
import kr.or.ddit.mvc.annotation.resolvers.ModelAttribute;
import kr.or.ddit.mvc.annotation.resolvers.RequestPart;
import kr.or.ddit.mvc.annotation.stereotype.Controller;
import kr.or.ddit.mvc.annotation.stereotype.RequestMapping;
import kr.or.ddit.mvc.multipart.MultipartFile;
import kr.or.ddit.mvc.multipart.MultipartHttpServletRequest;
import kr.or.ddit.prod.dao.OthersDAO;
import kr.or.ddit.prod.dao.OthersDAOImpl;
import kr.or.ddit.prod.service.ProdService;
import kr.or.ddit.prod.service.ProdServiceImpl;
import kr.or.ddit.validate.InsertGroup;
import kr.or.ddit.validate.ValidationUtils;
import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.ProdVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ProdInsertController {
	
	private OthersDAO othersDAO = new OthersDAOImpl();
	
	private void addAttribute(HttpServletRequest req) {
		req.setAttribute("lprodList", othersDAO.selectLprodList());
		req.setAttribute("buyerList", othersDAO.selectBuyerList(req.getParameter("buyerLgu")));
	}
	
	private ProdService service = new ProdServiceImpl();

	@RequestMapping("/prod/prodInsert.do")
	public String prodForm(HttpServletRequest req) {
		addAttribute(req);
		return "prod/prodForm";
	}
	
	@RequestMapping(value="/prod/prodInsert.do", method=RequestMethod.POST)
	public String insertProcess(
		@ModelAttribute("prod") ProdVO prod, HttpServletRequest req
		, @RequestPart("prodImage") MultipartFile prodImage) throws IOException, ServletException {
		
		addAttribute(req);
		prod.setProdImage(prodImage);
		
		// MEMBERVO ????????? ??????????????? ????????????.. ?????? ?????? ??? ?????? ????????? ????????????..
//		if(req instanceof MultipartHttpServletRequest) {
//			// ??????????????? ?????? ????????? ??? wrapper
//			MultipartHttpServletRequest wrapperReq = (MultipartHttpServletRequest) req;
//			// prodImage -> (DB??? ???????????????) prodImg
//			MultipartFile prodImage = wrapperReq.getFile("p
		
//		1. ??????
		String saveFolderURL = "/resources/prodImages"; // ??????????????? ????????? ??? properties ????????? ????????? ???????????? ??? ??????
		ServletContext application = req.getServletContext();
		String saveFolderPath = application.getRealPath(saveFolderURL);
		File saveFolder = new File(saveFolderPath);
		if(!saveFolder.exists()) {
			saveFolder.mkdirs();
		}
		prod.saveTo(saveFolder);
			
		Map<String, List<String>> errors = new HashMap<>();
		req.setAttribute("errors", errors);
		boolean valid = ValidationUtils.validate(prod, errors, InsertGroup.class);
		String viewName = null;
		if(valid) {
			ServiceResult result = service.createProd(prod);
			if(ServiceResult.OK == result) {
				viewName = "redirect:/prod/prodView.do?what=" + prod.getProdId();
			} else {
				req.setAttribute("message", "?????? ??????, ????????? ???????????????");
				viewName = "prod/prodForm";
			}
		} else {
			viewName = "prod/prodForm";
		}
		return viewName;
	}
}
