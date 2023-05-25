package com.gastro.portfolioarbeit;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Tische implements Serializable {

    static Map<String, Tisch> liste = new HashMap<>();

    public static void setTisch(String index, Tisch tisch) {
        liste.put(index, tisch);
    }

    public static Tisch getTisch(String tischId) {
        return liste.get(tischId);
    }

    public static boolean exists(String tischId) {
        if (liste.get(tischId) != null) return true;
        return false;
    }
}
