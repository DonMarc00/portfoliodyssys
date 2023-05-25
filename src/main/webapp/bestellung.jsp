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


    input[type="submit"], .button-link {
      margin-top: 20px;
      padding: 10px;
      background-color: #4CAF50;
      color: white;
      border: none;
      cursor: pointer;
      text-decoration: none;
      display: inline-block;
      text-align: center;
    }

    input[type="submit"]:hover, .button-link:hover {
      background-color: #45a049;
    }
  </style>
</head>
<body>
<h1>Bestellungen für Tisch <%= session.getAttribute("tischId") %></h1>
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
</form>

<p>
  <a class="button-link" href="rechnung.jsp?tischId=<%= request.getParameter("tischId") %>">Rechnung anfordern</a> <br>
</p>
<p>
  <a class="button-link" href="index.jsp">Zurück zur Startseite</a><br>
</p>
<!-- Fehlermeldung anzeigen -->
<p style="color:red;"><%= request.getSession().getAttribute("errorMessage") %></p>
</body>
</html>
