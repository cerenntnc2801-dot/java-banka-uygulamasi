package com.bank.app.accounts;

import java.util.Random;

public class BankaHesabi {
	private String iban;
	private double bakiye;
	
	public BankaHesabi(double bakiye) {
        this.iban = olusturIBAN();
        this.bakiye = bakiye;
    }
	
	private String olusturIBAN() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder("TR");
        for (int i = 0; i < 24; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }
	
	public String getIban() {
		return iban;
	}
    public void setIban(String iban) {
    	this.iban = iban; 
    }
    
    public double getBakiye() {
    	return bakiye;
    }
    public void setBakiye(double bakiye) {
    	this.bakiye = bakiye;
    }
    
    public String toString() {
        return "IBAN: " + iban + " | Bakiye: " + bakiye + " TL";
    }
}
