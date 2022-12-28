package kr.or.ddit.member.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import kr.or.ddit.vo.MemberVO;

public class MemberDAOImplTest {
	
	private MemberDAO dao = new MemberDAOImpl();
	private MemberVO member;

	@Before
	public void setUp() throws Exception {
		member = new MemberVO();
		member.setMemId("a002");
		member.setMemPass("java");
		member.setMemName("테스트");
		member.setMemBir("2000-01-01");
		member.setMemZip("00000");
		member.setMemAdd1("주소1");
		member.setMemAdd2("주소2");
	}

	@Test
	public void testInsertMember() {
		dao.insertMember(member);
	}

	@Test
	public void testSelectMemberList() {
		List<MemberVO> memberList = dao.selectMemberList();
		memberList.stream()
				.forEach(System.out::println);
	}

	@Test
	public void testSelectMember() {
		MemberVO member = dao.selectMember("a001");
		System.out.println(member);
		member = dao.selectMember("12134a");
		assertNull(member);
	}

	@Test
	public void testUpdateMember() {
		dao.updateMember(member);
	}

	@Test
	public void testDeleteMember() {
		fail("Not yet implemented");
	}

}