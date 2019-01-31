package com.cts.newsarticle.test.mockito;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cts.newsarticle.bean.SignupStatus;
import com.cts.newsarticle.bean.User;
import com.cts.newsarticle.controller.UserController;
import com.cts.newsarticle.service.UserService;


public class ControllerMockitoTest {
private static final Logger LOGGER = LoggerFactory.getLogger(ControllerMockitoTest.class);
	
	@Mock
	private UserService userService;

	@InjectMocks
	private UserController userController;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testSignupUserSuccessful(){
		
		User user=new User();
		user.setEmail("aastha@gmail.com");
		
		SignupStatus expectedStatus=new SignupStatus(true,false);
		
		Mockito.when(userService.signup(user)).thenReturn(expectedStatus);
		
		SignupStatus status=userController.signup(user);
		assertEquals(true,expectedStatus.equals(status));
		
	}

	
}
