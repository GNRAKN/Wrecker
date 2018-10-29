package com.gunerakin.repository.service.impl;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.gunerakin.model.Islem;
import com.gunerakin.repository.dao.IslemDao;
import com.gunerakin.repository.service.IslemService;

@Service
@Transactional
public class IslemServiceImpl implements IslemService {

	@Inject
	IslemDao islemDao;
	
	@Override
	public void createIslem(Islem islem) {
		islemDao.createIslem(islem);

	}

	@Override
	public List<Islem> readAllIslem() {
		return islemDao.readAllIslem();
	}

	@Override
	public Islem readIslemById(int id) {
		return islemDao.readIslemById(id);
	}

	@Override
	public void updateIslem(Islem islem) {

		islemDao.updateIslem(islem);
	}

	@Override
	public void deleteIslem(Islem islem) {
		islemDao.deleteIslem(islem);

	}

}
