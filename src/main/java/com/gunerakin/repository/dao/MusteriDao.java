package com.gunerakin.repository.dao;

import java.util.List;

import com.gunerakin.model.Musteri;

public interface MusteriDao {

	public void createMusteri(Musteri musteri);
	public List<Musteri> readAllMusteri();
	public Musteri readMusteriById(int id);
	public void updateMusteri(Musteri musteri);
	public void deleteMusteriById(Musteri  musteri);
}
