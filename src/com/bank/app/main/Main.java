package com.bank.app.main;

import com.bank.app.accounts.BankaHesabi;
import com.bank.app.accounts.VadesizHesap;
import com.bank.app.accounts.YatirimHesabi;
import com.bank.app.cards.KrediKarti;
import com.bank.app.people.BankaPersoneli;
import com.bank.app.people.Musteri;
import com.bank.app.service.BankaService;

public class Main {

	public static void main(String[] args) {
		BankaService bankaService=new BankaService();
		
		System.out.println("==========================================");
		System.out.println("       BANKA UYGULAMASI BAŞLATILIYOR      ");
		System.out.println("==========================================");
		
		//---1. PERSONEL OLUŞTURMA---
		System.out.println("=== 1. PERSONEL OLUŞTURMA ===");
		BankaPersoneli personel = bankaService.personelOlustur("Ahmet","Yılmaz",
				"ahmet.yılmaz@banka.com",532123456);
		System.out.println("Personel ID: " + personel.getPersonelID());
		
		//---2.MÜŞTERİ OLUŞTURMA---
		System.out.println("\n=== 2. MÜŞTERİ OLUŞTURMA ===");
		Musteri musteri1 = bankaService.musteriOlustur(personel,"Zeynep","Kaya",
				"zeynep.kaya@email.com",535987654);
		System.out.println("Müşteri No:"+musteri1.getMusteriNumarasi());
		
		Musteri musteri2 = bankaService.musteriOlustur(personel, "Mehmet", "Demir",
				"mehmet.demir@email.com", 542111223);
		System.out.println("Müşteri No: " + musteri2.getMusteriNumarasi());
		
		//3.HESAP AÇMA
		System.out.println("\n=== 3. HESAP AÇMA ===");
        bankaService.hesapAc(musteri1, "vadesiz");
        bankaService.hesapAc(musteri1, "yatirim");
        bankaService.hesapAc(musteri2, "vadesiz");
        
        //4.HESAPLARA PARA YATIRMA
        System.out.println("\n=== 4. HESAPLARA PARA YATIRMA ===");
        BankaHesabi hesap1 = musteri1.getHesaplar().get(0); // Zeynep'in vadesiz hesabı
        BankaHesabi hesap2 = musteri1.getHesaplar().get(1); // Zeynep'in yatırım hesabı
        BankaHesabi hesap3 = musteri2.getHesaplar().get(0); // Mehmet'in vadesiz hesabı
        
        bankaService.paraYatir(hesap1, 10000.0);
        bankaService.paraYatir(hesap2, 5000.0);
        bankaService.paraYatir(hesap3, 3000.0);
        
        // Yatırım hesabına paraEkle metodu ile de ekleme
        System.out.println("\n-- Yatırım hesabına paraEkle ile ekleme --");
        ((YatirimHesabi) hesap2).paraEkle(2000.0);
        
        // Yatırım hesabından paraCek
        System.out.println("\n-- Yatırım hesabından paraCek ile çekim --");
        ((YatirimHesabi) hesap2).paraCek(1000.0);
        
        //5.HESAPLAR ARASI PARA TRANSFERİ
        System.out.println("\n=== 5. HESAPLAR ARASI PARA TRANSFERİ ===");
        // Zeynep'in vadesiz hesabından Mehmet'in vadesiz hesabına 2000 TL transfer
        VadesizHesap vadesizHesap1 = (VadesizHesap) hesap1;
        bankaService.paraTransferiYap(vadesizHesap1, hesap3, 2000.0);
        
        // Yetersiz bakiye senaryosu
        System.out.println("\n-- Yetersiz bakiye transfer denemesi --");
        bankaService.paraTransferiYap(vadesizHesap1, hesap3, 999999.0);
        
        // ----- 6. KREDİ KARTI TANIMLAMA -----
        System.out.println("\n=== 6. KREDİ KARTI TANIMLAMA ===");
        KrediKarti kart1 = bankaService.krediKartiTanimla(musteri1, 15000.0);
        System.out.println("Kart Detayı: " + kart1);
        
        // Kartı kullanmış gibi simüle etmek için borç ekleyelim
        kart1.setGuncelBorc(3500.0);
        System.out.println("Simüle edilen kart borcu: " + kart1.getGuncelBorc() + " TL");
        
        
        // ----- 7. KREDİ KARTI BORÇ ÖDEME -----
        System.out.println("\n=== 7. KREDİ KARTI BORÇ ÖDEME ===");
        bankaService.krediKartiBorcOde(vadesizHesap1, kart1, 2000.0);
        
        // ----- 8. HESAP SİLME (Bakiyeli hesap - silme başarısız) -----
        System.out.println("\n=== 8. HESAP SİLME DENEMELERİ ===");
        System.out.println("-- Bakiyeli hesabı silme denemesi --");
        bankaService.hesapSil(musteri2, hesap3); // Mehmet'in hesabında para var
        
        // Bakiyeyi sıfırlayarak tekrar dene
        System.out.println("\n-- Bakiye sıfırlandıktan sonra hesap silme --");
        hesap3.setBakiye(0.0);
        bankaService.hesapSil(musteri2, hesap3);
        
        // ----- 9. KREDİ KARTI SİLME -----
        System.out.println("\n=== 9. KREDİ KARTI SİLME DENEMELERİ ===");
        System.out.println("-- Borcu olan kartı silme denemesi --");
        bankaService.krediKartiSil(musteri1, kart1); // Hâlâ 1500 TL borç var
        
        System.out.println("\n-- Kalan borcun ödenmesi --");
        bankaService.krediKartiBorcOde(vadesizHesap1, kart1, 1500.0);

        System.out.println("\n-- Borcu ödenmiş kartı silme --");
        bankaService.krediKartiSil(musteri1, kart1);
        
         // ----- 10. GENEL DURUM GÖRÜNTÜLEME -----
        System.out.println("\n=== 10. GENEL DURUM ===");
        bankaService.musteriHesaplariniGoster(musteri1);
        bankaService.musteriKartlariniGoster(musteri1);
        bankaService.musteriHesaplariniGoster(musteri2);
        
        System.out.println("\n=== PERSONEL MÜŞTERİ LİSTESİ ===");
        System.out.println("Personel: " + personel.getAd() + " " + personel.getSoyad());
        System.out.println("Sorumlu olduğu müşteri sayısı: " + personel.getMusteriler().size());
        for (Musteri m : personel.getMusteriler()) {
            System.out.println("  -> " + m.getAd() + " " + m.getSoyad() + " (" + m.getMusteriNumarasi() + ")");
        }
        
        System.out.println("\n==========================================");
        System.out.println("       SENARYO TAMAMLANDI                 ");
        System.out.println("==========================================");
	}

}
