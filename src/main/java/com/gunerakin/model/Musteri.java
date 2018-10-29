package com.gunerakin.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="MusteriTablosu")
public class Musteri {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int musteri_id;
	private String musteri_adi;
	private String musteri_soyadi;
	private String musteri_telefon;
	private String musteri_adres;
	private String musteri_eposta;

	public Musteri() {
		
	}

	public Musteri(String musteri_adi, String musteri_soyadi, String musteri_telefon, String musteri_adres,
			String musteri_eposta) {
		super();
		this.musteri_adi = musteri_adi;
		this.musteri_soyadi = musteri_soyadi;
		this.musteri_telefon = musteri_telefon;
		this.musteri_adres = musteri_adres;
		this.musteri_eposta = musteri_eposta;
	}

	public int getMusteri_id() {
		return musteri_id;
	}

	public String getMusteri_adi() {
		return musteri_adi;
	}

	public String getMusteri_soyadi() {
		return musteri_soyadi;
	}

	public String getMusteri_telefon() {
		return musteri_telefon;
	}

	public String getMusteri_adres() {
		return musteri_adres;
	}

	public String getMusteri_eposta() {
		return musteri_eposta;
	}

	public void setMusteri_id(int musteri_id) {
		this.musteri_id = musteri_id;
	}

	public void setMusteri_adi(String musteri_adi) {
		this.musteri_adi = musteri_adi;
	}

	public void setMusteri_soyadi(String musteri_soyadi) {
		this.musteri_soyadi = musteri_soyadi;
	}

	public void setMusteri_telefon(String musteri_telefon) {
		this.musteri_telefon = musteri_telefon;
	}

	public void setMusteri_adres(String musteri_adres) {
		this.musteri_adres = musteri_adres;
	}

	public void setMusteri_eposta(String musteri_eposta) {
		this.musteri_eposta = musteri_eposta;
	}

	
	

	
}
