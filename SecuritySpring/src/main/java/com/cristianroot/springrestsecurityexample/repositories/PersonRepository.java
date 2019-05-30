/******************************************************************************
 * Copyright (c) 2019. Cristian Gonzalez Morante                              *
 ******************************************************************************/

package com.cristianroot.springrestsecurityexample.repositories;

import com.cristianroot.springrestsecurityexample.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface PersonRepository extends JpaRepository<User, Long> {

	Optional<User> findByNameIgnoreCase(String name);

}