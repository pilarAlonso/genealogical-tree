/******************************************************************************
 * Copyright (c) 2019. Cristian Gonzalez Morante                              *
 ******************************************************************************/

package com.cristianroot.springrestsecurityexample.services;

import com.cristianroot.springrestsecurityexample.exceptions.DuplicatedEntityException;
import com.cristianroot.springrestsecurityexample.exceptions.EntityNotFoundException;
import com.cristianroot.springrestsecurityexample.exceptions.IdRequiredException;
import com.cristianroot.springrestsecurityexample.exceptions.IllegalOperationException;
import com.cristianroot.springrestsecurityexample.models.FamilyModel;
import com.cristianroot.springrestsecurityexample.models.PersonModel;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface PersonService {

	List<FamilyModel> findAll();

	FamilyModel findOne(long id) throws EntityNotFoundException;

	PersonModel save(PersonModel personModel) throws DuplicatedEntityException, EntityNotFoundException;

	PersonModel update(long id, PersonModel personModel) throws EntityNotFoundException, DuplicatedEntityException, IdRequiredException, IllegalOperationException;

	void delete(long id) throws EntityNotFoundException;

}
