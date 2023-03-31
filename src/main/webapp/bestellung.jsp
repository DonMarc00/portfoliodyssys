<%--
  Created by IntelliJ IDEA.
  User: Novak
  Date: 29.03.2023
  Time: 13:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <title>Bestellungen</title>
</head>
<body>
<h1>Bestellungen für Tisch <%= request.getParameter("tischId") %></h1>
<form action="AddOrderServlet" method="post">
  <input type="hidden" name="tischId" value="<%= request.getParameter("tischId") %>">
  <label for="produkt">Produkt:</label>
  <select id="produkt" name="produkt">
    <!-- Beispiel-Produkte, die Sie durch Ihre Produktliste ersetzen sollten -->
    <option value="1">Cappuccino</option>
    <option value="2">Espresso</option>
    <option value="3">Pizza Margherita</option>
    <option value="4">Pasta Bolognese</option>
    <option value="5">Salat</option>
  </select>
  <label for="menge">Menge:</label>
  <input type="number" id="menge" name="menge" min="1" value="1">
  <input type="submit" value="Bestellung hinzufügen">
</form>
<p>
  <a href="rechnung.jsp?tischId=<%= request.getParameter("tischId") %>">Rechnung anzeigen</a>
</p>
</body>
</html>
