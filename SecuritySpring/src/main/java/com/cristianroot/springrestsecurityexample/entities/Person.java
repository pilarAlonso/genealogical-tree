package com.cristianroot.springrestsecurityexample.entities;

import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
@Entity
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name ;
	private String surname;
	private int age;
	private String country;
	@ManyToOne
	private Person father;
	@OneToMany(mappedBy = "father")
	private List<Person> sons=new ArrayList<>();

	public Person(Person father,long id) {
		this.father = father;
	}

	public Person() {
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

	public Person getFather() {
		return father;
	}

	public void setFather(Person father) {
		this.father = father;
	}

	public List<Person> getSons() {
		return sons;
	}

	public void setSons(List<Person> sons) {
		this.sons = sons;
	}
}
