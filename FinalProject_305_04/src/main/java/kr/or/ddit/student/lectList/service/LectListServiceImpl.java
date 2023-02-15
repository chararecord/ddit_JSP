package kr.or.ddit.student.lectList.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ddit.student.lectList.dao.LectListDAO;
import kr.or.ddit.vo.MyLectureVO;
import kr.or.ddit.vo.MyStudentVO;

@Service
public class LectListServiceImpl implements LectListService {
	@Autowired
	LectListDAO lectListDAO;
	
	@Override
	public List<MyStudentVO> retrieveLectList(int stdId, String semeId) {
		// TODO Auto-generated method stub
		return this.lectListDAO.selectLectList(stdId, semeId);
	}

}
