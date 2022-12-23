package kr.or.ddit.servlet09.service;

import java.util.List;

import kr.or.ddit.vo.DataBasePropertyVO;

public interface DataBasePropertyService {
	// 객체를 사용하는 방법만 정의
	public List<DataBasePropertyVO> retrievePropertyList(String propertyName);
}
