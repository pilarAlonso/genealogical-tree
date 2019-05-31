package com.cristianroot.springrestsecurityexample.controllers;

import com.cristianroot.springrestsecurityexample.exceptions.DuplicatedEntityException;
import com.cristianroot.springrestsecurityexample.exceptions.EntityNotFoundException;
import com.cristianroot.springrestsecurityexample.exceptions.IdRequiredException;
import com.cristianroot.springrestsecurityexample.exceptions.IllegalOperationException;
import com.cristianroot.springrestsecurityexample.models.FatherModel;
import com.cristianroot.springrestsecurityexample.models.SonModel;
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
	public List<FatherModel> findAll() {
		return personService.findAll();
	}

	@GetMapping("/people/{id}")
	public FatherModel findOne(@PathVariable long id) throws EntityNotFoundException {
		return personService.findOne(id);
	}

	@PostMapping("/people")
	public SonModel save(@Valid @RequestBody SonModel sonModel) throws DuplicatedEntityException, DuplicatedEntityException, EntityNotFoundException {
		return personService.save(sonModel);
	}

	@PutMapping("/people/{id}")
	public SonModel update(@PathVariable long id, @RequestBody SonModel sonModel) throws DuplicatedEntityException, IllegalOperationException, IdRequiredException, EntityNotFoundException {
		return personService.update(id, sonModel);
	}

	@DeleteMapping("/people/{id}")
	public void delete(@PathVariable long id) throws EntityNotFoundException {
		personService.delete(id);
	}
}





