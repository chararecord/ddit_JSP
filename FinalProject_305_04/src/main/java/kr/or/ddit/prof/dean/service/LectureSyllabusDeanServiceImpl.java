package kr.or.ddit.prof.dean.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ddit.prof.dean.dao.LectrueSyllabusDeanDAO;
import kr.or.ddit.vo.SyllabusVO;

@Service
public class LectureSyllabusDeanServiceImpl implements LectureSyllabusDeanService{
	
	@Autowired
	LectrueSyllabusDeanDAO dao;
	
	@Override
	public List<SyllabusVO> retrieveDeanSyllaList() {
		return dao.selectDeanSyllaList();
	}

	@Override
	public SyllabusVO retrieveDeanSylla(SyllabusVO syllaVO) {
		return dao.selectDeanSylla(syllaVO);
	}

}
