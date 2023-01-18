package kr.or.ddit.prod.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.prod.dao.OthersDAO;
import kr.or.ddit.prod.service.ProdService;
import kr.or.ddit.validate.InsertGroup;
import kr.or.ddit.vo.BuyerVO;
import kr.or.ddit.vo.ProdVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ProdInsertController {
		
	@Inject
	private ProdService service;
	
	@ModelAttribute("prod")
	public ProdVO prod() {
		return new ProdVO();
	}

	@RequestMapping("/prod/prodInsert.do")
	public String prodForm() {
		log.info("폼왔슈");
		return "prod/prodForm";
	}
	
	@RequestMapping(value="/prod/prodInsert.do", method=RequestMethod.POST)
	public String insertProcess(
		@Validated(InsertGroup.class) @ModelAttribute("prod") ProdVO prod // command object
		, Errors erros // 항상 에러 다음에 모델..(검증의 결과는 타겟 바로 다음에)
		, Model model) throws IOException {
		
		String viewName = null;
		if(!erros.hasErrors()) {
			log.info("탓따");
			ServiceResult result = service.createProd(prod);
			if(ServiceResult.OK == result) {
				viewName = "redirect:/prod/" + prod.getProdId();
			} else {
				model.addAttribute("message", "서버 오류, 이따가 다시하세요");
				viewName = "prod/prodForm";
			}
		} else {
			log.info("못탓따");
			viewName = "prod/prodForm";
		}
		return viewName;
	}
}
