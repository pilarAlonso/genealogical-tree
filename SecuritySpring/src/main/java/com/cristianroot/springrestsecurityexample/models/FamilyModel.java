package com.cristianroot.springrestsecurityexample.models;

import com.cristianroot.springrestsecurityexample.entities.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FamilyModel {
	private Long id;
	private String name;
	private String surname;
	private int age;
	private String country;
	private List<FamilyModel>sonModelList=new ArrayList<>();

	public List<FamilyModel> getSonModelList() {
		return sonModelList;
	}

	public static FamilyModel from(Person person) {
		FamilyModel familyModel = new FamilyModel();
		familyModel.setName(person.getName());
		familyModel.setAge(person.getAge());
		familyModel.setId(person.getId());
		familyModel.setCountry(person.getCountry());
		familyModel.setSurname(person.getSurname());
		familyModel.setSonModelList(person.getSons().stream().map(FamilyModel::from).collect(Collectors.toList()));

		return familyModel;
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

	public void setSonModelList(List<FamilyModel> sonModelList) {
		this.sonModelList = sonModelList;
	}

}
