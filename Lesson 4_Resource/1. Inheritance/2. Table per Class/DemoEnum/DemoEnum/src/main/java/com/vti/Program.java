package com.vti;

import java.util.List;

import com.vti.entity.RegularEmployee;
import com.vti.repository.EmployeeRepository;

public class Program {
	public static void main(String[] args) {
		EmployeeRepository employeeRepository = new EmployeeRepository();

		System.out.println("***********GET ALL REGULAR EMPLOYEES***********");

		List<RegularEmployee> regularEmployees = employeeRepository.getAllRegularEmployees();

		for (RegularEmployee regularEmployee : regularEmployees) {
			System.out.println(regularEmployee);
		}
	}
}
