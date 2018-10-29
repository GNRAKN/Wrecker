package com.gunerakin.repository.service.impl;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.gunerakin.model.Urun;
import com.gunerakin.repository.dao.UrunDao;
import com.gunerakin.repository.service.UrunService;

@Service
@Transactional
public class UrunServiceImpl implements UrunService {

	@Inject
	UrunDao urunDao;
	
	@Override
	public void createUrun(Urun urun) {
		urunDao.createUrun(urun);
		
	}

	@Override
	public List<Urun> readAllUrun() {
		return urunDao.readAllUrun();
	}

	@Override
	public Urun readUrunById(int id) {
		return urunDao.readUrunById(id);
	}

	@Override
	public void updateUrun(Urun urun) {
		urunDao.updateUrun(urun);

	}

	@Override
	public void deleteUrun(Urun urun) {
		urunDao.deleteUrun(urun);

	}

}
