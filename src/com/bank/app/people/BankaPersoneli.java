package com.bank.app.people;

import java.util.ArrayList;
import java.util.Random;

public class BankaPersoneli extends Kisi { 
	private String personelID;
    private ArrayList<Musteri> musteriler;
    
    public BankaPersoneli(String ad, String soyad, String email, int telefonNumarasi) {
    	super(ad, soyad, email, telefonNumarasi);
    	this.personelID = "P" + (10000 + new Random().nextInt(90000));
        this.musteriler = new ArrayList<>();
    }
    
    public String getPersonelID() {
    	return personelID;
    }
    public void setPersonelID(String personelID) {
    	this.personelID=personelID;
    }
    
    public ArrayList<Musteri> getMusteriler() {
    	return musteriler; 
    }
    
    public void musteriEkle(Musteri musteri) {
        musteriler.add(musteri);
        System.out.println("Müşteri eklendi: " + musteri.getAd() + " " + musteri.getSoyad());
    }
    
    public void musteriSil(Musteri musteri) {
        musteriler.remove(musteri);
        System.out.println("Müşteri silindi: " + musteri.getAd() + " " + musteri.getSoyad());
    }
    
    public String toString() {
        return "BankaPersoneli{" +"personelID='" + personelID + '\'' + ", " + super.toString()
                + ", musteriSayisi=" + musteriler.size() +
                '}';
    }
}
