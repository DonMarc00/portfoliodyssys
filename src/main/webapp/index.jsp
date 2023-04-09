<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Gastronomie-System</title>
</head>
<body>
<h1>Willkommen beim Gastronomie-System</h1>
<p>Wählen Sie einen Tisch:</p>
<form action="AddOrderServlet" method="post">
    <label for="tischId">Tisch ID:</label>
    <input type="number" id="tischId" name="tischId"><br>
    
    <input type="submit" value="Bestellungen anzeigen">
</form>
</body>
</html>