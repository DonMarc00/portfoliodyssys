package com.gastro.portfolioarbeit;

import jakarta.servlet.http.HttpSession;

import java.util.ArrayList;
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

//        String produktName = request.getParameter("produktName");
//        int menge = Integer.parseInt(request.getParameter("menge"));
//        double preis = Double.parseDouble(request.getParameter("preis"));
//
//        Produkt produkt = new Produkt(produktName, preis);
//        tisch.getRechnung().addProdukt(produkt, menge);

        session.setAttribute("tischId", tischId);
        session.setAttribute("tische", tische);
//        response.sendRedirect("bestellung.jsp");
        RequestDispatcher dispatcher = request.getRequestDispatcher("bestellung.jsp");
        dispatcher.forward(request, response);
    }
}