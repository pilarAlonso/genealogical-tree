/******************************************************************************
 * Copyright (c) 2019. Cristian Gonzalez Morante                              *
 ******************************************************************************/

package com.cristianroot.springrestsecurityexample.entities;

import com.cristianroot.springrestsecurityexample.constants.AuthorityName;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Authority {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(unique = true)
	private AuthorityName name;

	@ManyToMany(mappedBy = "authorities")
	private List<UserApp> userApp;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public AuthorityName getName() {
		return name;
	}

	public void setName(AuthorityName name) {
		this.name = name;
	}

	public List<UserApp> getPeople() {
		return userApp;
	}

	public void setPeople(List<UserApp> people) {
		this.userApp = people;
	}
}
