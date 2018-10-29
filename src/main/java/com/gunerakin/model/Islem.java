package com.gunerakin.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "IslemTablosu")
public class Islem implements Serializable {

	private static final long serialVersionUID = 1L;

	public Islem() {

	}
	
	

	public Islem(String islem_adi) {
		
		this.islem_adi = islem_adi; //id'ler otomatik belirlendiğinden yapıcıda parametre olarak almıyoruz.
	}


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int islem_id;

	private String islem_adi;

	public int getIslem_id() {
		return islem_id;
	}

	public String getIslem_adi() {
		return islem_adi;
	}

	public void setIslem_id(int islem_id) {
		this.islem_id = islem_id;
	}

	public void setIslem_adi(String islem_adi) {
		this.islem_adi = islem_adi;
	}

}
