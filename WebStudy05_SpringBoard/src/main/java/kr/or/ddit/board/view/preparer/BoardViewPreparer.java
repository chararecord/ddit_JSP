package kr.or.ddit.board.view.preparer;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.tiles.AttributeContext;
import org.apache.tiles.preparer.ViewPreparer;
import org.apache.tiles.request.Request;

import kr.or.ddit.vo.MenuVO;

public class BoardViewPreparer implements ViewPreparer {
	
//	@Inject
//	private MenuDAO dao;

	@Override
	public void execute(Request req, AttributeContext attrContext) {
//		게시글 작성 : /board/boardInsert.do
//		게시글 목록조회 : /board/boardList.do
		MenuVO menu1 = new MenuVO("게시글 작성", "/board/boardInsert.do");
		MenuVO menu2 = new MenuVO("게시글 목록조회", "/board/boardList.do");
		List<MenuVO> menuList = Arrays.asList(menu1, menu2);
		// scope -> 4개의 기본 객체가 가지고 있는 map을 의미한다
		Map<String, Object> scope = req.getContext(Request.REQUEST_SCOPE);
		scope.put("menuList", menuList);
	}
}
