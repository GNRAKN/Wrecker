package com.gunerakin.repository.dao.impl;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.gunerakin.model.Kategori;
import com.gunerakin.repository.dao.KategoriDao;

@Repository
public class KategoriDaoImpl implements KategoriDao {

	@Inject
	SessionFactory sessionFactory;
	
	
	@Override
	public void createKategori(Kategori kategori) {		
		sessionFactory.getCurrentSession().save(kategori);
		
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<Kategori> readAllKategori() {

		return sessionFactory.getCurrentSession().createQuery("FROM Kategori").list();
	}

	@Override
	public Kategori readKategoriById(int id) {

		return sessionFactory.getCurrentSession().get(Kategori.class, id);
	}

	@Override
	public void updateKategori(Kategori kategori) {
		sessionFactory.getCurrentSession().update(kategori);
		
	}

	@Override
	public void deleteKategori(Kategori kategori) {
		sessionFactory.getCurrentSession().delete(kategori);
		
	}

}
