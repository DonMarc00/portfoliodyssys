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
  <label for="produktName">Produktname:</label>
  <select id="produktName" name="produktName" required>
    <option value="Cappuccino">Cappuccino</option>
    <option value="Espresso">Espresso</option>
    <option value="Pizza Margherita">Pizza Margherita</option>
    <option value="Salat">Salat</option>
    <option value="Pasta Bolognese">Pasta Bolognese</option>
  </select>
  <label for="menge">Menge:</label>
  <input type="number" id="menge" name="menge" min="1" required>
  <input type="hidden" name="tischId" value="${tischId}">
  <input type="submit" value="Bestellung hinzufügen">
</form>

<p>
  <a href="rechnung.jsp?tischId=<%= request.getParameter("tischId") %>">Rechnung anzeigen</a>
</p>
<!-- Fehlermeldung anzeigen -->
<p style="color:red;"><%= request.getAttribute("errorMessage") %></p>
</body>
</html>
