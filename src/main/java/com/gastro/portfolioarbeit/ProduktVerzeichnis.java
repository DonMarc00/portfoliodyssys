package com.gastro.portfolioarbeit;

import java.util.ArrayList;
import java.util.List;

public class ProduktVerzeichnis {

    private static List<Produkt> produkte;

    static {
        produkte = new ArrayList<>();
        produkte.add(new Produkt("Cappuccino", 3.50));
        produkte.add(new Produkt("Espresso", 2.00));
        produkte.add(new Produkt("PizzaMargherita", 7.50));
        produkte.add(new Produkt("Salat", 5.00));
        produkte.add(new Produkt("PastaBolognese", 4.00));

        System.out.println("Produktverzeichnis initialisiert:");
        produkte.forEach(p -> System.out.println(p.getName() + " - " + p.getPreis()));
    }

    public static Produkt getProduktByName(String name) {
        return produkte.stream().filter(p -> p.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
    }

    public static List<Produkt> getProdukte() {
        return produkte;
    }
}
