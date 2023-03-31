package com.gastro.portfolioarbeit;

public class Bestellung {
    private String produktName;
    private int menge;
    private double preis;

    public Bestellung(String produktName, int menge, double preis) {
        this.produktName = produktName;
        this.menge = menge;
        this.preis = preis;
    }

    public String getProduktName() {
        return produktName;
    }

    public int getMenge() {
        return menge;
    }

    public double getPreis() {
        return preis;
    }
}
