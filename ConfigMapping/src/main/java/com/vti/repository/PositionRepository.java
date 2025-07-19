package com.vti.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;

import com.vti.entity.Position;
import com.vti.entity.Position.Status;
import com.vti.utils.HibernateUtils;

public class PositionRepository {
	@SuppressWarnings("unchecked")
	public List<Position> getAllPosition() {	
		Session session = null;

		try {

			// get session
			session = HibernateUtils.getInstance().openSession();

			// create hql query
			Query<Position> query = session.createQuery("FROM Position");

			return query.list();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public Position getPositionByID(short id) {

		Session session = null;

		try {

			// get session
			session = HibernateUtils.getInstance().openSession();

			// get position by id
			Position position = session.get(Position.class, id);

			return position;

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@SuppressWarnings("unchecked")
	public Position getPositionByName(String name) {

		Session session = null;

		try {

			// get session
			session = HibernateUtils.getInstance().openSession();

			// create hql query
			Query<Position> query = session.createQuery("FROM Position WHERE name = :nameParameter");

			// set parameter
			query.setParameter("nameParameter", name);

			// get result
			Position position = query.uniqueResult();

			return position;

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void createPosition(Position position) {

		Session session = null;

		try {

			// get session
			session = HibernateUtils.getInstance().openSession();
			session.beginTransaction();

			// create
			session.save(position);

			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void updatePosition(short id, Status newName) {

		Session session = null;

		try {

			// get session
			session = HibernateUtils.getInstance().openSession();
			session.beginTransaction();

			// get position
			Position position = (Position) session.load(Position.class, id);

			// update
			position.setStatus(newName);

			session.getTransaction().commit();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void updatePosition(Position position) {

		Session session = null;

		try {

			// get session
			session = HibernateUtils.getInstance().openSession();
			session.beginTransaction();

			// update
			session.update(position);

			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void deletePosition(short id) {

		Session session = null;

		try {

			// get session
			session = HibernateUtils.getInstance().openSession();
			session.beginTransaction();

			// get department
			Position position = (Position) session.load(Position.class, id);

			// delete
			session.delete(position);

			session.getTransaction().commit();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public boolean isPositionExistsByID(short id) {

		// get department
		Position position = getPositionByID(id);

		// return result
		if (position == null) {
			return false;
		}

		return true;
	}

	public boolean isPositionExistsByName(String name) {
		Position position = getPositionByName(name);

		if (position == null) {
			return false;
		}
		return true;
	}

}