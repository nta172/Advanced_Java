package com.vti;

import java.util.List;

import com.vti.dto.DepartmentDTO;
import com.vti.entity.Department;
import com.vti.repository.DepartmentRepository;

public class Program {
	public static void main(String[] args) {
		DepartmentRepository repository = new DepartmentRepository();

		System.out.println("***********GET ALL DEPARTMENTS***********");

		List<Department> departments = repository.getAllDepartments();

		for (Department department : departments) {
			System.out.println(department);
		}
		
//		System.out.println("***********GET ALL DEPARTMENTS USING CONSTRUCTOR***********");
//
//		List<DepartmentDTO> departmentDtos = repository.getAllDepartmentsUsingConstructor();
//
//		for (DepartmentDTO dto : departmentDtos) {
//			System.out.println(dto);
//		}
		
		System.out.println("***********GET ALL DEPARTMENTS WITH PAGING***********");

		departments = repository.getAllDepartmentsWithPaging(2, 5);

		for (Department department : departments) {
			System.out.println(department);
		}

		System.out.println("***********GET COUNT OF DEPARTMENTS***********");

		Long count = repository.getTotalDepartment();

		System.out.println("Count Of Departments: " + count);

		System.out.println("\n\n***********GET DEPARTMENT BY ID***********");

		Department departmentById = repository.getDepartmentByID(2);
		System.out.println(departmentById);

		System.out.println("\n\n***********GET DEPARTMENT BY NAME***********");

		Department departmentByName = repository.getDepartmentByName("Marketting");
		System.out.println(departmentByName);

		System.out.println("\n\n***********CREATE DEPARTMENT***********");

		Department departmentCreate = new Department();
		departmentCreate.setName("waiting");
		repository.createDepartment(departmentCreate);

		System.out.println("\n\n***********UPDATE DEPARTMENT 1***********");

		repository.updateDepartment(3, "Security");

		System.out.println("\n\n***********DELETE DEPARTMENTS***********");
		repository.deleteDepartment(2);

		System.out.println("***********CHECK DEPARTMENT EXISTS BY ID***********");
		System.out.println(repository.isDepartmentExistsByID(1));

		System.out.println("***********CHECK DEPARTMENT EXISTS BY NAME***********");
		System.out.println(repository.isDepartmentExistsByName("Security"));

	}
}
