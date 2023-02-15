package kr.or.ddit.student.record.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.ddit.student.record.dao.RecordDAO;
import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.RecordVO;

@Service
public class RecordServiceImpl implements RecordService {

	@Inject
	private RecordDAO recordDAO;
	
	@Override
	public void retrieveRecordList(PagingVO<RecordVO> pagingVO) {
		pagingVO.setTotalRecord(recordDAO.selectTotalResults(pagingVO));
		pagingVO.setDataList(recordDAO.selectRecordList(pagingVO));
	}

}
