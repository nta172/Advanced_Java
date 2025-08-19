package com.vti.repository;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.vti.entity.Department;
import com.vti.utils.HibernateUtils;

public class DepartmentRepository {

	private HibernateUtils hibernateUtils;

	public DepartmentRepository() {
		hibernateUtils = HibernateUtils.getInstance();
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<Department> getAllDepartmentsWithSearch(String search) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// create criteria

			Criteria criteria = session.createCriteria(Department.class);
			criteria.add(Restrictions.ilike("name", "%" + search + "%"));

			return criteria.list();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
}
