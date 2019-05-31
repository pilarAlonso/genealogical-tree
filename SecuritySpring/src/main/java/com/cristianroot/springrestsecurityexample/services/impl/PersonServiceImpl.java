/******************************************************************************
 * Copyright (c) 2019. Cristian Gonzalez Morante                              *
 ******************************************************************************/

package com.cristianroot.springrestsecurityexample.services.impl;

import com.cristianroot.springrestsecurityexample.entities.Person;
import com.cristianroot.springrestsecurityexample.exceptions.DuplicatedEntityException;
import com.cristianroot.springrestsecurityexample.exceptions.EntityNotFoundException;
import com.cristianroot.springrestsecurityexample.exceptions.IdRequiredException;
import com.cristianroot.springrestsecurityexample.exceptions.IllegalOperationException;
import com.cristianroot.springrestsecurityexample.models.FatherModel;
import com.cristianroot.springrestsecurityexample.models.SonModel;
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
	public List<FatherModel> findAll() {
		return personRepository.findAll().stream().map(FatherModel::from).collect(Collectors.toList());
	}

	@Override
	public FatherModel findOne(long id) throws EntityNotFoundException {
		return personRepository.findById(id).map(FatherModel::from).orElseThrow(() -> new EntityNotFoundException(Person.class, id));
	}
    //añadir excepciones
	@Override
	public SonModel save(SonModel sonModel) throws DuplicatedEntityException, EntityNotFoundException {
		if (personRepository.findById(sonModel.getId()).isPresent()) throw new DuplicatedEntityException();
		long idFather = sonModel.getFather().getId();
		Person person = new Person();
		person.setName(sonModel.getName());
		person.setSurname(sonModel.getSurname());
		person.setAge(sonModel.getAge());
		person.setCountry(sonModel.getCountry());
		person.setFather(personRepository.findById(idFather).orElseThrow(() -> new EntityNotFoundException(Person.class, idFather)));
		return SonModel.from(personRepository.save(person));

	}
    //falla el padre se queda null

	@Override
	public SonModel update(long id, SonModel sonModel) throws EntityNotFoundException, DuplicatedEntityException, IdRequiredException, IllegalOperationException {
		long modelId = sonModel.getId().orElseThrow(IdRequiredException::new);
		if (id != modelId) throw new IllegalOperationException("IDs doesn't match");
		Person person = personRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(Person.class, id));
		Optional<Person> duplicatedPerson = personRepository.findByNameIgnoreCase(sonModel.getName());
		if (duplicatedPerson.isPresent()) {
			if (duplicatedPerson.get().getId() != person.getId()) {
				throw new DuplicatedEntityException();
			}
		}
		if (personRepository.findByNameIgnoreCase(sonModel.getName()).isPresent())
			throw new DuplicatedEntityException();
		person.setName(sonModel.getName());
		person.setCountry(sonModel.getCountry());
		person.setAge(sonModel.getAge());
		person.setSurname(person.getSurname());
		return SonModel.from(personRepository.save(person));

	}

	@Override
	public void delete(long id) throws EntityNotFoundException {
		Person person = personRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(Person.class, id));
		personRepository.delete(person);

	}
}
