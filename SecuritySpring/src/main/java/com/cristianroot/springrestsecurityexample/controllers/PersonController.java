package com.cristianroot.springrestsecurityexample.controllers;

import com.cristianroot.springrestsecurityexample.exceptions.EntityNotFoundException;
import com.cristianroot.springrestsecurityexample.models.PersonModel;
import com.cristianroot.springrestsecurityexample.services.PersonService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class PersonController {
	private final PersonService personService;

	public PersonController(PersonService personService) {
		this.personService = personService;
	}

	@GetMapping("/people")
	public List<PersonModel> findAll() {
		return personService.findAll();
	}

	@GetMapping("/people/{id}")
	public PersonModel findOne(@PathVariable long id) throws EntityNotFoundException {
		return personService.findOne(id);
	}

	@PostMapping("/people")
	public PersonModel save(@Valid @RequestBody PersonModel personModel) throws Exception {
		return personService.save(personModel);
	}

	@PutMapping("/people/{id}")
	public PersonModel update(@PathVariable long id, @RequestBody PersonModel personModel) throws Exception {
		return personService.update(id, personModel);
	}

	@DeleteMapping("/people/{id}")
	public void delete(@PathVariable long id) throws EntityNotFoundException {
		personService.delete(id);
	}
}





