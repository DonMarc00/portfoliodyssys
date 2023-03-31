<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Gastronomie-System</title>
</head>
<body>
<h1>Willkommen beim Gastronomie-System</h1>
<p>Wählen Sie einen Tisch:</p>
<form action="bestellung.jsp" method="get">
    <label for="tischId">Tisch ID:</label>
    <input type="text" id="tischId" name="tischId">
    <input type="submit" value="Bestellungen anzeigen">
</form>
</body>
</html>