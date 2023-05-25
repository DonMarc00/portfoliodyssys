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

        String tischId = (String) session.getAttribute("tischId");
        if (!Tische.exists(tischId)) {
            Tisch tisch = new Tisch(tischId);
            Tische.setTisch((String) session.getAttribute("tischId"), tisch);
        }
        Tisch tisch = Tische.getTisch(tischId);


        Rechnung rechnung = tisch.getRechnung();
        try {
            for (Produkt produkt : ProduktVerzeichnis.getProdukte()) {
                String produktname = produkt.getName();
                rechnung.addProdukt(produkt, Integer.parseInt(request.getParameter(produktname)));
            }
        } catch (NumberFormatException e) {
            String msg = "Es dürfen keine leeren Felder übergeben werden";
            System.out.println(msg);
            request.setAttribute("errorMessage", msg);
            RequestDispatcher dispatcher = request.getRequestDispatcher("bestellung.jsp");
            dispatcher.forward(request, response);
        }


        System.out.println("Produkte im Produktverzeichnis: ");

        session.setAttribute("tischId", tischId);
        RequestDispatcher dispatcher = request.getRequestDispatcher("bestellung.jsp");
        dispatcher.forward(request, response);

    }
}

