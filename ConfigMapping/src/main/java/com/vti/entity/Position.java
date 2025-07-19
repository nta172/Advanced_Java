package com.vti.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Position", catalog = "TestingSystem") // Tên bảng
public class Position implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "PositionID") // Tên cột trong SQL
	@Id // Primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment
	private short id;

	@Column(name = "PositionName", nullable = false)
	@Enumerated(EnumType.STRING)
	private Status status;

	public Position(){
		// TODO Auto-generated constructor stub
	}

	public short getId() {
		return id;
	}
	

	public void setId(short id) {
		this.id = id;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	/*
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Position { " + "ID = " + id + ", Name = '" + status + '\'' + '}';
	}
	
	public enum Status {
		DEV, TEST, SCRUMMASTER, PM
	}

}
