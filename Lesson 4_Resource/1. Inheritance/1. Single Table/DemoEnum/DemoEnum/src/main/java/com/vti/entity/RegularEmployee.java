package com.vti.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("regularemployee") // Trùng với type
public class RegularEmployee extends Employee {

	private static final long serialVersionUID = 1L;

	@Column(name = "`salary`")
	private int salary;

	@Column(name = "`bonus`")
	private int bonus;

	public RegularEmployee() {
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getBonus() {
		return bonus;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}

	@Override
	public String toString() {
		return "RegularEmployee [salary=" + salary + ", bonus=" + bonus + ", Id=" + getId() + ", name=" + getName()
				+ "]";
	}

}
