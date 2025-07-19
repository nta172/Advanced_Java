package com.vti.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;

import com.vti.entity.Account;
import com.vti.utils.HibernateUtils;

public class AccountRepository {
	@SuppressWarnings("unchecked") // Bỏ qua cảnh báo
	public List<Account> getAllAccounts() {	
		Session session = null; // Tạo sesstion

		try {

			// get session
			session = HibernateUtils.getInstance().openSession(); // Kết nối DB

			// create hql query
			Query<Account> query = session.createQuery("FROM Account"); // Câu lệnh truy vấn DB

			return query.list(); // Trả ra danh sách

		} finally {
			if (session != null) {
				session.close(); // Đóng session tránh rò rỉ tài nguyên
			}
		}
	}

	public Account getAccountByID(short id) {

		Session session = null;

		try {

			// get session
			session = HibernateUtils.getInstance().openSession();

			// get Account by id
			Account account = session.get(Account.class, id); // Lấy một đối tượng theo primary key trong bảng Account

			return account;

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@SuppressWarnings("unchecked")
	public Account getAccountByName(String name) {

		Session session = null;

		try {

			// get session
			session = HibernateUtils.getInstance().openSession();

			// create hql query
			Query<Account> query = session.createQuery("FROM Account WHERE name = :nameParameter");

			// set parameter
			query.setParameter("nameParameter", name); // truyền giá trị name vào biến nameParamater

			// get result
			Account account = query.uniqueResult();

			return account;

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void createAccount(Account account) {

		Session session = null;

		try {

			// get session
			session = HibernateUtils.getInstance().openSession();
			session.beginTransaction(); // Để lưu vào DB

			// create
			session.save(account); // Thêm mới vào DB

			session.getTransaction().commit(); // commit -> dữ liệu được lưu vào DB <> không commit mọi thay đổi sẽ bị rollback
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void updateAccount(short id, String firstName, String lastName) {

		Session session = null;

		try {

			// get session
			session = HibernateUtils.getInstance().openSession();
			session.beginTransaction();

			// get department
			Account account = (Account) session.load(Account.class, id);

			// update
			account.setFirstName(firstName);
			account.setLastName(lastName);

			session.getTransaction().commit();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void updateAccount(Account account) {

		Session session = null;

		try {

			// get session
			session = HibernateUtils.getInstance().openSession();
			session.beginTransaction();

			// update
			session.update(account);

			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void deleteAccount(short id) {

		Session session = null;

		try {

			// get session
			session = HibernateUtils.getInstance().openSession();
			session.beginTransaction();

			// get Account
			Account account = (Account) session.load(Account.class, id);

			// delete
			session.delete(account);

			session.getTransaction().commit();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public boolean isAccountExistsByID(short id) {

		// get department
		Account account = getAccountByID(id);

		// return result
		if (account == null) {
			return false;
		}

		return true;
	}

	public boolean isAccountExistsByName(String name) {
		Account account = getAccountByName(name);

		if (account == null) {
			return false;
		}
		return true;
	}

}
