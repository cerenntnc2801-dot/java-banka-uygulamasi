package com.bank.app.accounts;

public class YatirimHesabi extends BankaHesabi {
	 private String hesapTuru;

	 public YatirimHesabi(double bakiye) {
	        super(bakiye);
	        this.hesapTuru = "Yatırım Hesabı";
	  }
	 
	 public String getHesapTuru() {
		 return hesapTuru;
	 }
	 public void setHesapTuru(String hesapTuru) {
		 this.hesapTuru=hesapTuru;
	 }
	 
	 public void paraEkle(double miktar) {
		 if (miktar <= 0) {
			 System.out.println("Geçersiz miktar. Para ekleme işlemi iptal edildi.");
	            return;
		 }
		 this.setBakiye(this.getBakiye() + miktar);
		 System.out.println(miktar + " TL yatırım hesabına eklendi. Yeni bakiye: " + this.getBakiye() + " TL");
	 }
	 
	 public void paraCek(double miktar) {
		 if (miktar <= 0) {
			 System.out.println("Geçersiz miktar. Para çekme işlemi iptal edildi.");
			 return;
		 }
		 if (this.getBakiye() < miktar) {
			 System.out.println("Yetersiz bakiye! Para çekme işlemi gerçekleştirilemedi.");
			 return;
		 }
		 this.setBakiye(this.getBakiye() - miktar);
		 System.out.println(miktar + " TL yatırım hesabından çekildi. Yeni bakiye: " + this.getBakiye() + " TL");
	 }
	 
	 public String toString() {
		 return "YatirimHesabi{hesapTuru='" + hesapTuru + "', " + super.toString() + "}";
	 }
}
