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

        if (session.getAttribute("tische") == null) {
            session.setAttribute("tische", new ArrayList<Tisch>());
        }

        ArrayList<Tisch> tische = (ArrayList<Tisch>) session.getAttribute("tische");

        String tischId = request.getParameter("tischId");
        Tisch tisch = tische.stream().filter(t -> t.getTischId().equals(tischId)).findFirst().orElse(null);

        if (tisch == null) {
            tisch = new Tisch(tischId);
            tische.add(tisch);
        }

        String produktName = request.getParameter("produktName");
        int menge = Integer.parseInt(request.getParameter("menge"));

        System.out.println("Eingegebener Produktname: " + produktName);
        System.out.println("Produkte im Produktverzeichnis: ");
        ProduktVerzeichnis.getProdukte().forEach(p -> System.out.println(p.getName()));

        Produkt produkt = ProduktVerzeichnis.getProduktByName(produktName);
        if (produkt != null) {
            tisch.getRechnung().addProdukt(produkt, menge);

            session.setAttribute("tischId", tischId);
            session.setAttribute("tische", tische);
            RequestDispatcher dispatcher = request.getRequestDispatcher("bestellung.jsp");
            dispatcher.forward(request, response);
        } else {
            request.setAttribute("errorMessage", "Das eingegebene Produkt wurde nicht gefunden. Bitte überprüfen Sie den Produktnamen und versuchen Sie es erneut.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("bestellung.jsp");
            dispatcher.forward(request, response);
        }
    }
}

