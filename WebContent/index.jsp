<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>P�gina principal</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
</head>
<body>

<nav class="navbar navbar-expand-md navbar-dark	bg-dark">
	<a class="navbar-brand" href=#>&nbsp&nbsp&nbspCRUD de videojuegos</a>
</nav>
	
<div class="container">
	<br>
	<h4>Bienvenido a la p�gina. Inicie sesi�n para acceder</h4><br>
	<a href="<%= request.getContextPath() %>/jsp/login.jsp" class="btn btn-primary">Iniciar sesi�n</a> &nbsp
	<a href="<%= request.getContextPath() %>/jsp/registro.jsp" class="btn btn-danger">Registrarse</a>
</div>

</body>
</html>