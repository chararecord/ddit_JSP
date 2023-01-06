package kr.or.ddit.security;

import org.junit.Test;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PasswordEncoderTest {
	
	PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

	String password = "java";
	String mem_pass = "{bcrypt}$2a$10$Pn4HIB.YN4EL.GtxZydxF.5XsfInYsdXKeAa8.mlixpIVFzBQPGV.";
	
	public void encodeTest() {
		String encoded = encoder.encode(password); // DB에 넣기만 하면 됨
		log.info("mem_pass : {}", encoded);
	}
	
	@Test
	public void matchTest() {
		String encoded = encoder.encode(password); // DB에 넣기만 하면 됨
		log.info("match result : {}", encoder.matches(password, mem_pass));
	}
}
