package com.vti.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Department", catalog = "TestingSystem") // Tên bảng
public class Department implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "DepartmentID") // Tên cột trong SQL
	@Id // Primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment
	private short id;

	@Column(name = "DepartmentName", length = 30, nullable = false, unique = true)
	private String name;

	public Department() {
	}

	public short getId() {
		return id;
	}

	public void setId(short id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/*
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Department { " + "ID = " + id + ", Name = '" + name + '\'' + '}';
	}

}
