<%@ page import="servlets.Login" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
</head>
<body>

<nav class="navbar navbar-expand-md navbar-dark	bg-dark">
	<a class="navbar-brand" href=#>&nbsp&nbsp&nbspCRUD de videojuegos</a>
</nav>

<p style="color:#FF0000">
	<%
	
		String msg = (String)request.getAttribute(Login.MSG_ERROR);
	
		if (msg != null){
			out.println("<i>"+msg+"</i><br>");
		}
		
		msg = null;
	
	%>
</p>

<div class="container">

<form action="<%= request.getContextPath() %>/login" method="POST">
	<div class="form-group row">
		<label class="col-sm-2 col-form-label">Usuario:</label>
		<div class="col-sm-10">
			<input type="text" name="<%= Login.PARAM_NAME %>" value="admin" class="form-control">
		</div>
  	</div>
  	
  	<div class="form-group row">
    	<label class="col-sm-2 col-form-label">Contraseņa:</label>
    	<div class="col-sm-10">
			<input type="password" name="<%= Login.PARAM_PASS %>" value="admin" class="form-control"><br>
		</div>
  	</div>
	<input type="submit" class="btn btn-primary">
</form>

</div>

</body>
</html>