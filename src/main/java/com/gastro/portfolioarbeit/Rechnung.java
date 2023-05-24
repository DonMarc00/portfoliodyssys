package com.gastro.portfolioarbeit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Rechnung {
    private Map<Produkt, Integer> bestellteProdukte;
    private double rabatt;
    private double barGeld;
    private String zahlungsArt;

    public Rechnung() {
        this.bestellteProdukte = new HashMap<>();
        this.rabatt = 0;
        this.barGeld = -1;
    }

    public void addProdukt(Produkt produkt, int menge) {
        bestellteProdukte.put(produkt, bestellteProdukte.getOrDefault(produkt, 0) + menge);
    }

    public void setRabatt(double rabatt) {
        this.rabatt = rabatt;
    }

    public double getRabatt() {
        return rabatt;
    }

    public double getTotal() {
        double total = 0;
        for (Map.Entry<Produkt, Integer> entry : bestellteProdukte.entrySet()) {
            total += entry.getKey().getPreis() * entry.getValue();
        }
        return total * (1 - rabatt);
    }

    public ArrayList<Map.Entry<Produkt, Integer>> getBestellteProdukte() {
        return new ArrayList<>(bestellteProdukte.entrySet());
    }

    public double getBarGeld() {
        return barGeld;
    }

    public void setBarGeld(double barGeld){
        this.barGeld = barGeld;
    }

    public String getZahlungsArt() {
        return zahlungsArt;
    }

    public void setZahlungsArt(String zahlungsArt) {
        this.zahlungsArt = zahlungsArt;
    }
}

