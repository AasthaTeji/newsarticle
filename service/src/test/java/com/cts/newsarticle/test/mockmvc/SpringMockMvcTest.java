package com.cts.newsarticle.test.mockmvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringMockMvcTest {

private static final Logger LOGGER = LoggerFactory.getLogger(SpringMockMvcTest.class);
	
	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;
	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	@Test
	public void testUserSignup() throws Exception {
		LOGGER.info("Start");
		String EMPLOYEE_REQUEST = "{\"email\" : \"akash@gmail.com\"" + "," + "\"name\" : \"akash\""
				+ "," + "\"password\" : \"akash1023\"}";
		mockMvc.perform(post("/signup").content(EMPLOYEE_REQUEST).contentType("application/json;charset=UTF-8"))
				.andExpect(status().is2xxSuccessful())
				.andExpect(jsonPath("$.signupStatus").value("true"))
				.andExpect(jsonPath("$.emailExist").value("false"));
				
		LOGGER.info("end");
	}
	
	@Test
	public void testNameIsNull() throws Exception {
		LOGGER.info("Start");
	
		String EMPLOYEE_REQUEST = "{\"email\" : \"aksh@gmail.com\"" + ","  + "\"password\" : \"akash1023\"}";
		mockMvc.perform(post("/signup").content(EMPLOYEE_REQUEST).contentType("application/json;charset=UTF-8"))
				.andExpect(status().is4xxClientError())
				.andExpect(jsonPath("$.errorMessage").value("Input validation failed: User Name cannot be empty"));
		LOGGER.info("end");
		
	}

}
