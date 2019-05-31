/******************************************************************************
 * Copyright (c) 2019. Cristian Gonzalez Morante                              *
 ******************************************************************************/

package com.cristianroot.springrestsecurityexample.services.impl;

import com.cristianroot.springrestsecurityexample.entities.Person;
import com.cristianroot.springrestsecurityexample.exceptions.DuplicatedEntityException;
import com.cristianroot.springrestsecurityexample.exceptions.EntityNotFoundException;
import com.cristianroot.springrestsecurityexample.exceptions.IdRequiredException;
import com.cristianroot.springrestsecurityexample.exceptions.IllegalOperationException;
import com.cristianroot.springrestsecurityexample.models.PersonModel;
import com.cristianroot.springrestsecurityexample.repositories.PersonRepository;
import com.cristianroot.springrestsecurityexample.services.PersonService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonServiceImpl implements PersonService {

	private final PersonRepository personRepository;

	public PersonServiceImpl(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}

	@Override
	public List<PersonModel> findAll() {
		return personRepository.findAll().stream().map(PersonModel::from).collect(Collectors.toList());
	}

	@Override
	public PersonModel findOne(long id) throws EntityNotFoundException {
		return personRepository.findById(id).map(PersonModel::from).orElseThrow(() -> new EntityNotFoundException(Person.class, id));
	}

	@Override
	public PersonModel save(PersonModel personModel) throws DuplicatedEntityException {
		if (personRepository.findById(personModel.getId()).isPresent())
			throw new DuplicatedEntityException();
		Person person = new Person();
		person.setName(personModel.getName());
		person.setSurname(personModel.getSurname());
		person.setAge(personModel.getAge());
		person.setCountry(personModel.getCountry());
		return PersonModel.from(personRepository.save(person));

	}

	@Override
	public PersonModel update(long id, PersonModel personModel) throws EntityNotFoundException, DuplicatedEntityException, IdRequiredException, IllegalOperationException {
		long modelId = personModel.getId().orElseThrow(IdRequiredException::new);
		if (id != modelId) throw new IllegalOperationException("IDs doesn't match");
		Person person = personRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(Person.class, id));
		Optional<Person> duplicatedPerson = personRepository.findByNameIgnoreCase(personModel.getName());
		if (duplicatedPerson.isPresent()) {
			if (duplicatedPerson.get().getId() != person.getId()) {
				throw new DuplicatedEntityException();
			}
		}
		if (personRepository.findByNameIgnoreCase(personModel.getName()).isPresent())
			throw new DuplicatedEntityException();
		person.setName(personModel.getName());
		person.setCountry(personModel.getCountry());
		person.setAge(personModel.getAge());
		person.setSurname(person.getSurname());
		return PersonModel.from(personRepository.save(person));

	}

	@Override
	public void delete(long id) throws EntityNotFoundException {
		Person person = personRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(Person.class, id));
		personRepository.delete(person);

	}
}
