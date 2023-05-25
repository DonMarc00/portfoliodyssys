package com.gastro.portfolioarbeit;

import java.io.Serializable;

public class Tisch implements Serializable {
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

