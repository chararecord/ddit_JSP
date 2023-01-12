package kr.or.ddit.member.service;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.exception.UserNotFoundException;
import kr.or.ddit.login.service.AuthenticateService;
import kr.or.ddit.member.dao.MemberDAO;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.PagingVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MemberServiceImpl implements MemberService {
	// 싱글톤 안 쓰고 진행할 예정, 차후에 singleton을 spring framework 사용해 대신 구현할 예정
	// 결합력 최상
	@Inject
	private MemberDAO memberDAO;
	// 인증과 관련된 모든 로직
	@Inject
	private AuthenticateService authService;
	@Inject
	private PasswordEncoder encoder;
	
	@PostConstruct
	public void init() {
		log.info("주입된 객체 : {}, {}, {}", memberDAO, authService, encoder);
	}

	@Override
	public ServiceResult createMember(MemberVO member) {
		ServiceResult result = null;
		log.info("member속 아이디 꺼내오기 : {}", member.getMemId());
		try {
			retrieveMember(member.getMemId());
			result = ServiceResult.PKDUPLICATED;
		} catch (UserNotFoundException e) {
			String encoded = encoder.encode(member.getMemPass());
			member.setMemPass(encoded);
			int rowcnt = memberDAO.insertMember(member);
			result = rowcnt > 0 ? ServiceResult.OK : ServiceResult.FAIL;
		}
		
		return result;
	}

	@Override
	public List<MemberVO> retrieveMemberList(PagingVO<MemberVO> pagingVO) {
		pagingVO.setTotalRecord(memberDAO.selectTotalRecord(pagingVO));
		List<MemberVO> list = memberDAO.selectMemberList(pagingVO);
		pagingVO.setDataList(list);
		return list;
	}

	@Override
	public MemberVO retrieveMember(String memId) {
		MemberVO member = memberDAO.selectMember(memId);
		if(member==null) {
			throw new UserNotFoundException(String.format(memId+"에 해당하는 사용자가 존재하지 않습니다."));
		}
		return member;
	}

	@Override
	public ServiceResult modifyMember(MemberVO member) {
		MemberVO inputData = new MemberVO();
		inputData.setMemId(member.getMemId());
		inputData.setMemPass(member.getMemPass());
		
		ServiceResult result = authService.authenticate(inputData); // 인증과 관련된 모든 책임은 authenticate가 가짐
		if(ServiceResult.OK.equals(result)) {
			int rowcnt = memberDAO.updateMember(member);
			result = rowcnt > 0 ? ServiceResult.OK : ServiceResult.FAIL;
		}
		return result;
	}

	@Override
	public ServiceResult removeMember(MemberVO member) {
		ServiceResult result = authService.authenticate(member);
		if(ServiceResult.OK.equals(result)) {
			int rowcnt = memberDAO.deleteMember(member.getMemId());
			result = rowcnt > 0 ? ServiceResult.OK : ServiceResult.FAIL;
		}
		return result;
	}
}
