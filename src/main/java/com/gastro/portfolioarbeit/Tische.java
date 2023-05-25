package com.gastro.portfolioarbeit;

import java.util.HashMap;
import java.util.Map;

public  class Tische {

    //static Tisch[] liste = new Tisch[5];
    static Map<String, Tisch> liste = new HashMap<>();

    public static void setTisch(String index, Tisch tisch){
        liste.put(index, tisch);
    }

    public static Tisch getTisch(String tischId){
        return liste.get(tischId);
    }

    public static boolean exists(int tischId){
        if(liste.get(tischId) != null) return true;
        return false;
    }
}
