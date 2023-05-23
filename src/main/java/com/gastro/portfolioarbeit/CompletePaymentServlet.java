package com.gastro.portfolioarbeit;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;



@WebServlet(name = "CompletePaymentServlet", value = "/CompletePaymentServlet")
public class CompletePaymentServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        //ArrayList<Tisch> tische = (ArrayList<Tisch>) session.getAttribute("tische");
        String tischId = request.getParameter("tischId");

        //Tisch tisch = tische.stream().filter(t -> t.getTischId().equals(tischId)).findFirst().orElse(null);
        Tisch tisch = Tische.getTisch(Integer.parseInt(tischId));
        Rechnung rechnung = tisch.getRechnung();

        if (tisch != null) {
            double gezahlterBetrag = Double.parseDouble(request.getParameter("gezahlterBetrag"));
            String zahlungsart = request.getParameter("zahlungsmethode");

            if ("bar".equalsIgnoreCase(zahlungsart)) {
                double rueckgeld = gezahlterBetrag - tisch.getRechnung().getTotal();
                rechnung.setBarGeld(gezahlterBetrag);
                request.setAttribute("rueckgeld", rueckgeld);
            }

            //tische.remove(tisch);
            //session.setAttribute("tische", tische);
        }

//        RequestDispatcher requestDispatcher = request.getRequestDispatcher("rechnung.jsp");
//        requestDispatcher.forward(request, response);
        response.sendRedirect("DisplayInvoice");

    }

}



