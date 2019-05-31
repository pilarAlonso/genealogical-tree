/******************************************************************************
 * Copyright (c) 2019. Cristian Gonzalez Morante                              *
 ******************************************************************************/

package com.cristianroot.springrestsecurityexample.services;

import com.cristianroot.springrestsecurityexample.exceptions.DuplicatedEntityException;
import com.cristianroot.springrestsecurityexample.exceptions.EntityNotFoundException;
import com.cristianroot.springrestsecurityexample.exceptions.IdRequiredException;
import com.cristianroot.springrestsecurityexample.exceptions.IllegalOperationException;
import com.cristianroot.springrestsecurityexample.models.FatherModel;
import com.cristianroot.springrestsecurityexample.models.SonModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PersonService {

	List<FatherModel> findAll();

	FatherModel findOne(long id) throws EntityNotFoundException;

	SonModel save(SonModel sonModel) throws DuplicatedEntityException, EntityNotFoundException;

	SonModel update(long id, SonModel sonModel) throws EntityNotFoundException, DuplicatedEntityException, IdRequiredException, IllegalOperationException;

	void delete(long id) throws EntityNotFoundException;

}
