package com.cristianroot.springrestsecurityexample.Person;

import com.cristianroot.springrestsecurityexample.entities.Person;
import com.cristianroot.springrestsecurityexample.repositories.PersonRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//no funciona
public class create {
	@Autowired
	PersonRepository personRepository;

	@Autowired

	private TestRestTemplate testRestTemplate;

	public create() {
	}

	@Test

	public void givenValidTerm_shouldSuccessWith200AndReturnCreatedPerson() {
		//testRestTemplate.withBasicAuth("user","password");
		UriComponents url = UriComponentsBuilder.newInstance().scheme("/people").build();
		Person personModel = new Person();
		personModel.setFather(null);
		personModel.setSons(null);
		personModel.setName("francisco");
		personModel.setSurname("alvarez");
		personModel.setCountry("spain");

		ResponseEntity<Person> result =

				testRestTemplate.exchange("/people",

										  HttpMethod.POST,

										  new HttpEntity<Person>(new HttpHeaders()),

										  new ParameterizedTypeReference<Person>() {
										  });

		assertEquals(HttpStatus.CREATED, result.getStatusCode());
		assertNotNull(result.getBody());

	}
}




