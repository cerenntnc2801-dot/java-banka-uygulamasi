package com.bank.app.people;

import com.bank.app.accounts.BankaHesabi;
import com.bank.app.accounts.VadesizHesap;
import com.bank.app.accounts.YatirimHesabi;
import com.bank.app.cards.KrediKarti;

import java.util.ArrayList;
import java.util.Random;

public class Musteri extends Kisi {
	private String musteriNumarasi;
    private ArrayList<BankaHesabi> hesaplar;
    private ArrayList<KrediKarti> krediKartlari;
    
    public Musteri(String ad, String soyad, String email, int telefonNumarasi) {
    	super(ad,soyad,email,telefonNumarasi);
    	this.musteriNumarasi = "M" + (100000 + new Random().nextInt(900000));
    	this.hesaplar = new ArrayList<>();
    	this.krediKartlari = new ArrayList<>();	
    }
    
    public String getMusteriNumarasi() {
    	 return musteriNumarasi;
    }
    public void setMusteriNumarasi(String musteriNumarasi) {
    	this.musteriNumarasi = musteriNumarasi;
    }
    public ArrayList<BankaHesabi> getHesaplar() { 
    	return hesaplar; 
    }
    public ArrayList<KrediKarti> getKrediKartlari() { 
    	return krediKartlari; 
    }
    
    public void hesapEkle(String hesapTuru) {
    	BankaHesabi yeniHesap;
    	if (hesapTuru.equalsIgnoreCase("vadesiz")) {
    		yeniHesap = new VadesizHesap(0.0);
    		hesaplar.add(yeniHesap);
    		System.out.println("Vadesiz hesap başarıyla açıldı. IBAN: " + yeniHesap.getIban());
    	} else if (hesapTuru.equalsIgnoreCase("yatirim")) {
    		yeniHesap = new YatirimHesabi(0.0);
    		hesaplar.add(yeniHesap);
    		System.out.println("Yatırım hesabı başarıyla açıldı. IBAN: " + yeniHesap.getIban());
    	} else {
    		System.out.println("Geçersiz hesap türü. Lütfen vadesiz veya yatirim giriniz.");
    	}
    }
    
    public void krediKartiEkle(double limit, double guncelBorc) {
    	KrediKarti yeniKart = new KrediKarti(limit, guncelBorc);
        krediKartlari.add(yeniKart);
        System.out.println("Kredi kartı başarıyla tanımlandı. Kart No: " + yeniKart.getKartNumarasi());
    }
    
    public void hesapSil(BankaHesabi hesap) {
    	if (hesap.getBakiye() > 0) {
    		 System.out.println("Lütfen öncelikle bakiyenizi başka bir hesaba aktarınız.");
    	} else {
    		 hesaplar.remove(hesap);
             System.out.println("Hesap başarıyla silindi. IBAN: " + hesap.getIban());
    	}
    }
    
    public void krediKartiSil(KrediKarti kart) {
    	 if (kart.getGuncelBorc() != 0) {
    		 System.out.println("Lütfen öncelikle borç ödemesi yapınız.");
    	 } else {
    		 krediKartlari.remove(kart);
             System.out.println("Kredi kartı başarıyla silindi. Kart No: " + kart.getKartNumarasi());
    	 }	
    }
    
    public String toString() {
    	 return "Musteri{" +
                 "musteriNo='" + musteriNumarasi + '\'' +
                 ", " + super.toString() +
                 ", hesapSayisi=" + hesaplar.size() +
                 ", kartSayisi=" + krediKartlari.size() +
                 '}';
    }
}
