/******************************************************************************
 * Copyright (c) 2019. Cristian Gonzalez Morante                              *
 ******************************************************************************/

package com.cristianroot.springrestsecurityexample.services;

import com.cristianroot.springrestsecurityexample.exceptions.EntityNotFoundException;
import com.cristianroot.springrestsecurityexample.models.PersonModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PersonService {

	List<PersonModel> findAll();

	PersonModel findOne(long id) throws EntityNotFoundException;

	PersonModel save(PersonModel personModel) throws Exception;

	PersonModel update(long id, PersonModel personModel) throws Exception;

	void delete(long id) throws EntityNotFoundException;

}
