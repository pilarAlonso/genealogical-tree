package com.cristianroot.springrestsecurityexample.Person;

import com.cristianroot.springrestsecurityexample.entities.Person;
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

public class findAll {
	@Autowired

	private TestRestTemplate testRestTemplate;

	public findAll() {
	}

	@Test

	public void givenValidTerm_shouldSuccessWith200AndReturnList() {

		ResponseEntity<List<Person>> result =

				testRestTemplate.exchange("/people",

										  HttpMethod.GET,

										  new HttpEntity<>(new HttpHeaders()),

										  new ParameterizedTypeReference<List<Person>>() {
										  });

		assertEquals(HttpStatus.OK, result.getStatusCode());

		assertNotNull(result.getBody());

	}

}
