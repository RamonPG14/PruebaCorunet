<%@ page import="servlets.Control" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Añadir Videojuego</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
</head>
<body>

<% String Categoria = request.getParameter(Control.PARAM_CATEGORIA); %>

<nav class="navbar navbar-expand-md navbar-dark	bg-dark">
	<a class="navbar-brand" href=#>&nbsp&nbsp&nbspCRUD de videojuegos</a>
</nav>

<div class="container">
<form action="<%= request.getContextPath() %>/control" method="POST">
	<input type="hidden" name="<%= Control.PARAM_ACTION_ID %>" value="ALTA_VIDEOJUEGO">
	
	<input type="hidden" name="PARAM_ID" value="<%= ++Control.contador %>">
	
	<input type="hidden" name="PARAM_CATEGORIA" value="<%= Categoria %>">
	
	<br>
	<div class="form-group row">
		<label class="col-sm-2 col-form-label">Nombre:</label>
		<div class="col-sm-10">
			<input type="text" name="<%= Control.PARAM_NOMBRE %>" value="Juego" class="form-control">
		</div>
  	</div>
  	<div class="form-group row">
		<label class="col-sm-2 col-form-label">Plataforma:</label>
		<div class="col-sm-10">
			<select name="<%= Control.PARAM_PLAT %>" class="form-control">
					<option value="PS5">PS5</option>
					<option value="XBOX">XBOX</option>
					<option value="PC">PC</option>
			</select>
		</div>
  	</div>
	
	<div class="form-group row">
		<label class="col-sm-2 col-form-label">Precio:</label>
		<div class="col-sm-10">
			<input type="text" name="<%= Control.PARAM_PRECIO %>" value="10" class="form-control">
		</div>
  	</div>
	
	<div class="form-group row">
		<label class="col-sm-2 col-form-label">Estado:</label>
		<div class="col-sm-10">
			<select name="<%= Control.PARAM_ESTADO %>" class="form-control">
				<option value="false">No alquilado</option>
				<option value="true">Alquilado</option>
			</select>
		</div>
  	</div>
			
	<input type="submit" class="btn btn-info"><br>
</form>
</div>

</body>
</html>