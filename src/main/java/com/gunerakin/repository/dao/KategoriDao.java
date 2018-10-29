package com.gunerakin.repository.dao;

import java.util.List;

import com.gunerakin.model.Kategori;

public interface KategoriDao {

	
	public void createKategori(Kategori kategori);
	public List<Kategori> readAllKategori();
	public Kategori readKategoriById(int id);
	public void updateKategori(Kategori kategori);
	public void deleteKategori(Kategori kategori);
}
