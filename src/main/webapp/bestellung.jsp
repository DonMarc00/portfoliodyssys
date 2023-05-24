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
  <style>
    body {
      font-family: 'Arial';
    }

    table {
      width: 100%;
      border-collapse: collapse;
      margin-bottom: 20px;
    }

    th, td {
      border: 1px solid #ddd;
      padding: 8px;
      text-align: left;
    }

    th {
      background-color: #4CAF50;
      color: white;
    }

    tr:nth-child(even) {
      background-color: #f2f2f2;
    }
  </style>
</head>
<body>
<h1>Bestellungen für Tisch <%= request.getParameter("tischId") %></h1>
<form action="AddOrderServlet" method="post">

  <h3>Speisen:</h3>
  <table>
    <tr>
      <th>Anzahl</th>
      <th>Speise</th>
      <th>Preis</th>
    </tr>
    <tr>
      <td><input type="number" name="PizzaMargherita" min="0" value="0" required></td>
      <td>Pizza Margherita</td>
      <td>7.50€</td>
    </tr>
    <tr>
      <td><input type="number" name="Salat" min="0" value="0" required></td>
      <td>Salat</td>
      <td>5.00€</td>
    </tr>
    <tr>
      <td><input type="number" name="PastaBolognese" min="0" value="0" required></td>
      <td>Pasta Bolognese</td>
      <td>4.00€</td>
    </tr>
    <tr>
      <td><input type="number" name="PizzaHawaii" min="0" value="0" required></td>
      <td>Pizza Hawaii</td>
      <td>8.00€</td>
    </tr>
    <tr>
      <td><input type="number" name="PastaCarbonara" min="0" value="0" required></td>
      <td>Pasta Carbonara</td>
      <td>6.50€</td>
    </tr>
  </table>

  <h3>Getränke:</h3>
  <table>
    <tr>
      <th>Anzahl</th>
      <th>Getränk</th>
      <th>Preis</th>
    </tr>
    <tr>
      <td><input type="number" name="Cappuccino" min="0" value="0" required></td>
      <td>Cappuccino</td>
      <td>3.50€</td>
    </tr>
    <tr>
      <td><input type="number" name="Espresso" min="0" value="0" required></td>
      <td>Espresso</td>
      <td>2.00€</td>
    </tr>
    <tr>
      <td><input type="number" name="LatteMacchiato" min="0" value="0" required></td>
      <td>Latte Macchiato</td>
      <td>4.50€</td>
    </tr>
    <tr>
      <td><input type="number" name="SchwarzerTee" min="0" value="0" required></td>
      <td>Schwarzer Tee</td>
      <td>2.50€</td>
    </tr>
    <tr>
      <td><input type="number" name="Wasser" min="0" value="0" required></td>
      <td>Wasser</td>
      <td>1.00€</td>
    </tr>
  </table>
  <input type="hidden" name="tischId" value="${tischId}">
  <button type="submit">Bestellung hinzufügen</button>
  <!--<label for="produktName">Produktname:</label>
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
  <input type="submit" value="Bestellung hinzufügen">--!>
</form>

<p>
  <a href="rechnung.jsp?tischId=<%= request.getParameter("tischId") %>">Rechnung anfordern</a> <br>
</p>
<p>
  <a href="index.jsp">Zurück zur Startseite</a><br>
</p>
<!-- Fehlermeldung anzeigen -->
<p style="color:red;"><%= request.getAttribute("errorMessage") %></p>
</body>
</html>
