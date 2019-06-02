package com.cristianroot.springrestsecurityexample.Person;

import com.cristianroot.springrestsecurityexample.models.PersonModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class findOne {
	@Autowired

	private TestRestTemplate testRestTemplate;

	public findOne() {
	}

	@Test

	public void givenValidTerm_shouldSuccessWith200AndReturnObject() {
		UriComponents url = UriComponentsBuilder.newInstance().scheme("/people").path("/1").build();

		ResponseEntity<PersonModel> result =

				testRestTemplate.exchange("/people/1",

										  HttpMethod.GET,

										  new HttpEntity<>(new HttpHeaders()),

										  new ParameterizedTypeReference<PersonModel>() {
										  });

		assertEquals(HttpStatus.OK, result.getStatusCode());

		assertNotNull(result.getBody());

	}

}


