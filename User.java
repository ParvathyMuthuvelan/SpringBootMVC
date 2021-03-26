package com.bean;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class User {

	@NotNull
	@Size(min=2, max=30)
	//@Pattern(regexp = "^[a-zA-Z0-9]+$")
	//@NotEmpty(message = "Please provide a name")
	private String name;

	@NotNull
	@Min(18)
	private Integer age;
	@NotNull
    private Date dateOfBirth;
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	
}