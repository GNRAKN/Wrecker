package com.gunerakin.model;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "UrunTablosu")
public class Urun {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int urun_id;
	private String urun_adi;
	private String urun_detay;

	@ManyToOne(fetch=FetchType.EAGER)
	private Kategori kategori;

	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	private Musteri musteri;

	public Urun() {

	}

	public Urun(String urun_adi, String urun_detay, Kategori kategori, Musteri musteri) {
		super();
		this.urun_adi = urun_adi;
		this.urun_detay = urun_detay;
		this.kategori = kategori;
		this.musteri = musteri;
	}

	public int getUrun_id() {
		return urun_id;
	}

	public String getUrun_adi() {
		return urun_adi;
	}

	public String getUrun_detay() {
		return urun_detay;
	}

	public Kategori getKategori() {
		return kategori;
	}

	public Musteri getMusteri() {
		return musteri;
	}

	public void setUrun_id(int urun_id) {
		this.urun_id = urun_id;
	}

	public void setUrun_adi(String urun_adi) {
		this.urun_adi = urun_adi;
	}

	public void setUrun_detay(String urun_detay) {
		this.urun_detay = urun_detay;
	}

	public void setKategori(Kategori kategori) {
		this.kategori = kategori;
	}

	public void setMusteri(Musteri musteri) {
		this.musteri = musteri;
	}

	
}
