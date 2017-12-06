package com.jersey.jaxrs.entities;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Employee {

	public Employee() {

	}

	public Employee(String name, Long id, Long createDate) {
		super();
		this.name = name;
		this.id = id;
		this.createDate = createDate;
	}

	private String name;
	private Long id;
	private Long createDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Long createDate) {
		this.createDate = createDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
