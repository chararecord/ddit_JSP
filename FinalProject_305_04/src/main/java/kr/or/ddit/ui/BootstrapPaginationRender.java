package kr.or.ddit.ui;

import kr.or.ddit.vo.PagingVO;

public class BootstrapPaginationRender implements PaginationRenderer {

	@Override
	public String renderPagination(PagingVO<?> pagingVO) {
		String previousPtrn
			= "<li class='page-item %s'><a class='page-link paging' aria-label='처음' %s data-page='%d'>"
				+ "<span aria-hidden='true'>&laquo;</span><span class='sr-only'>처음</span></a></li>";
		String nextPtrn
			= "<li class='page-item %s'><a class='page-link paging' aria-label='다음' %s data-page='%d'>"
				+ "<span aria-hidden='true'>&gt;</span><span class='sr-only'>다음</span></a></li>";
		
		String pagePtrn
			= "<li class='page-item'><a class='page-link paging' href='#' data-page='%1$d'>%1$d</a></li>";
		String currentPtrn
			= "<li class='page-item active'><a class='page-link paging'>%d</a></li>";
		
		int startPage = pagingVO.getStartPage();
		int blockSize = pagingVO.getBlockSize();
		int endPage = pagingVO.getEndPage();
		int currentPage = pagingVO.getCurrentPage();
		int totalPage = pagingVO.getTotalPage();
		
		StringBuffer html = new StringBuffer();
		html.append("<nav aria-label='...'>");
		html.append("<ul class='pagination'>");
		
		boolean disabled = startPage <= 1;
		html.append(
			String.format(previousPtrn
							, disabled ? "disabled" : ""
							, disabled ? "" : "href='#'"
							, disabled ? 1 : startPage-1
			)
		);
		
		for(int page=startPage; page<=endPage; page++) {
			if(page==currentPage) {
				html.append(
					String.format(currentPtrn, page)
				);
			} else {
				html.append(
					String.format(pagePtrn, page)
				);
			}
		}
		
		disabled = endPage >= totalPage;
		html.append(
			String.format(nextPtrn
							, disabled ? "disabled" : ""
							, disabled ? "" : "href=#"
							, disabled ? totalPage : endPage+1
			)
		);
		
		html.append("</ul>");
		html.append("</nav>");
		
		return html.toString();
	}
}
