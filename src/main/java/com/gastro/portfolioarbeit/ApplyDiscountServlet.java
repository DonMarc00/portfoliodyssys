package com.gastro.portfolioarbeit;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ApplyDiscountServlet", value = "/ApplyDiscountServlet")
public class ApplyDiscountServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String tischId = request.getParameter("tischId");

        Tisch tisch = Tische.getTisch(tischId);
        Rechnung rechnung = tisch.getRechnung();

        if (tisch != null) {
            String rabattCode = request.getParameter("rabattCode");
            session.setAttribute("rabattCode", rabattCode);
            double rabatt = 0;

            switch (rabattCode) {
                case "Rabatt1":
                    rabatt = 0.1;
                    break;
                case "Rabatt2":
                    rabatt = 0.2;
                    break;
                case "Rabatt3":
                    rabatt = 0.3;
                    break;
            }

            rechnung.setRabatt(rabatt);
        }
        request.getSession().setAttribute("rechnung", rechnung);
        RequestDispatcher dispatcher = request.getRequestDispatcher("rechnung.jsp");
        dispatcher.forward(request, response);
    }
}

