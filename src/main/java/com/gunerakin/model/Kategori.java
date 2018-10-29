package com.gunerakin.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "KategoriTablosu")
public class Kategori {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int kategori_id;

	private String kategori_adi;

	public Kategori() {

	}
	
	

	public Kategori(String kategori_adi) {
		
		this.kategori_adi = kategori_adi;
	}



	public int getKategori_id() {
		return kategori_id;
	}

	public String getKategori_adi() {
		return kategori_adi;
	}

	public void setKategori_id(int kategori_id) {
		this.kategori_id = kategori_id;
	}

	public void setKategori_adi(String kategori_adi) {
		this.kategori_adi = kategori_adi;
	}

}
