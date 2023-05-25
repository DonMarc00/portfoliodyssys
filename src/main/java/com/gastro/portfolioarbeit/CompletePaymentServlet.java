package com.gastro.portfolioarbeit;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "CompletePaymentServlet", value = "/CompletePaymentServlet")
public class CompletePaymentServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String tischId = (String) session.getAttribute("tischId");

        Tisch tisch = Tische.getTisch(tischId);
        Rechnung rechnung = tisch.getRechnung();

        if (tisch != null) {
            String zahlungsart = request.getParameter("zahlungsmethode");

            if ("bar".equalsIgnoreCase(zahlungsart)) {
                try {
                    //Ermittelt den Betrag im Feld Gezahlter Betrag und ersetzt alle , durch .
                    String betrag = request.getParameter("gezahlterBetrag").replaceAll(",",".");
                    double gezahlterBetrag = Double.parseDouble(betrag);
                    double rueckgeld = gezahlterBetrag - tisch.getRechnung().getTotal();
                    rechnung.setBarGeld(gezahlterBetrag);
                    request.setAttribute("rueckgeld", rueckgeld);
                } catch (NumberFormatException e) {
                    //Bei Eingabefehler in die Eingabemaske zurückkehren und Fehlertext ausgeben
                    String msg = "Wenn Bar bezahlt wird, muss ein Betrag eingegeben werden!";
                    System.out.println(msg);
                    request.setAttribute("errorMessage", msg);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("rechnung.jsp");
                    dispatcher.forward(request, response);
                }
            }
            rechnung.setZahlungsArt(zahlungsart);


        }
        response.sendRedirect("DisplayInvoice");

    }

}



