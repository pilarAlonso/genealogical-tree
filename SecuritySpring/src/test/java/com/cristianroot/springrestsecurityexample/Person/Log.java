package com.cristianroot.springrestsecurityexample.Person;

import com.cristianroot.springrestsecurityexample.controllers.AuthenticationController;
import com.cristianroot.springrestsecurityexample.entities.Person;
import com.cristianroot.springrestsecurityexample.entities.UserApp;
import com.cristianroot.springrestsecurityexample.models.AuthenticationRequest;
import com.cristianroot.springrestsecurityexample.models.AuthenticationResponse;
import com.cristianroot.springrestsecurityexample.repositories.PersonRepository;
import com.cristianroot.springrestsecurityexample.repositories.UserAppRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class Log {
	@Autowired
	AuthenticationController authenticationController;
	@Autowired
	UserAppRepository userAppRepository;
	@Autowired

	private TestRestTemplate testRestTemplate;

	public Log() {
	}

	@Test
//no funciona
	public void givenValidTerm_shouldSuccessWith200AndReturnToken() {
		AuthenticationRequest request=new AuthenticationRequest();
		request.setPassword("Pilar");
		request.setUsername("234");
		AuthenticationResponse response=authenticationController.getToken(request);
		HttpHeaders httpHeaders=new HttpHeaders();
		httpHeaders.set("Auth",response.getToken());

		ResponseEntity<String> token =

				testRestTemplate.exchange("/auth/login",

										  HttpMethod.POST,

										  new HttpEntity<>(new HttpHeaders()),

										  new ParameterizedTypeReference<String>() {
										  });


		assertEquals(HttpStatus.OK, token.getStatusCode());



	}

}


