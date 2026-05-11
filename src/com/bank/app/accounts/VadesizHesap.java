package com.bank.app.accounts;

import com.bank.app.cards.KrediKarti;

public class VadesizHesap extends BankaHesabi{
	 private String hesapTuru;
	 
	 public VadesizHesap(double bakiye) {
	        super(bakiye);
	        this.hesapTuru = "Vadesiz Hesap";
	  }
	 
	 public String getHesapTuru() {
		 return hesapTuru;
	 }
	 public void setHesapTuru(String hesapTuru) {
		 this.hesapTuru = hesapTuru;
	 }
	 
	 public void paraTransferi(BankaHesabi aliciHesap, double miktar) {
		    // Gönderen hesap "this" anahtar kelimesi ile bu metodun çalıştığı nesnedir.
		    if (this.getBakiye() < miktar) { 
		        System.out.println("Yetersiz bakiye! Transfer gerçekleştirilemedi.");
		        return;
		    }
		    
		    // Bakiyeleri güncelle
		    this.setBakiye(this.getBakiye() - miktar);
		    aliciHesap.setBakiye(aliciHesap.getBakiye() + miktar);
		    
		    System.out.println(miktar + " TL transfer başarıyla gerçekleştirildi.");
		    System.out.println("  Gönderen IBAN: " + this.getIban() + " -> Yeni Bakiye: " + this.getBakiye() + " TL");
		    System.out.println("  Alıcı IBAN:    " + aliciHesap.getIban() + " -> Yeni Bakiye: " + aliciHesap.getBakiye() + " TL");
	 }
	 
	 public void krediKartiBorcOdeme(KrediKarti kart, double miktar) {
	        if (this.getBakiye() < miktar) {
	            System.out.println("Yetersiz bakiye! Borç ödemesi gerçekleştirilemedi.");
	            return;
	        }
	        if (kart.getGuncelBorc() < miktar) {
	            System.out.println("Ödeme miktarı mevcut borçtan fazla olamaz.");
	            return;
	        }
	        this.setBakiye(this.getBakiye() - miktar);
	        kart.setGuncelBorc(kart.getGuncelBorc() - miktar);
	        System.out.println(miktar + " TL kredi kartı borç ödemesi yapıldı.");
	        System.out.println("  Hesap Bakiyesi: " + this.getBakiye() + " TL");
	        System.out.println("  Kalan Kart Borcu: " + kart.getGuncelBorc() + " TL");
	  }
	 
	 
	 public String toString() {
	        return "VadesizHesap{hesapTuru='" + hesapTuru + "', " + super.toString() + "}";
	 }
}
