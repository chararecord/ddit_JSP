package kr.or.ddit.student.lectList.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ddit.student.lectList.dao.LectListDAO;
import kr.or.ddit.vo.LectureVO;
import kr.or.ddit.vo.StudentVO;

@Service
public class LectListServiceImpl implements LectListService {
	@Autowired
	LectListDAO lectListDAO;
	
	@Override
	public List<LectureVO> retrieveLectList(int stdId) {
		// TODO Auto-generated method stub
		return this.lectListDAO.selectLectList(stdId);
	}

}
