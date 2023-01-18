package kr.or.ddit.member.controller;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@ContextHierarchy({
	// 들어가 있는 context 그대로 계층 구조가 됨
	@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/*-context.xml") // dao, service만 존재
	, @ContextConfiguration("file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml")
})
@WebAppConfiguration
public class MemberListControllerTest {
	
	@Inject
	private WebApplicationContext context;
	
	// 웹 용 테스트 객체
	private MockMvc mockMvc;

	@Before
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	@Test
	public void testMemberList() throws Exception {
		mockMvc.perform(get("/member/memberList.do").param("page", "2"))
				.andExpect(status().isOk())
				.andExpect(model().attributeExists("pagingVO")) // 이 이름의 모델이 있으면~
				.andExpect(view().name("member/memberList"))
				.andDo(log());
	}
}
