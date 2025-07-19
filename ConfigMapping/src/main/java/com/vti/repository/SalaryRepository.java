package com.vti.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;

import com.vti.entity.Salary;
import com.vti.utils.HibernateUtils;

public class SalaryRepository {
	@SuppressWarnings("unchecked")
	public List<Salary> getAllSalary() {	
		Session session = null;

		try {

			// get session
			session = HibernateUtils.getInstance().openSession();

			// create hql query
			Query<Salary> query = session.createQuery("FROM Salary");

			return query.list();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public Salary getSalaryByID(short id) {

		Session session = null;

		try {

			// get session
			session = HibernateUtils.getInstance().openSession();

			// get position by id
			Salary salary = session.get(Salary.class, id);

			return salary;

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@SuppressWarnings("unchecked")
	public Salary getSalaryByName(String name) {

		Session session = null;

		try {

			// get session
			session = HibernateUtils.getInstance().openSession();

			// create hql query
			Query<Salary> query = session.createQuery("FROM Salary WHERE name = :nameParameter");

			// set parameter
			query.setParameter("nameParameter", name);

			// get result
			Salary salary = query.uniqueResult();

			return salary;

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void createSalary(Salary salary) {

		Session session = null;

		try {

			// get session
			session = HibernateUtils.getInstance().openSession();
			session.beginTransaction();

			// create
			session.save(salary);

			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void updateSalary(short id, String newName) {

		Session session = null;

		try {

			// get session
			session = HibernateUtils.getInstance().openSession();
			session.beginTransaction();

			// get position
			Salary salary = (Salary) session.load(Salary.class, id);

			// update
			//position.setStatus(newName);

			session.getTransaction().commit();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void updatePosition(Salary salary) {

		Session session = null;

		try {

			// get session
			session = HibernateUtils.getInstance().openSession();
			session.beginTransaction();

			// update
			session.update(salary);

			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void deleteSalary(short id) {

		Session session = null;

		try {

			// get session
			session = HibernateUtils.getInstance().openSession();
			session.beginTransaction();

			// get department
			Salary salary = (Salary) session.load(Salary.class, id);

			// delete
			session.delete(salary);

			session.getTransaction().commit();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public boolean isSalaryExistsByID(short id) {

		// get department
		Salary salary = getSalaryByID(id);

		// return result
		if (salary == null) {
			return false;
		}

		return true;
	}

	public boolean isPositionExistsByName(String name) {
		Salary salary = getSalaryByName(name);

		if (salary == null) {
			return false;
		}
		return true;
	}

}