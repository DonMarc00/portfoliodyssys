package com.gastro.portfolioarbeit;

import java.util.HashMap;

public  class Tische {

    static Tisch[] liste = new Tisch[5];

    public static void setTisch(int index, Tisch tisch){
        liste[index] = tisch;
    }

    public static Tisch getTisch(int tischId){
        return liste[tischId];
    }

    public static boolean exists(int tischId){
        if(liste[tischId] != null) return true;
        return false;
    }
}
