package com.vti.repository;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.vti.entity.Department;
import com.vti.utils.HibernateUtils;

@SuppressWarnings("deprecation")
public class DepartmentRepository {

	private HibernateUtils hibernateUtils;

	public DepartmentRepository() {
		hibernateUtils = HibernateUtils.getInstance();
	}

	@SuppressWarnings({ "unchecked", "deprecation", "rawtypes" })
	public List<Department> getAllDepartments() {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// create hql query
			SQLQuery query = session.createSQLQuery("SELECT id, `name` FROM Department");
			query.addEntity(Department.class);

			return query.list();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
}
