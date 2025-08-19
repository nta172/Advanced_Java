package com.vti.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Employee implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "id") // Id k config auto increment
	@Id
	private int id;

	@Column(name = "`name`", length = 50, nullable = false)
	private String name;

	public Employee() {
	}

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

}
