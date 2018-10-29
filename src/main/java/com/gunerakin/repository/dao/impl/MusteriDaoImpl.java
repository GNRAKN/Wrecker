package com.gunerakin.repository.dao.impl;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.gunerakin.model.Musteri;
import com.gunerakin.repository.dao.MusteriDao;

@Repository
public class MusteriDaoImpl implements MusteriDao{

	@Inject
	private SessionFactory sessionFactory;
	
	
	@Override
	public void createMusteri(Musteri musteri) {
		
		sessionFactory.getCurrentSession().save(musteri);
		
	}
	
	@SuppressWarnings("unchecked") //ne ise yariyor arastir
	@Override
	public List<Musteri> readAllMusteri() {
		
		return sessionFactory.getCurrentSession().createQuery("FROM Musteri").list();
	}


	@Override
	public Musteri readMusteriById(int id) {
		
		return sessionFactory.getCurrentSession().get(Musteri.class, id);
	}

	@Override
	public void updateMusteri(Musteri musteri) {
		
		sessionFactory.getCurrentSession().update(musteri);
		
	}

	@Override
	public void deleteMusteriById(Musteri musteri) {
		
		sessionFactory.getCurrentSession().delete(musteri);
		
	}

}
