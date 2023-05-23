package com.gastro.portfolioarbeit;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "AddOrderServlet", value = "/AddOrderServlet")
public class AddOrderServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String tischId = (String)session.getAttribute("tischId");
        if(!Tische.exists(Integer.parseInt(tischId))) {
            Tisch tisch = new Tisch(tischId);
            Tische.setTisch(Integer.parseInt(((String) session.getAttribute("tischId"))), tisch);
        }
        Tisch tisch = Tische.getTisch(Integer.parseInt(tischId));



        Rechnung rechnung = tisch.getRechnung();
        try {
            rechnung.addProdukt(ProduktVerzeichnis.getProduktByName("Cappuccino"), Integer.parseInt(request.getParameter("Cappuccino")));
            for (Produkt produkt : ProduktVerzeichnis.getProdukte()) {
                String produktname = produkt.getName();
                rechnung.addProdukt(produkt, Integer.parseInt(request.getParameter(produktname)));
            }/*
            rechnung.addProdukt(ProduktVerzeichnis.getProduktByName("Espresso"), Integer.parseInt(request.getParameter("Espresso")));
            rechnung.addProdukt(ProduktVerzeichnis.getProduktByName("PizzaMargherita"), Integer.parseInt(request.getParameter("PizzaMargherita")));
            rechnung.addProdukt(ProduktVerzeichnis.getProduktByName("Salat"), Integer.parseInt(request.getParameter("Salat")));
            rechnung.addProdukt(ProduktVerzeichnis.getProduktByName("PastaBolognese"), Integer.parseInt(request.getParameter("PastaBolognese")));
            rechnung.addProdukt(ProduktVerzeichnis.getProduktByName("PizzaHawaii"), Integer.parseInt(request.getParameter("PizzaHawaii")));
            rechnung.addProdukt(ProduktVerzeichnis.getProduktByName("PastaCarbonara"), Integer.parseInt(request.getParameter("PastaCarbonara")));
            rechnung.addProdukt(ProduktVerzeichnis.getProduktByName("LatteMacchiato"), Integer.parseInt(request.getParameter("LatteMacchiato")));
            rechnung.addProdukt(ProduktVerzeichnis.getProduktByName("Salat"), Integer.parseInt(request.getParameter("SchwarzerTee")));
            rechnung.addProdukt(ProduktVerzeichnis.getProduktByName("SchwarzerTee"), Integer.parseInt(request.getParameter("Wasser")));*/
        } catch (NumberFormatException e){
            String msg = "Es dürfen keine leeren Felder übergeben werden";
            System.out.println(msg);
            request.setAttribute("errorMessage", msg);
            RequestDispatcher dispatcher = request.getRequestDispatcher("bestellung.jsp");
            dispatcher.forward(request,response);
        }


        System.out.println("Produkte im Produktverzeichnis: ");
        ProduktVerzeichnis.getProdukte().forEach(p -> System.out.println(p.getName()));


        //Produkt produkt = ProduktVerzeichnis.getProduktByName(produktName);

            //tisch.getRechnung().addProdukt(produkt, menge);

            session.setAttribute("tischId", tischId);
            RequestDispatcher dispatcher = request.getRequestDispatcher("bestellung.jsp");
            dispatcher.forward(request, response);
        /* else {
            request.setAttribute("errorMessage", "Das eingegebene Produkt wurde nicht gefunden. Bitte überprüfen Sie den Produktnamen und versuchen Sie es erneut.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("bestellung.jsp");
            dispatcher.forward(request, response);
        } */
    }
}

