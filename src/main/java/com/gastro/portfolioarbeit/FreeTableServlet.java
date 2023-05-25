package com.gastro.portfolioarbeit;


import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "FreeTableServlet", value = "/FreeTable")
public class FreeTableServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        // Gibt den Tisch frei, indem es in der Tische-Datenstruktur, den Tisch mit der tischId = null setzt
        Tische.setTisch((String)session.getAttribute("tischId"), null);
        response.sendRedirect("index.jsp");


    }
}
