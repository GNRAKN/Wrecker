package com.gunerakin.repository.service.impl;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;


import com.gunerakin.model.Kategori;
import com.gunerakin.repository.dao.KategoriDao;
import com.gunerakin.repository.service.KategoriService;

@Service
@Transactional
public class KategoriServiceImpl implements KategoriService {

	@Inject
	KategoriDao kategoriDao;
	
	@Override
	public void createKategori(Kategori kategori) {
		
		kategoriDao.createKategori(kategori);
		
	}

	@Override
	public List<Kategori> readAllKategori() {
		return kategoriDao.readAllKategori();
	}

	@Override
	public Kategori readKategoriById(int id) {
		return kategoriDao.readKategoriById(id);
	}

	@Override
	public void updateKategori(Kategori kategori) {
		kategoriDao.updateKategori(kategori);
		
	}

	@Override
	public void deleteKategori(Kategori kategori) {
		kategoriDao.deleteKategori(kategori);
		
	}

}
