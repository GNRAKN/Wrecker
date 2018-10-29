package com.gunerakin.repository.dao;

import java.util.List;

import com.gunerakin.model.Is;

public interface IsDao {

	
	public void createIs(Is is);
	public List<Is> readAllIs();
	public Is readIsById(int id);
	public List<Is> readIsByStatu(String statu);
	public void updateIs(Is is);
	public void deleteIs(Is is);
}
