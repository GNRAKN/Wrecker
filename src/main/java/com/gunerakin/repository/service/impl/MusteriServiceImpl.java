package com.gunerakin.repository.service.impl;

import java.util.List;
import javax.inject.Inject;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import com.gunerakin.model.Musteri;
import com.gunerakin.repository.dao.MusteriDao;
import com.gunerakin.repository.service.MusteriService;

@Service
@Transactional
public class MusteriServiceImpl implements MusteriService {

	@Inject
	MusteriDao musteriDao;
	
	

	@Override
	public void createMusteri(Musteri musteri) {
		
		musteriDao.createMusteri(musteri);
		
	}
	
	@Override
	public List<Musteri> readAllMusteri() {
		
		return musteriDao.readAllMusteri();
	}

	@Override
	public Musteri readMusteriById(int id) {
		return musteriDao.readMusteriById(id);
	}

	@Override
	public void updateMusteri(Musteri musteri) {
		
		musteriDao.updateMusteri(musteri);
		
	}

	@Override
	public void deleteMusteriById(Musteri musteri) {

		musteriDao.deleteMusteriById(musteri);
	}

}
