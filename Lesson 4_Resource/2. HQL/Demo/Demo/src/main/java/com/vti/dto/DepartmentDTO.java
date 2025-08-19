package com.vti.dto;

public class DepartmentDTO {
	private short id;
	private String name;

	public DepartmentDTO() {
	}

	public DepartmentDTO(short id ,String name) {
		this.id = id;
		this.name = name;
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

	@Override
	public String toString() {
		return "DepartmentDTO [id=" + id + ", name=" + name + "]";
	}
}
