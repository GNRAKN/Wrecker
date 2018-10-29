package com.gunerakin.repository.service.impl;

import java.util.List;
import javax.inject.Inject;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import com.gunerakin.model.Is;
import com.gunerakin.repository.dao.IsDao;
import com.gunerakin.repository.service.IsService;

@Service
@Transactional
public class IsServiceImpl implements IsService {

	@Inject
	IsDao isDao;
	
	@Override
	public synchronized void createIs(Is is) {
		
		isDao.createIs(is);

	}

	@Override
	public List<Is> readAllIs() {
		return isDao.readAllIs();
	}

	@Override
	public Is readIsById(int id) {
		return isDao.readIsById(id);
	}

	@Override
	public synchronized void updateIs(Is is) {
		isDao.updateIs(is);

	}

	@Override
	public synchronized void deleteIs(Is is) {
		isDao.deleteIs(is);

	}

	@Override
	public List<Is> readIsByStatu(String statu) {
		return isDao.readIsByStatu(statu);
	}

}
