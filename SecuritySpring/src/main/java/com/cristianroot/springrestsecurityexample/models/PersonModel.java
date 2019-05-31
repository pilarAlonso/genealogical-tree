package com.cristianroot.springrestsecurityexample.models;

import com.cristianroot.springrestsecurityexample.entities.Person;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PersonModel {


	private Long id;
	@NotNull
	private String name;
	@NotNull
	private String surname;
	private int age;
	private String country;
	private Person father;

	public static PersonModel from(Person person) {
		PersonModel personModel = new PersonModel();
		personModel.setName(person.getName());
		personModel.setAge(person.getAge());
		personModel.setId(person.getId());
		personModel.setCountry(person.getCountry());
		personModel.setSurname(person.getSurname());

		return personModel;
	}

	public Optional<Long> getId() { return Optional.ofNullable(id); }

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Person getFather() {
		return father;
	}

	public void setFather(Person father) {
		this.father = father;
	}


}
