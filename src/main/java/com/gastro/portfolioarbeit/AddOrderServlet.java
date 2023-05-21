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
        Tisch tisch = new Tisch(tischId);
        Tische.setTisch(Integer.parseInt(((String)session.getAttribute("tischId"))), tisch);

        Rechnung rechnung = tisch.getRechnung();
        rechnung.addProdukt(ProduktVerzeichnis.getProduktByName("Cappucino"),Integer.parseInt( request.getParameter("Cappuccino")));
        rechnung.addProdukt(ProduktVerzeichnis.getProduktByName("Espresso"),Integer.parseInt( request.getParameter("Espresso")));
        rechnung.addProdukt(ProduktVerzeichnis.getProduktByName("PizzaMargherita"),Integer.parseInt( request.getParameter("PizzaMargherita")));
        rechnung.addProdukt(ProduktVerzeichnis.getProduktByName("Salat"),Integer.parseInt( request.getParameter("Salat")));
        rechnung.addProdukt(ProduktVerzeichnis.getProduktByName("PastaBolognese"),Integer.parseInt( request.getParameter("PastaBolognese")));






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

