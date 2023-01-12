package kr.or.ddit.member.controller;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@ContextHierarchy({
	// 들어가 있는 context 그대로 계층 구조가 됨
	@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/*-context.xml") // dao, service만 존재
	, @ContextConfiguration("file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml")
})
@WebAppConfiguration
public class MemberViewControllerTest {
	
	private MockMvc mockMvc;

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testMemberView() throws Exception {
		mockMvc.perform(get(""))
				.andExpect(status().isOk())
				.andDo(log());
	}
// 완성시키슈
}
