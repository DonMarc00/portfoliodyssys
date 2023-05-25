package com.gastro.portfolioarbeit;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "SelectTableServlet", value = "/SelectTableServlet")
public class SelectTableServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        if (session.getAttribute("tische") == null) {
            session.setAttribute("tische", new ArrayList<Tisch>());
        }

        ArrayList<Tisch> tische = (ArrayList<Tisch>) session.getAttribute("tische");

        String tischId = request.getParameter("tischId")+request.getParameter("einzelrechnung");
        Tisch tisch = tische.stream().filter(t -> t.getTischId().equals(tischId)).findFirst().orElse(null);

        if (tisch == null) {
            tisch = new Tisch(tischId);
            tische.add(tisch);
        }

        session.setAttribute("tischId", tischId);
        session.setAttribute("tische", tische);
        RequestDispatcher dispatcher = request.getRequestDispatcher("bestellung.jsp");
        dispatcher.forward(request, response);
    }
}
