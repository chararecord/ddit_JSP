package kr.or.ddit.ui;

import java.util.Map;

public class DefaultPaginationManager implements PaginationManager {
	
	private Map<String, PaginationRenderer> rendererMap;
	
	// 기본 생성자 사라지고 반드시 map을 넣어야 생성자 사용 가능ㅎ
	public DefaultPaginationManager(Map<String, PaginationRenderer> rendererMap) {
		super();
		this.rendererMap = rendererMap;
	}

	@Override
	public PaginationRenderer rendererType(String type) {
		PaginationRenderer renderer = rendererMap.get(type);
		if(renderer==null) {
			renderer = new DefaultPaginationRenderer();
		}
		return renderer;
	}

}
