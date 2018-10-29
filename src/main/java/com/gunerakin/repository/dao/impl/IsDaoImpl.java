package com.gunerakin.repository.dao.impl;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.gunerakin.model.Is;
import com.gunerakin.repository.dao.IsDao;

@Repository
public class IsDaoImpl implements IsDao {

	@Inject
	SessionFactory sessionFactory;

	@Override
	public void createIs(Is is) {
		sessionFactory.getCurrentSession().save(is);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Is> readAllIs() {
		return sessionFactory.getCurrentSession().createQuery("FROM Is").list();

	}

	@Override
	public Is readIsById(int id) {
		return sessionFactory.getCurrentSession().get(Is.class, id);
	}

	@Override
	public void updateIs(Is is) {
		sessionFactory.getCurrentSession().update(is);
	}

	@Override
	public void deleteIs(Is is) {
		sessionFactory.getCurrentSession().delete(is);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Is> readIsByStatu(String statu) {

		return sessionFactory.getCurrentSession()
				.createQuery("FROM Is as i where i.is_statu='" + statu + "'").list();

	}
}
