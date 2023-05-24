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
    <style>
        body {
            font-family: 'Arial';
            margin: 0;
            background-color: #f9f9f9;
            color: #333;
        }

        h1 {
            text-align: center;
            padding: 20px;
        }

        form {
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            padding: 20px;
        }

        label, input, select, p {
            margin: 10px 0;
        }

        input[type="submit"] {
            margin-top: 20px;
            padding: 10px;
            background-color: #4CAF50;
            color: white;
            border: none;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
<h1>Rechnung für Tisch <%= (String)session.getAttribute("tischId") %></h1>

<!-- Hier würden Sie die Rechnungsdetails anzeigen, z. B. die Liste der bestellten Produkte -->
<form action="ApplyDiscountServlet" method="post">
    <!--Holt sich den zu zahlenden Betrag eines Tisches aus der Rechnung. Formatiert den zu zahlenden Betrag auf zwei Nachkommastellen-->
    <p>
        Zu zahlender Betrag: <%= String.format("%.2f", Tische.getTisch(Integer.parseInt((String)session.getAttribute("tischId"))).getRechnung().getTotal()) %> €
    </p>
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
    <p>
        <a href="index.jsp">Zurück zur Startseite</a>
    </p>
</form>

</body>
</html>
