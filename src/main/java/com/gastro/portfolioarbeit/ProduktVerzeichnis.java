package com.gastro.portfolioarbeit;

import java.util.ArrayList;
import java.util.List;

public class ProduktVerzeichnis {
/* Diese Klasse enthält alle Produkte im System und ihre Preise.
   Die Liste ist statisch.
   Somit ist das Programm auf keine Objekte dieser Klasse angewiesen und kann immer auf das Verzeichnis zugreifen.
 */
    private static List<Produkt> produkte;

    static {
        produkte = new ArrayList<>();
        produkte.add(new Produkt("Cappuccino", 3.50));
        produkte.add(new Produkt("Espresso", 2.00));
        produkte.add(new Produkt("PizzaMargherita", 7.50));
        produkte.add(new Produkt("Salat", 5.00));
        produkte.add(new Produkt("PastaBolognese", 4.00));
        produkte.add(new Produkt("PizzaHawaii", 8.00));
        produkte.add(new Produkt("PastaCarbonara", 6.50));
        produkte.add(new Produkt("LatteMacchiato", 4.50));
        produkte.add(new Produkt("SchwarzerTee", 2.50));
        produkte.add(new Produkt("Wasser", 1.00));

        System.out.println("Produktverzeichnis initialisiert:");
        produkte.forEach(p -> System.out.println(p.getName() + " - " + p.getPreis()));
    }

    public static List<Produkt> getProdukte() {
        return produkte;
    }
}
