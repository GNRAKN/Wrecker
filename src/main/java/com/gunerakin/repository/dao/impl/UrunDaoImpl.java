package com.gunerakin.repository.dao.impl;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.gunerakin.model.Urun;
import com.gunerakin.repository.dao.UrunDao;

@Repository
public class UrunDaoImpl implements UrunDao {

	@Inject
	SessionFactory sessionFactory;
	
	
	@Override
	public void createUrun(Urun urun) {
		
		sessionFactory.getCurrentSession().save(urun);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Urun> readAllUrun() {

		return sessionFactory.getCurrentSession().createQuery("FROM Urun").list();
	}

	@Override
	public Urun readUrunById(int id) {
		
		return sessionFactory.getCurrentSession().get(Urun.class, id);
	}

	@Override
	public void updateUrun(Urun urun) {
		sessionFactory.getCurrentSession().update(urun);

	}

	@Override
	public void deleteUrun(Urun urun) {
		sessionFactory.getCurrentSession().delete(urun);
	}

}
