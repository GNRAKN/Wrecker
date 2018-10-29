package com.gunerakin.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "IsTablosu")
public class Is implements Serializable {


	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int is_id;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Urun urun;

	@ManyToMany(fetch = FetchType.EAGER)
			@JoinTable(name = "Is_Islem", joinColumns = { @JoinColumn(name = "Is_Id") }, inverseJoinColumns = {
					@JoinColumn(name = "Islem_Id") })
	
	private List<Islem> islem;

	private String is_detay;

	private String is_statu;
	
	@Temporal(TemporalType.DATE)  //Sadece tarih bilgisini almasini sagliyoruz
	private Date kayit_tarihi;

	public Is() {

	}

	public Is(Urun urun, List<Islem> islem, String is_detay, String is_statu, Date kayit_tarihi) {
		super();
		this.urun = urun;
		this.islem = islem;
		this.is_detay = is_detay;
		this.is_statu = is_statu;
		this.kayit_tarihi = kayit_tarihi;
	}

	public int getIs_id() {
		return is_id;
	}

	public Urun getUrun() {
		return urun;
	}

	public List<Islem> getIslem() {
		return islem;
	}

	public String getIs_detay() {
		return is_detay;
	}

	public String getIs_statu() {
		return is_statu;
	}

	public Date getKayit_tarihi() {
		return kayit_tarihi;
	}

	public void setIs_id(int is_id) {
		this.is_id = is_id;
	}

	public void setUrun(Urun urun) {
		this.urun = urun;
	}

	public void setIslem(List<Islem> islem) {
		this.islem = islem;
	}

	public void setIs_detay(String is_detay) {
		this.is_detay = is_detay;
	}

	public void setIs_statu(String is_statu) {
		this.is_statu = is_statu;
	}

	public void setKayit_tarihi(Date kayit_tarihi) {
		this.kayit_tarihi = kayit_tarihi;
	}

	

	
}
