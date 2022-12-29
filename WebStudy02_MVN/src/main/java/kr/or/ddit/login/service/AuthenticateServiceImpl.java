package kr.or.ddit.login.service;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.exception.UserNotFoundException;
import kr.or.ddit.member.dao.MemberDAO;
import kr.or.ddit.member.dao.MemberDAOImpl;
import kr.or.ddit.vo.MemberVO;

public class AuthenticateServiceImpl implements AuthenticateService {
	private MemberDAO memberDAO = new MemberDAOImpl();

	@Override
	public ServiceResult authenticate(MemberVO member) {
		MemberVO savedMember = memberDAO.selectMember(member.getMemId());
		if(savedMember==null || savedMember.isMemDelete()) { // null 이거나 true면, mybatis가 숫자 1을 true로 바꿔서 넣어줌 - 소문자 boolean으로 바꿔면 isMemDelete
			throw new UserNotFoundException(String.format("%s 사용자 없습니다.",  member.getMemId()));
		}
		String inputPass = member.getMemPass();
		String savedPass = savedMember.getMemPass();
		ServiceResult result =   null;
		if(savedPass.equals(inputPass)) {
			try {
				BeanUtils.copyProperties(member, savedMember);
				result = ServiceResult.OK;
			} catch (IllegalAccessException | InvocationTargetException e) {
				throw new RuntimeException(e);
			}
		} else {
			result = ServiceResult.INVALIDPASSWORD;
		}
		return result;
	}
}
