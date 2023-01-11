package kr.or.ddit.login.service;

import java.lang.reflect.InvocationTargetException;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.exception.UserNotFoundException;
import kr.or.ddit.member.dao.MemberDAO;
import kr.or.ddit.member.dao.MemberDAOImpl;
import kr.or.ddit.vo.MemberVO;

@Service
public class AuthenticateServiceImpl implements AuthenticateService {
	
	private MemberDAO memberDAO;

	// 주입받기 위해선 주입을 받을 구멍이 필요하다
	// 기본 생성자 사라짐
	@Inject // 명확하게 얘를 통해서 주입받는 다는 걸 표현하기 위해서 (전제조건 : MemberDAO가 이미 bean으로 등록되어 있어야)
	public AuthenticateServiceImpl(MemberDAO memberDAO) {
		super();
		this.memberDAO = memberDAO;
	}
	
	// 강제로 private -> public 풀어서 reflection으로 주입함
	// 우리가 만든 게 아니라 수동으로 bean 등록해줘야함
	// Inject 대신 Resource 사용 가능
	@Resource(name="passwordEncoder")
	private PasswordEncoder encoder;
	
	@Override
	public ServiceResult authenticate(MemberVO member) {
		MemberVO savedMember = memberDAO.selectMember(member.getMemId());
		if(savedMember==null || savedMember.isMemDelete()) { // null 이거나 true면, mybatis가 숫자 1을 true로 바꿔서 넣어줌 - 소문자 boolean으로 바꿔면 isMemDelete
			throw new UserNotFoundException(String.format("%s 사용자 없습니다.",  member.getMemId()));
		}
		String inputPass = member.getMemPass();
		String savedPass = savedMember.getMemPass();
		ServiceResult result =   null;
		if(encoder.matches(inputPass, savedPass)) {
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
