/******************************************************************************
 * Copyright (c) 2019. Cristian Gonzalez Morante                              *
 ******************************************************************************/

package com.cristianroot.springrestsecurityexample.services.impl;

import com.cristianroot.springrestsecurityexample.repositories.UserAppRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsServiceImpl implements UserDetailsService {

	private final UserAppRepository userAppRepository;

	public CustomUserDetailsServiceImpl(UserAppRepository userAppRepository) {
		this.userAppRepository = userAppRepository;

	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return userAppRepository.findByNameIgnoreCase(username).orElseThrow(() -> new UsernameNotFoundException(String.format("No user found with username '%s'.", username)));
	}

}
