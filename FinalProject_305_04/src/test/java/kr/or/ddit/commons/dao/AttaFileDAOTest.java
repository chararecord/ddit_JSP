package kr.or.ddit.commons.dao;

import java.util.Collections;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;

import kr.or.ddit.commons.AbstractTestCase;
import kr.or.ddit.vo.AttaFileVO;
import kr.or.ddit.vo.NoticeVO;

public class AttaFileDAOTest extends AbstractTestCase {

	@Inject
	public AttaFileDAO dao;
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testInsertAttaFiles() {
		NoticeVO vo = new NoticeVO();
		vo.setNotiId("1234");
		vo.setAttaFileList(Collections.singletonList(new AttaFileVO()));
		dao.insertAttaFiles(vo);
	}
}
