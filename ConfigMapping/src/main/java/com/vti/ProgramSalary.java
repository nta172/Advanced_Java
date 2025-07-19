package com.vti;

import java.util.List;

import com.vti.entity.Salary;
import com.vti.repository.SalaryRepository;

public class ProgramSalary {
	public static void main(String[] args) {
		SalaryRepository salaryRes = new SalaryRepository();
		
		List<Salary> salarys = salaryRes.getAllSalary();
		
		for (Salary salary : salarys) {
			System.out.println(salary);
		}
		
		// Create Salary
		Salary salary = new Salary();
		salary.setStatus(Salary.Status.PM);
		salaryRes.createSalary(salary);
	}
}
