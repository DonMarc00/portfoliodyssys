package com.gastro.portfolioarbeit;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SelectTableServlet", value = "/SelectTableServlet")
public class SelectTableServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String tischId = request.getParameter("tischId")+request.getParameter("einzelrechnung");

        session.setAttribute("tischId", tischId);
        RequestDispatcher dispatcher = request.getRequestDispatcher("bestellung.jsp");
        dispatcher.forward(request, response);
    }
}
