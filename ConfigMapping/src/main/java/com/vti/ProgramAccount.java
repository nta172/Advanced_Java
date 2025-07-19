package com.vti;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.repository.AccountRepository;

public class ProgramAccount {
	public static void main(String[] args) {
		AccountRepository repository = new AccountRepository();

		System.out.println("***********GET ALL Account***********");

		List<Account> accounts = repository.getAllAccounts();

		for (Account account : accounts) {
			System.out.println(account);
		}
		
		System.out.println("\n\n***********GET Account BY ID***********");

		Account accountById = repository.getAccountByID((short) 3);
		System.out.println(accountById);

//		System.out.println("\n\n***********CREATE ACCOUNT***********");
//
//		Account accountCreate = new Account();
//		accountCreate.setEmail("nguyentheanh2003@gmail.com");
//		accountCreate.setUserName("nguyentheanh");
//		accountCreate.setFirstName("Anh");
//		accountCreate.setLastName("Nguyen");
//		repository.createAccount(accountCreate);
		
		System.out.println("\n\n***********UPDATE DEPARTMENT 1***********");

		repository.updateAccount((short) 3, "Nguyen", "Anh");
		
		System.out.println("\n\n***********UPDATE DEPARTMENT 2***********");

		Account accountUpdate = new Account();
		accountUpdate.setId((short) 2);
		accountUpdate.setFirstName("Anh");
		accountUpdate.setLastName("Nguyen The");
		
		repository.updateAccount(accountUpdate);
	}
}
