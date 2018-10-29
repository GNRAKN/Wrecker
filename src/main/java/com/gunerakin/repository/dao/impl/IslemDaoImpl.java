package com.gunerakin.repository.dao.impl;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.gunerakin.model.Islem;
import com.gunerakin.repository.dao.IslemDao;

@Repository
public class IslemDaoImpl implements IslemDao {

	@Inject
	SessionFactory sessionFactory;
	
	
	@Override
	public void createIslem(Islem islem) {
		
		sessionFactory.getCurrentSession().save(islem);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Islem> readAllIslem() {
		return sessionFactory.getCurrentSession().createQuery("FROM Islem").list();
	}

	@Override
	public Islem readIslemById(int id) {
		return sessionFactory.getCurrentSession().get(Islem.class, id);
	}

	@Override
	public void updateIslem(Islem islem) {
		sessionFactory.getCurrentSession().update(islem);

	}

	@Override
	public void deleteIslem(Islem islem) {
		sessionFactory.getCurrentSession().delete(islem);

	}

}
