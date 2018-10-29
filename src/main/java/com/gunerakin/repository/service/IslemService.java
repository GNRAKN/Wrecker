package com.gunerakin.repository.service;

import java.util.List;

import com.gunerakin.model.Islem;

public interface IslemService {

	
	public void createIslem(Islem islem);
	public List<Islem> readAllIslem();
	public Islem readIslemById(int id);
	public void updateIslem(Islem islem);
	public void deleteIslem(Islem islem);
	
}
