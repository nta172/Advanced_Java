package com.vti.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Regular_Employee")
@AttributeOverrides({ 
	@AttributeOverride(name = "id", column = @Column(name = "id")),
	@AttributeOverride(name = "name", column = @Column(name = "name"))
})
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
