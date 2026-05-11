package com.bank.app.service;

import com.bank.app.accounts.BankaHesabi;
import com.bank.app.accounts.VadesizHesap;
import com.bank.app.accounts.YatirimHesabi;
import com.bank.app.cards.KrediKarti;
import com.bank.app.people.BankaPersoneli;
import com.bank.app.people.Musteri;

import java.util.ArrayList;

public class BankaService {
	private ArrayList<BankaPersoneli> personeller;
    private ArrayList<Musteri> tumMusteriler;
    
    public BankaService() {
    	this.personeller=new ArrayList<>();
    	this.tumMusteriler=new ArrayList<>();
    }
    
    //-personel işlemleri-
    
    public BankaPersoneli personelOlustur(String ad, String soyad, String email, int telefon) {
    	BankaPersoneli personel = new BankaPersoneli(ad, soyad, email, telefon);
    	personeller.add(personel);
    	System.out.println("Personel oluşturuldu: " + personel);
        return personel;
    }
    
    //-müşteri işlemleri-
    
    public Musteri musteriOlustur(BankaPersoneli personel, String ad, String soyad, String email, int telefon) {
    	Musteri musteri = new Musteri(ad, soyad, email, telefon);
    	personel.musteriEkle(musteri);
    	tumMusteriler.add(musteri);
    	System.out.println("Müşteri oluşturuldu: " + musteri);
        return musteri;
    }
    
    //-hesap işlemleri-
    
    public void hesapAc(Musteri musteri, String hesapTuru) {
    	musteri.hesapEkle(hesapTuru);
    }
    
    public void paraYatir(BankaHesabi hesap, double miktar) {
    	if(miktar<=0) {
    		System.out.println("Geçersiz miktar!");
            return;
    	}
    	hesap.setBakiye(hesap.getBakiye() + miktar);
    	System.out.println(miktar + " TL hesaba yatırıldı. Güncel bakiye: " + hesap.getBakiye() + " TL");
    }
    
    public void paraTransferiYap(VadesizHesap gonderenHesap, BankaHesabi aliciHesap, double miktar) {
    	gonderenHesap.paraTransferi(aliciHesap, miktar);
    }
    public void hesapSil(Musteri musteri, BankaHesabi hesap) {
    	musteri.hesapSil(hesap);
    }
    
    //-kredi kartı işlemleri
    
    public KrediKarti krediKartiTanimla(Musteri musteri, double limit) {
    	musteri.krediKartiEkle(limit, 0.0);
    	return musteri.getKrediKartlari().get(musteri.getKrediKartlari().size()-1);
    }
    public void krediKartiBorcOde(VadesizHesap hesap, KrediKarti kart, double miktar) {
    	hesap.krediKartiBorcOdeme(kart,miktar);
    }
    
    public void krediKartiSil(Musteri musteri, KrediKarti kart) {
    	musteri.krediKartiSil(kart);
    }
    
    //-bilgi görüntüleme-
    
    public void musteriHesaplariniGoster(Musteri musteri) {
    	System.out.println("\n--- " + musteri.getAd() + " " + musteri.getSoyad() + " Hesapları ---");
    	if(musteri.getHesaplar().isEmpty()) {
    		System.out.println("Kayıtlı hesap bulunmamaktadır.");
    	} else {
    		for(BankaHesabi h:musteri.getHesaplar()) {
    			System.out.println(" "+h);
    		}
    	}
    }
    
    public void musteriKartlariniGoster(Musteri musteri) {
    	System.out.println("\n--- " + musteri.getAd() + " " + musteri.getSoyad() + " Kredi Kartları ---");
    	if (musteri.getKrediKartlari().isEmpty()) {
    		System.out.println("Kayıtlı kredi kartı bulunmamaktadır.");
    	} else {
    		for(KrediKarti k:musteri.getKrediKartlari()) {
    			System.out.println(" "+k);
    		}
    	}
    }
    
    public ArrayList<BankaPersoneli> getPersoneller(){
    	return personeller;
    }
    public ArrayList<Musteri> getTumMusteriler(){
    	return tumMusteriler;
    }
    
}
