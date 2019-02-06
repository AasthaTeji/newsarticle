package com.cts.newsarticle.test.mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cts.newsarticle.AuthenticationStatus;
import com.cts.newsarticle.Repository.UserRepository;
import com.cts.newsarticle.bean.SignupStatus;
import com.cts.newsarticle.bean.User;
import com.cts.newsarticle.service.UserService;

import junit.framework.Assert;





public class UserServiceMockTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceMockTest.class);
	
	@Mock
	private UserRepository userRepository ;

	@InjectMocks
	private UserService userService;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void signUpNewUser() {
		LOGGER.info("START : Inside Unit Testing addUser() method of UserServiceTest");
		User user = new User();
		user.setEmail("aastha@gmail.com");
		LOGGER.debug("User Object :  {}", user);
		when(userRepository.findUserByEmail(user.getEmail())).thenReturn(null);

		SignupStatus expectedStatus = new SignupStatus(true, false);
		SignupStatus actualStatus = userService.signup(user);

		LOGGER.debug("Expected  Output :  {}", expectedStatus);
		LOGGER.debug("Actual  Output :  {}", actualStatus);
		assertEquals(true,expectedStatus.equals(actualStatus));
		LOGGER.info("End : Unit Testing addUser() method of UserServiceTest");
	}
	
	@Test
	public void signUpIncorrectEmail() {
		LOGGER.info("START : Inside Unit Testing addUser() method of UserServiceTest");
		User user = new User();
		user.setEmail("aastha@gmail.com");
		LOGGER.debug("User Object :  {}", user);
		when(userRepository.findUserByEmail(user.getEmail())).thenReturn(null);

		SignupStatus expectedStatus = new SignupStatus(true, false);
		SignupStatus actualStatus = userService.signup(user);

		LOGGER.debug("Expected  Output :  {}", expectedStatus);
		LOGGER.debug("Actual  Output :  {}", actualStatus);
		assertEquals(true,expectedStatus.equals(actualStatus));
		LOGGER.info("End : Unit Testing addUser() method of UserServiceTest");
	}

	@Test
	public void loginSuccessfully() {
		LOGGER.info("START : Inside Unit Testing addUser() method of UserServiceTest");
		User user = new User();
		user.setEmail("aastha@gmail.com");
		user.setPassword("1234567");
		LOGGER.debug("User Object :  {}", user);
		
		
		when(userRepository.findUserByEmail(user.getEmail())).thenReturn(user);
		AuthenticationStatus status = new AuthenticationStatus(true);
		status.setUser(user);
		AuthenticationStatus expectedStatus = userService.authenticationStatus(user);
		
		
		assertEquals( true,expectedStatus.equals(status));
		
		LOGGER.info("End : Unit Testing addUser() method of UserServiceTest");
	}


}
