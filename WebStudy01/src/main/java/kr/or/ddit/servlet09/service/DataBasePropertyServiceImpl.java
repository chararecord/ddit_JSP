package kr.or.ddit.servlet09.service;

import java.util.List;

import kr.or.ddit.servlet09.dao.DataBasePropertyDAO;
import kr.or.ddit.servlet09.dao.DataBasePropertyDAOImpl;
import kr.or.ddit.vo.DataBasePropertyVO;

// interface에 의존관계를 갖고 있고, 그 시그니처를 따라가고 있기 때문에 new 뒤에 아무거나 와도 되는 것
public class DataBasePropertyServiceImpl implements DataBasePropertyService {
	private DataBasePropertyDAO dao = new DataBasePropertyDAOImpl();

	@Override
	public List<DataBasePropertyVO> retrievePropertyList(String propertyName) {
		List<DataBasePropertyVO> list = dao.selectPropertyList(propertyName);
		
		// 많은 것들을 할 수 있다.
		list.stream()
//			메소드 레퍼런스 구조 : 한 줄의 파라미터로 어떤 걸 쓰겠다만 넘겨줌(함수지향적 프로그래밍의 대표적인 케이스)
//			.forEach(vo->System.out.println(vo)); 
			.forEach(System.out::println);
		return list;
	}

}
