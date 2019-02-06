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
public class ArticleMockMvcTest {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ArticleMockMvcTest.class);
		
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
		public void testSaveArticle() throws Exception {
			LOGGER.info("Start");
			String ARTICLE_DATA ="{\"title\":\" How ancient DNA may rewrite prehistory in India\"," +
						"\"url\":\"https://www.bbc.co.uk/news/world-asia-india-46616574\"," +
						"\"email\":\"aastha@gmail.com\"}";				
			mockMvc.perform(post("/save").content(ARTICLE_DATA).contentType("application/json;charset=UTF-8"))
					.andExpect(status().isOk())
					.andExpect(jsonPath("$.articleExists").value("true"))
					.andExpect(jsonPath("$.articleSaved").value("false"))
					.andExpect(jsonPath("$.articleSetFav").value("true"));
				
					
			LOGGER.info("end");
		}

}
