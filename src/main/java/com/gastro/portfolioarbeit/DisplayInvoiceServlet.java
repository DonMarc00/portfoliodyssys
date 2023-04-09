package com.gastro.portfolioarbeit;


import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.WebServlet;
import java.util.Map;
import java.util.ArrayList;


import java.io.IOException;

@WebServlet(name = "DisplayInvoiceServlet", value = "/DisplayInvoice")
public class DisplayInvoiceServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Die Rechnung aus der Session holen
        Rechnung rechnung = (Rechnung) request.getSession().getAttribute("rechnung");

        // Die Methode generateInvoiceTable aufrufen und das Ergebnis in die Antwort schreiben
        String invoiceTable = generateInvoiceTable(rechnung);
        response.setContentType("text/html");
        response.getWriter().println(invoiceTable);
    }

    public String generateInvoiceTable(Rechnung rechnung) {
        StringBuilder sb = new StringBuilder();
        sb.append("<table border='1'>");
        sb.append("<tr><th>Artikel</th><th>Menge</th><th>Preis eines Artikels</th><th>Preis eines Artikels * Menge</th></tr>");

        for (Map.Entry<Produkt, Integer> entry : rechnung.getBestellteProdukte()) {
            Produkt produkt = entry.getKey();
            int menge = entry.getValue();
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
        sb.append("</table>");

        return sb.toString();
    }


}



