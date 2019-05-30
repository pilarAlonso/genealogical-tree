/******************************************************************************
 * Copyright (c) 2019. Cristian Gonzalez Morante                              *
 ******************************************************************************/

package com.cristianroot.springrestsecurityexample.services.impl;

import com.cristianroot.springrestsecurityexample.repositories.PersonRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
//indiar de que repositorio quiero sacar lo datos del ususaario implementa userdetails.
@Service
public class CustomUserDetailsServiceImpl implements UserDetailsService {

	private final PersonRepository personRepository;

	public CustomUserDetailsServiceImpl(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return personRepository.findByNameIgnoreCase(username).orElseThrow(() -> new UsernameNotFoundException(String.format("No user found with username '%s'.", username)));
	}

}
