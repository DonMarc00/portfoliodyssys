package com.gastro.portfolioarbeit;

public class Tisch {
    private String tischId;
    private Rechnung rechnung;

    public Tisch(String tischId) {
        this.tischId = tischId;
        this.rechnung = new Rechnung();
    }

    public String getTischId() {
        return tischId;
    }

    public Rechnung getRechnung() {
        return rechnung;
    }
}

