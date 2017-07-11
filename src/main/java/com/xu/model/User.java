package com.xu.model;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.wordnik.swagger.annotations.ApiModel;

@ApiModel(value = "A SayingRepresentation is a representation of greeting")
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class User {
	private int id;
	private String name;
	private String password;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
