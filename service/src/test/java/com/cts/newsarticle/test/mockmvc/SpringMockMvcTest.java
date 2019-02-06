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
		String EMPLOYEE_REQUEST ="{\"name\":\"Aastha Teji\"," + "\"email\":\"aastha@gmail.com\","
				+ "\"password\":\"A123456\"," + "\"language\":{\"id\":\"1\"},"
				+ "\"role\":{\"id\":2}}";
		mockMvc.perform(post("/signup").content(EMPLOYEE_REQUEST).contentType("application/json;charset=UTF-8"))
				.andExpect(status().is2xxSuccessful())
				.andExpect(jsonPath("$.signupStatus").value("true"))
				.andExpect(jsonPath("$.emailExist").value("false"));
				
		LOGGER.info("end");
	}
	
	@Test
	public void testNameIsNull() throws Exception {
		LOGGER.info("Start");
	
		String EMPLOYEE_REQUEST = "{\"email\":\"aastha@gmail.com\"," + "\"password\":\"A123456\"," +
							"\"language\":{\"id\":\"1\"}," + "\"role\":{\"id\":2}}";
		mockMvc.perform(post("/signup").content(EMPLOYEE_REQUEST).contentType("application/json;charset=UTF-8"))
				.andExpect(status().is4xxClientError())
				.andExpect(jsonPath("$.errorMessage").value("Input validation failed: User Name cannot be empty"));
		LOGGER.info("end");
		
	}
	
	@Test
	public void testPasswordIsNull() throws Exception {
		LOGGER.info("Start");

		String EMPLOYEE_REQUEST = "{\"name\":\"Aastha\"," + "\"email\":\"aastha@gmail.com\","
				 + "\"language\":{\"id\":\"1\"},"  + "\"role\":{\"id\":2}}";
		mockMvc.perform(post("/signup").content(EMPLOYEE_REQUEST).contentType("application/json;charset=UTF-8"))
				.andExpect(status().is4xxClientError())
				.andExpect(jsonPath("$.errorMessage").value("Input validation failed: Password cannot be empty"));
		LOGGER.info("end");
	}
	
	@Test
	public void testEmailIsNull() throws Exception {
		LOGGER.info("Start");
		
		String EMPLOYEE_REQUEST = "{\"name\":\"Aastha\"," + "\"password\":\"A123456\"," + "\"language\":{\"id\":\"1\"},"
				+ "\"role\":{\"id\":2}}";
		mockMvc.perform(post("/signup").content(EMPLOYEE_REQUEST).contentType("application/json;charset=UTF-8"))
				.andExpect(status().is4xxClientError())
				.andExpect(jsonPath("$.errorMessage").value("Input validation failed: Email cannot be empty"));
		LOGGER.info("end");

	}
	
	@Test
	public void testCheckEmailPattern() throws Exception {
		LOGGER.info("Start");
		
		String EMPLOYEE_REQUEST = "{\"name\":\"Aastha\"," + "\"email\":\"mail.com\","
				+ "\"password\":\"A123456\"," + "\"language\":{\"id\":\"1\"},"
				+ "\"role\":{\"id\":2}}";
		mockMvc.perform(post("/signup").content(EMPLOYEE_REQUEST).contentType("application/json;charset=UTF-8"))
				.andExpect(status().is4xxClientError())
				.andExpect(jsonPath("$.errorMessage").value("Input validation failed: Email address is invalid"));
		LOGGER.info("end");

	}
	
	@Test
	public void testPasswordSize() throws Exception {
		LOGGER.info("Start");
		
		String EMPLOYEE_REQUEST ="{\"name\":\" Aastha\"," + "\"email\":\"aast@gmail.com\","
				+ "\"password\":\"67\"," + "\"language\":{\"id\":\"1\"}," + "\"role\":{\"id\":2}}";
		mockMvc.perform(post("/signup").content(EMPLOYEE_REQUEST).contentType("application/json;charset=UTF-8"))
				.andExpect(status().is4xxClientError())
				.andExpect(jsonPath("$.errorMessage").value("Input validation failed: Password must be 6 to 15 characters"));
		LOGGER.info("end");

	}
	
	@Test
	public void testForExistingEmailSignup() throws Exception {
		LOGGER.info("Start");
		String testData ="{\"name\":\"Aastha\"," + "\"email\":\"saikat@gmail.com\"," + "\"password\":\"A123456\"," + 
					"\"language\":{\"id\":\"1\"}," + "\"role\":{\"id\":2}}";
		LOGGER.debug("Test Data -> {}", testData);
		mockMvc.perform(post("/signup").content(testData).contentType("application/json;charset=UTF-8"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.signupStatus").value("false"))
				.andExpect(jsonPath("$.emailExist").value("true"));
				
	}
	
	@Test
	public void testForLogin() throws Exception {
		LOGGER.info("Start");
		String testData ="{\"email\":\"kiran@gmail.com\"," + "\"password\":\"A123456\"}";
		LOGGER.debug("Test Data -> {}", testData);
		mockMvc.perform(post("/login").content(testData).contentType("application/json;charset=UTF-8"))
				.andExpect(status().is2xxSuccessful())
				.andExpect(jsonPath("$.authentication").value("true"));
				
				
	}
	
	@Test
	public void testCorrectEmailLogin() throws Exception {
		LOGGER.info("Start");
		String testData ="{\"email\":\"aa@gmail.com\"," + "\"password\":\"A123456\"}";
		LOGGER.debug("Test Data -> {}", testData);
		mockMvc.perform(post("/login").content(testData).contentType("application/json;charset=UTF-8"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.authentication").value("false"));
		}
	
	@Test
	public void testCorrectPasswordLogin() throws Exception {
		LOGGER.info("Start");
		String testData ="{\"email\":\"kiran@gmail.com\"," + "\"password\":\"A9999956\"}";
		LOGGER.debug("Test Data -> {}", testData);
		mockMvc.perform(post("/login").content(testData).contentType("application/json;charset=UTF-8"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.authentication").value("false"));
				
				
	}
	
	

}
