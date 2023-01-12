package kr.or.ddit.prod.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.prod.dao.ProdDAO;
import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.ProdVO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ProdServiceImpl implements ProdService {
	private final ProdDAO prodDAO;

	// save folder를 잡기 위한 설정
	@Inject
	private WebApplicationContext context;
	private File saveFolder;
	
	@PostConstruct
	public void init() throws IOException {
		String saveFolderURL = "/resources/prodImages"; // 저장경로와 관련된 건 properties 파일로 빼놓고 관리하는 게 좋음
//			ServletContext application = 
//					req.getServletContext();
//			String saveFolderPath = application.getRealPath(saveFolderURL);
		Resource saveFolderRes = context.getResource(saveFolderURL);
		saveFolder = saveFolderRes.getFile(); // 물리 주소가 없어도 파일 객체 가져올 수 있음
		if(!saveFolder.exists()) {
			saveFolder.mkdirs();
		}
	}
	
	private void processProdImage(ProdVO prod) {
//		1. 저장
		try {
			if(1==1) throw new RuntimeException("트랜잭션 관리 여부 확인을 위한 강제 발생 예외");
			prod.saveTo(saveFolder);
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
	
	
	@Override
	public ProdVO retrieveProd(String prodId) {
		ProdVO prod = prodDAO.selectProd(prodId);
		if(prod==null) {
			throw new RuntimeException(String.format("%s는 없는 상품", prodId));
		}
		return prod;
	}

	@Override
	public void retrieveProdList(PagingVO<ProdVO> pagingVO) {
		int totalRecord = prodDAO.selectTotalRecord(pagingVO);
		pagingVO.setTotalRecord(totalRecord);
		List<ProdVO> dataList = prodDAO.selectProdList(pagingVO);
		pagingVO.setDataList(dataList);
	}
	
	@Inject
	private SqlSessionFactory sqlSessionFactory;

	@Override
	public ServiceResult createProd(ProdVO prod) {
		try(
//			session open
			SqlSession sqlSession = sqlSessionFactory.openSession(); // 트랜잭션 시작
		){
			int rowcnt = prodDAO.insertProd(prod, sqlSession); // db에는 rollback 개념이 있어서 안되면 rollback 하면 됨
			processProdImage(prod);
			sqlSession.commit();
			return rowcnt > 0 ? ServiceResult.OK : ServiceResult.FAIL;
		}
	}

	@Override
	public ServiceResult modifyProd(ProdVO prod) {
		retrieveProd(prod.getProdId());
		int rowcnt = prodDAO.updateProd(prod);
		processProdImage(prod);
		return rowcnt > 0 ? ServiceResult.OK : ServiceResult.FAIL;
	}
}
