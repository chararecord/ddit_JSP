package kr.or.ddit.member.service;

import java.util.List;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.exception.UserNotFoundException;
import kr.or.ddit.member.dao.MemberDAO;
import kr.or.ddit.member.dao.MemberDAOImpl;
import kr.or.ddit.vo.MemberVO;

public class MemberServiceImpl implements MemberService {
	// 싱글톤 안 쓰고 진행할 예정, 차후에 singleton을 spring framework 사용해 대신 구현할 예정
	// 결합력 최상
	private MemberDAO memberDAO = new MemberDAOImpl();

	@Override
	public ServiceResult createMember(MemberVO member) {
		ServiceResult result = null;
		try {
			retrieveMember(member.getMemId());
			result = ServiceResult.PKDUPLICATED;
		} catch (UserNotFoundException e) {
			int rowcnt = memberDAO.insertMember(member);
			result = rowcnt > 0 ? ServiceResult.OK : ServiceResult.FAIL;
		}
		
//		String memId = member.getMemId();
//		ServiceResult result = null;
//		MemberVO memCheck = memberDAO.selectMember(memId);
//		// 이미 가입된 회원의 아이디라면
//		if(memCheck!=null) {
//			result = ServiceResult.PKDUPLICATED;
//		}
//		int cnt = memberDAO.insertMember(member);
//		if(cnt>0) {
//			result = ServiceResult.OK;
//		}
//		result = ServiceResult.FAIL;
		return result;
	}

	@Override
	public List<MemberVO> retrieveMemberList() {
		List<MemberVO> list = memberDAO.selectMemberList();
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ServiceResult removeMember(MemberVO member) {
		// TODO Auto-generated method stub
		return null;
	}

}
