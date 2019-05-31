package com.cristianroot.springrestsecurityexample.models;

import com.cristianroot.springrestsecurityexample.entities.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FatherModel {
	private Long id;
	private String name;
	private String surname;
	private int age;
	private String country;
	private List<FatherModel> sonModelList = new ArrayList<>();

	public List<FatherModel> getSonModelList() {
		return sonModelList;
	}

	public static FatherModel from(Person person) {
		FatherModel fatherModel = new FatherModel();
		fatherModel.setName(person.getName());
		fatherModel.setAge(person.getAge());
		fatherModel.setId(person.getId());
		fatherModel.setCountry(person.getCountry());
		fatherModel.setSurname(person.getSurname());
		fatherModel.setSonModelList(person.getSons().stream().map(FatherModel::from).collect(Collectors.toList()));

		return fatherModel;
	}

	public Long getId() {
		return id;
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

	public void setSonModelList(List<FatherModel> sonModelList) {
		this.sonModelList = sonModelList;
	}

}
