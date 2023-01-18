package kr.or.ddit.prod.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.ServletException;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.prod.dao.OthersDAO;
import kr.or.ddit.prod.service.ProdService;
import kr.or.ddit.ui.BootstrapPaginationRender;
import kr.or.ddit.ui.PaginationRenderer;
import kr.or.ddit.vo.BuyerVO;
import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.ProdVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/prod")
public class ProdListController{
   @Inject
   private ProdService service;
   @Resource(name="bootstrapPaginationRender")
   private PaginationRenderer renderer;
   
   @GetMapping
   public String listUI(Model model) {
      return "prod/prodList";
   }
   
   @GetMapping(produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
   // 핸들러 메소드가 annotation이 없어도 있는 것처럼 돌아감
   public String listData(
      @RequestParam(value="page", required=false, defaultValue="1") int currentPage
      , @ModelAttribute("detailCondition") ProdVO detailCondition
      , Model model
   ) throws ServletException {
	   
	  PagingVO<ProdVO> pagingVO = new PagingVO<>(5, 2);
      pagingVO.setCurrentPage(currentPage);
      pagingVO.setDetailCondition(detailCondition);
      
      service.retrieveProdList(pagingVO);
      model.addAttribute("pagingVO", pagingVO);
      model.addAttribute("pagingHTML", renderer.renderPagination(pagingVO));
      
      return "jsonView";
   }
}