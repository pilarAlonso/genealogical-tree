/******************************************************************************
 * Copyright (c) 2019. Cristian Gonzalez Morante                              *
 ******************************************************************************/

package com.cristianroot.springrestsecurityexample.services;

import com.cristianroot.springrestsecurityexample.exceptions.DuplicatedEntityException;
import com.cristianroot.springrestsecurityexample.exceptions.EntityNotFoundException;
import com.cristianroot.springrestsecurityexample.exceptions.IdRequiredException;
import com.cristianroot.springrestsecurityexample.exceptions.IllegalOperationException;
import com.cristianroot.springrestsecurityexample.models.PersonModel;

import java.util.List;

public interface PersonService {

	List<PersonModel> findAll();

	PersonModel findOne(long id) throws EntityNotFoundException;

	PersonModel save(PersonModel personModel) throws DuplicatedEntityException;

	PersonModel update(long id, PersonModel personModel) throws EntityNotFoundException, DuplicatedEntityException, IdRequiredException, IllegalOperationException;

	void delete(long id) throws EntityNotFoundException;

}
