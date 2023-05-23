<%@ page import="com.gastro.portfolioarbeit.Tische" %>
<%@ page import="com.gastro.portfolioarbeit.Tisch" %>
<%@ page import="com.gastro.portfolioarbeit.Rechnung" %><%--
  Created by IntelliJ IDEA.
  User: Novak
  Date: 29.03.2023
  Time: 13:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Rechnung</title>
</head>
<body>
<h1>Rechnung für Tisch <%= request.getParameter("tischId") %></h1>
<%  Tisch tisch = Tische.getTisch(Integer.parseInt(request.getParameter("tischId")));
    Rechnung rechnung = tisch.getRechnung();
    double zuZahlen = rechnung.getTotal() * rechnung.getRabatt();
%>
<p>
    Zu zahlender Betrag: <%=zuZahlen%>
</p>
<!-- Hier würden Sie die Rechnungsdetails anzeigen, z. B. die Liste der bestellten Produkte -->
<form action="ApplyDiscountServlet" method="post">
    <input type="hidden" name="tischId" value="<%= request.getParameter("tischId") %>">
    <label for="rabattCode">Rabattcode:</label>
    <input type="text" id="rabattCode" name="rabattCode">
    <input type="submit" value="Rabatt anwenden">
</form>
<form action="CompletePaymentServlet" method="post">
    <input type="hidden" name="tischId" value="<%= request.getParameter("tischId") %>">
    <label for="zahlungsmethode">Zahlungsmethode:</label>
    <select id="zahlungsmethode" name="zahlungsmethode">
        <option value="bar">Bar</option>
        <option value="karte">Karte</option>
    </select>
    <label for="gezahlterBetrag">Gezahlter Betrag:</label>
    <input type="text" id="gezahlterBetrag" name="gezahlterBetrag">
    <input type="submit" value="Zahlung abschließen">
</form>
<p>
    <a href="index.jsp">Zurück zur Startseite</a>
</p>
</body>
</html>
