  package com.vti.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.vti.dto.DepartmentDTO;
import com.vti.entity.Department;
import com.vti.utils.HibernateUtils;

public class DepartmentRepository {

	private HibernateUtils hibernateUtils;

	public DepartmentRepository() {
		hibernateUtils = HibernateUtils.getInstance();
	}

	@SuppressWarnings("unchecked")
	public List<Department> getAllDepartments() {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// create hql query
			Query<Department> query = session.createQuery("FROM Department");

			return query.list();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@SuppressWarnings("unchecked")
	public List<DepartmentDTO> getAllDepartmentsUsingConstructor() {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			String hql = "SELECT new com.vti.dto.DepartmentDTO(d.name) FROM Department d";
			
			// create hql query
			Query<DepartmentDTO> query = session.createQuery(hql);

			return query.list();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Department> getAllDepartmentsWithPaging(int page, int size) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// create hql query
			Query<Department> query = session.createQuery("FROM Department d");
			
			int offset = (page - 1) * size;
			int limit = size;
			
			query.setFirstResult(offset);
			query.setMaxResults(limit);
			
			return query.list();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	public Long getTotalDepartment() {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// create hql query
			Query<Long> query = session.createQuery("SELECT COUNT(1) FROM Department");

			// get result
			Long count = query.uniqueResult();

			return count;

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	public Department getDepartmentByID(int id) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// create hql query
			Query<Department> query = session.createQuery("FROM Department WHERE id = :idParameter");

			// set parameter
			query.setParameter("idParameter", id);

			// get result
			Department department = query.uniqueResult();

			return department;

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@SuppressWarnings("unchecked")
	public Department getDepartmentByName(String name) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// create hql query
			Query<Department> query = session.createQuery("FROM Department WHERE name = :nameParameter");

			// set parameter
			query.setParameter("nameParameter", name);

			// get result
			Department department = query.uniqueResult();

			return department;

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void createDepartment(Department department) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// create
			session.save(department);

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@SuppressWarnings({ "rawtypes", "unused" })
	public void updateDepartment(int id, String newName) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();
			
			String hql = "UPDATE Department " + 
						 "SET 	 name = :nameParameter " +
						 "WHERE  id = :idParameter";
			
			// create hql query
			Query query = session.createQuery(hql);

			// set parameter
			query.setParameter("nameParameter", newName);
			query.setParameter("idParameter", id);
			
			// get result
			int result = query.executeUpdate();

			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@SuppressWarnings({ "rawtypes", "unused" })
	public void deleteDepartment(int id) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();
			
			String hql = "DELETE FROM Department " + 
						 "WHERE  id = :idParameter";
		
			// create hql query
			Query query = session.createQuery(hql);
	
			// set parameter
			query.setParameter("idParameter", id);
			
			// get result
			int result = query.executeUpdate();

			session.getTransaction().commit();
			
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public boolean isDepartmentExistsByID(int id) {

		// get department
		Department department = getDepartmentByID(id);

		// return result
		if (department == null) {
			return false;
		}

		return true;
	}

	public boolean isDepartmentExistsByName(String name) {
		Department department = getDepartmentByName(name);

		if (department == null) {
			return false;
		}
		return true;
	}

}
