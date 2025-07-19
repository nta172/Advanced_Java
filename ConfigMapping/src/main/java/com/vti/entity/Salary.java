package com.vti.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Salary", catalog = "TestingSystem")
public class Salary implements Serializable {
	private static final long serialVersionUID = 1L;
	@Column(name = "SalaryID") // Tên cột trong SQL
	@Id // Primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment
	private short id;

	@Column(name = "SalaryName", nullable = false)
	@Convert(converter = SalaryStatusConverter.class)

	private Status status;

	public Salary() {

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

	public String toString() {
		return "Salary { " + "SalaryID = " + id + ", SalaryName = '" + status + '\'' + '}';
	}

	public enum Status {
		DEV("600"), TEST("700"), SCRUMMASTER("1500"),PM("2000");

		private String status;

		private Status(String status) {
			this.status = status;
		}

		public String getStatus() {
			return status;
		}

		public static Status toEnum(String sqlStatus) {
			for (Status item : Status.values()) {
				if (item.getStatus().equals(sqlStatus)) {
					return item;
				}
			}
			return null;
		}
	}
}
