package com.cristianroot.springrestsecurityexample.models;

import com.cristianroot.springrestsecurityexample.entities.Person;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
//revisar

public class PersonModel {

	private Long id;
	@NotNull
	private String name;
	@NotNull
	private String surname;
	@NotNull
	private int age;
	@NotNull
	private String country;
	private long fatherModel;
	@JsonProperty
	private List<PersonModel> sonList = new ArrayList<>();

	public static PersonModel from(Person person) {
		PersonModel personModel = new PersonModel();
		personModel.setName(person.getName());
		personModel.setAge(person.getAge());
		personModel.setId(person.getId());
		personModel.setCountry(person.getCountry());
		personModel.setSurname(person.getSurname());
		if (person.getFather() != null) personModel.setFatherModel(person.getFather().getId());
		if (!person.getSons().isEmpty()) personModel.setSonList(person.getSons().stream().map(PersonModel::from).collect(Collectors.toList()));

		return personModel;
	}

	public long getFatherModel() {
		return fatherModel;
	}

	public void setFatherModel(long fatherModel) {
		this.fatherModel = fatherModel;
	}

	public void addSon(PersonModel personModel) {
		sonList.add(personModel);
	}

	public List<PersonModel> getSonList() {
		return sonList;
	}

	public void setSonList(List<PersonModel> sonList) {
		this.sonList = sonList;
	}

	public Optional<Long> getId() {
		return Optional.ofNullable(id);
	}

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

}
