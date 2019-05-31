/******************************************************************************
 * Copyright (c) 2019. Cristian Gonzalez Morante                              *
 ******************************************************************************/

package com.cristianroot.springrestsecurityexample.services.impl;

import com.cristianroot.springrestsecurityexample.repositories.PersonRepository;
import com.cristianroot.springrestsecurityexample.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsServiceImpl implements UserDetailsService {

	private final UserRepository userRepository;

	public CustomUserDetailsServiceImpl( UserRepository userRepository) {
		this.userRepository = userRepository;

	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return userRepository.findByNameIgnoreCase(username).orElseThrow(() -> new UsernameNotFoundException(String.format("No user found with username '%s'.", username)));
	}

}
