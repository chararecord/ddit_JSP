package kr.or.ddit.member.service;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.springframework.security.crypto.password.PasswordEncoder;

import kr.or.ddit.AbstractTestCase;
import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.login.service.AuthenticateService;
import kr.or.ddit.member.dao.MemberDAO;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.PagingVO;
import lombok.extern.slf4j.Slf4j;

// Mock request

@Slf4j
public class MemberServiceImplTest extends AbstractTestCase {

	@Inject
	private MemberService service;
	@Inject
	private MemberDAO memberDAO;
	@Inject
	private AuthenticateService authService;
	@Inject
	private PasswordEncoder encoder;
	
	private MemberVO member;
	private PagingVO<MemberVO> pagingVO;
	
	@Before
	public void setUp() throws Exception {
		member = new MemberVO();
		member.setMemId("test777");
		member.setMemPass("java");
		member.setMemName("한테스트");
		member.setMemBir("2023-01-12");
		member.setMemZip("1");
		member.setMemAdd1("1");
		member.setMemAdd2("1");
	}
	
	@Test
	public void init() {
		
	}
	
	@Test
	public void createMemberTest() {
		int result = memberDAO.insertMember(member);
		log.info("결과 : ", result);
	}
	
	@Test
	public void retrieveMemberListTest() {
		pagingVO.setCurrentPage(1);
		pagingVO.setTotalRecord(memberDAO.selectTotalRecord(pagingVO));
		List<MemberVO> memList = memberDAO.selectMemberList(pagingVO);
		log.info("memList : {}", memList);
	}

}
