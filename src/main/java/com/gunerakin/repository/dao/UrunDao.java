package com.gunerakin.repository.dao;

import java.util.List;

import com.gunerakin.model.Urun;

public interface UrunDao {

	public void createUrun(Urun urun);
	public List<Urun> readAllUrun();
	public Urun readUrunById(int id);
	public void updateUrun(Urun urun);
	public void deleteUrun(Urun urun);

}
