package com.bank.app.people;

/* banka personeli ve müşterilerin ortak özelliklerini barındıran temel sınıf */
public class Kisi {
	    private String ad;
	    private String soyad;
	    private String email;
	    private int telefonNumarasi;

	    // Constructor
	    public Kisi(String ad, String soyad, String email, int telefonNumarasi) {
	        this.ad = ad;
	        this.soyad = soyad;
	        this.email = email;
	        this.telefonNumarasi = telefonNumarasi;
	    }

	    // Getter ve Setter metotları
	    public String getAd() {
	        return ad;
	    }

	    public void setAd(String ad) {
	        this.ad = ad;
	    }

	    public String getSoyad() {
	        return soyad;
	    }

	    public void setSoyad(String soyad) {
	        this.soyad = soyad;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

	    public int getTelefonNumarasi() {
	        return telefonNumarasi;
	    }

	    public void setTelefonNumarasi(int telefonNumarasi) {
	        this.telefonNumarasi = telefonNumarasi;
	    }
	
	    public String toString() {
	        return "Ad: " + ad +
	                " Soyad: " + soyad +
	                " Email: " + email +
	                " Telefon: " + telefonNumarasi;
	    }
	}


