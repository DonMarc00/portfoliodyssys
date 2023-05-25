<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Französisches Gastronomie-System</title>
    <style>
        body {
            font-family: "Arial";
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
            width: 300px;
            margin: 0 auto;
        }

        label {
            margin-top: 20px;
            margin-bottom: 10px;
        }

        select, input[type=submit] {
            padding: 10px;
        }

        input[type=submit] {
            background-color: #4CAF50;
            color: white;
            cursor: pointer;
            margin-top: 20px;
        }

        input[type=submit]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
<h1>Willkommen beim französischen Gastronomie-System</h1>
<form action="SelectTableServlet" method="post">
    <p>Wählen Sie einen Tisch:</p>
    <label for="tischId">Tisch Nummer:</label><br>
    <select id="tischId" name="tischId" required>
        <option value="1">1</option>
        <option value="2">2</option>
        <option value="3">3</option>
        <option value="4">4</option>
        <option value="5">5</option>
        <option value="6">6</option>
        <option value="7">7</option>
        <option value="8">8</option>
        <option value="9">9</option>
        <option value="10">10</option>

    </select><br>

    <label for="einzelrechnung">Einzelrechnung:</label><br>
    <select id="einzelrechnung" name="einzelrechnung">
        <option value=""></option>
        <option value="A">A</option>
        <option value="B">B</option>
        <option value="C">C</option>
        <option value="D">D</option>
        <option value="E">E</option>
        <option value="F">F</option>
    </select>

    <input type="submit" value="Bestellungen anzeigen">
</form>
</body>
</html>