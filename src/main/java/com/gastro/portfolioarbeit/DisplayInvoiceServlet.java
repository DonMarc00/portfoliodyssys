package com.gastro.portfolioarbeit;


import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpSession;

import java.util.Map;
import java.util.ArrayList;


import java.io.IOException;

@WebServlet(name = "DisplayInvoiceServlet", value = "/DisplayInvoice")
public class DisplayInvoiceServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Die Rechnung aus der Session holen
        //Rechnung rechnung = (Rechnung) request.getSession().getAttribute("rechnung");
        HttpSession session = request.getSession();
        Rechnung rechnung = Tische.getTisch(Integer.parseInt((String)session.getAttribute("tischId"))).getRechnung();


        if (rechnung == null) {
            response.setContentType("text/html");
            response.getWriter().println("Rechnung nicht gefunden");
            return;
        }

        // Die Methode generateInvoiceTable aufrufen und das Ergebnis in die Antwort schreiben
        String invoiceTable = generateInvoiceTable(rechnung);
        response.setContentType("text/html");
        response.getWriter().println("<!DOCTYPE html>");
        response.getWriter().println("<html>");
        response.getWriter().println("<head>");
        response.getWriter().println(generateStyleTag());
        response.getWriter().println("</head>");
        response.getWriter().println("<body>");
        response.getWriter().println("<h3>Rechnung für den Tisch: " + session.getAttribute("tischId") + "</h3>");
        response.getWriter().println(invoiceTable);
        response.getWriter().println("</body>");
        response.getWriter().println("</html>");
        response.getWriter().println("<a href=\"FreeTable\">Tisch freigeben</a>");
        response.getWriter().println("<p><a href=\"index.jsp\">Startseite</a></p>");
    }


    public String generateInvoiceTable(Rechnung rechnung) {
        StringBuilder sb = new StringBuilder();
        double rueckgeld = rechnung.getBarGeld() - rechnung.getTotal();
        sb.append("<table border='1'>");
        sb.append("<tr><th>Artikel</th><th>Menge</th><th>Preis eines Artikels</th><th>Preis eines Artikels * Menge</th></tr>");

        for (Map.Entry<Produkt, Integer> entry : rechnung.getBestellteProdukte()) {
            Produkt produkt = entry.getKey();
            int menge = entry.getValue();
            if(menge == 0) continue;
            double preis = produkt.getPreis();
            double gesamtPreis = preis * menge;

            sb.append("<tr>");
            sb.append("<td>").append(produkt.getName()).append("</td>");
            sb.append("<td>").append(menge).append("</td>");
            sb.append("<td>").append(String.format("%.2f", preis)).append("</td>");
            sb.append("<td>").append(String.format("%.2f", gesamtPreis)).append("</td>");
            sb.append("</tr>");
        }

        double rabatt = rechnung.getRabatt() * 100;
        double total = rechnung.getTotal();

        sb.append("<tr><td colspan='3'>Rabatt: </td><td>").append(String.format("%.2f%%", rabatt)).append("</td></tr>");
        sb.append("<tr><td colspan='3'>Summe: </td><td>").append(String.format("%.2f", total)).append("</td></tr>");
        if(rechnung.getBarGeld() != -1 && rueckgeld >= 0) {
            sb.append("<tr><td colspan='3'>Rückgeld: </td><td>").append(String.format("%.2f", rueckgeld)).append("</td></tr>");
        } else if (rueckgeld < 0) {
            sb.append("<tr><td colspan='3'>Zu wenig Bargeld. Tellerwaschen angesagt! </td><td></td></tr>");
        }
        sb.append("</table>");

        return sb.toString();
    }

    public String generateStyleTag() {
        StringBuilder styleTag = new StringBuilder();
        styleTag.append("<style>");
        styleTag.append("body { font-family: 'Sans Serif'; }");
        styleTag.append("table { width: 100%; border-collapse: collapse; margin-bottom: 20px; }");
        styleTag.append("th, td { border: 1px solid #ddd; padding: 8px; text-align: left; }");
        styleTag.append("th { background-color: #4CAF50; color: white; }");
        styleTag.append("tr:nth-child(even) { background-color: #f2f2f2; }");
        styleTag.append("</style>");
        return styleTag.toString();
    }


}



