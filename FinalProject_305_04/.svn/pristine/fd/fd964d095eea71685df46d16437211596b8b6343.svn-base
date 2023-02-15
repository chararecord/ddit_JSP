package kr.or.ddit.ui;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.support.RequestContextUtils;

import kr.or.ddit.vo.PagingVO;

/**
 * pagination custom tag 만들려고 했음
 * @author 민경진
 * @Since 2023. 2. 2.
 * <pre>
 *
 * ======[[개정이력(Modification Information)]]======
 *   수정일                    수정자                        수정내용
 * --------        --------    -----------------------
 * 2023. 2. 2.       민경진        	생성
 *
 * Copyright (c) 2023 by DDIT All right reserved
 * </pre>
 */
public class PaginationTag extends TagSupport {
	private String type;
	public void setType(String type) {
		this.type = type;
	}
	
	private PagingVO<?> pagingVO;
	public void setPagingVO(PagingVO<?> pagingVO) {
		this.pagingVO = pagingVO;
	}
	
	@Override
	public int doEndTag() throws JspException {
		HttpServletRequest req = (HttpServletRequest) pageContext.getRequest();
		ServletContext application = pageContext.getServletContext();
		
		WebApplicationContext springContainer = RequestContextUtils.findWebApplicationContext(req, application);
		
		PaginationManager manager = springContainer.getBean(PaginationManager.class);
		
		PaginationRenderer renderer = manager.rendererType(type);
		
		JspWriter out = pageContext.getOut();
		
		try {
			out.println(renderer.renderPagination(pagingVO));
			return EVAL_PAGE;
		} catch (IOException e) {
			throw new JspException(e);
		}
	}
}
