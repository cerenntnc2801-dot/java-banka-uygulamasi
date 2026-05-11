package com.bank.app.cards;

import java.util.Random;

public class KrediKarti {
	private String kartNumarasi;
    private double limit;
    private double guncelBorc;
    private double kullanilabilirLimit;
    
    public KrediKarti(double limit, double guncelBorc) {
    	this.kartNumarasi = olusturKartNumarasi();
        this.limit = limit;
        this.guncelBorc = guncelBorc;
        this.kullanilabilirLimit = limit - guncelBorc;
    }
    
    private String olusturKartNumarasi() {
    	 Random random = new Random();
         StringBuilder sb = new StringBuilder();
         for(int grup = 0;grup<4;grup++) {
        	 if(grup > 0)sb.append("-");
        	 for(int i=0;i<4;i++) {
        		 sb.append(random.nextInt(10));
        	 }
         }
         return sb.toString();
    }
    public String getKartNumarasi() {
    	return kartNumarasi;
    }
    public void setKartNumarasi(String kartNumarasi) {
    	this.kartNumarasi=kartNumarasi;
    }
    
    public double getLimit() {
    	return limit;
    }
    public void setLimit(double limit) {
    	this.limit=limit;
    }
    
    public double getGuncelBorc() {
    	return guncelBorc;
    }
    public void setGuncelBorc(double guncelBorc) {
    	this.guncelBorc=guncelBorc;
    	this.kullanilabilirLimit=limit-guncelBorc;
    }
    
    public double getKullanilabilirLimit() {
    	return kullanilabilirLimit;
    }
    public void setKullanilabilirLimit(double kullanilabilirLimit) {
    	this.kullanilabilirLimit=kullanilabilirLimit;
    }
    
    public String toString() {
    	return "KrediKarti{" +
                "kartNo='" + kartNumarasi + '\'' +
                ", limit=" + limit +
                ", guncelBorc=" + guncelBorc +
                ", kullanilabilirLimit=" + kullanilabilirLimit +
                '}';
    }
   
}
