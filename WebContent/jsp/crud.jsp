<%@page import="servlets.Login" %>
<%@page import="clases.Usuario"%>
<%@page import="clases.Videojuego"%>
<%@page import="java.util.Hashtable"%>
<%@page import="java.util.ArrayList"%>
<%@page import="servlets.Control"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CRUD de videojuegos</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
</head>
<body>

<% 
	Usuario user = (Usuario)request.getSession().getAttribute(Login.ATR_USER); 
%>

<nav class="navbar navbar-expand-md navbar-dark	bg-dark">
	<a class="navbar-brand" href=#>&nbsp&nbsp&nbspCRUD de videojuegos</a>
</nav>

<div class="container">
<br>

<% 
	
	Hashtable<String, clases.Usuario> usuarios = (Hashtable<String, clases.Usuario>) config.getServletContext().getAttribute(Login.ATR_USUARIOS);
	
	String paramN = user.getNombre();
	
	if (paramN.equals("admin")){
		%><h4>Usuarios conectados</h4><%
		
		for(Usuario usuario : usuarios.values()){
			if(usuario.getNombre() != "admin"){
			
				out.println("<br>" + usuario.getNombre() 
				
				+ " <a href=\"" + request.getContextPath() + "/control?" + Control.PARAM_ACTION_ID
				
				+ "=BAJA_USUARIO&"+ Login.PARAM_NAME+ "=" + usuario.getNombre() 
				
				+ "\" >Eliminar</a>" + "<br>");
				
			} else {
				out.println("admin");
			}
			out.println("<br>");
		}
		
	}
	%>
	
	<hr>


<h4>Seleccione una acción</h4>

<form action="<%= request.getContextPath() + "/control" %>" method="POST">
	<div class="form-group row">
		<div class="col">
			<label >Añadir categoría:</label>
		</div>
		<input type="hidden" name="<%= Control.PARAM_ACTION_ID %>" value="ALTA_CATEGORIA">
		<div class="col-7">
			<input type="text" name="<%= Control.CATEGORIA %>" value="Accion" class="form-control">
		</div>
		&nbsp&nbsp
		<div class="col">
			<input type="submit" value="Añadir" class="btn btn-secondary my-1">
		</div>
	</div>
</form>
<br><hr>
		
	<p style="color:#FF0000">
	<%
	
		String msg = (String)request.getAttribute(Control.MSG_ERROR);
	
		if (msg != null){
			out.println("<i>"+msg+"</i><br>");
		}
		
		msg = null;
	
	%>
</p>
	

<%

	ArrayList<String> categorias = (ArrayList<String>) request.getServletContext().getAttribute(Control.ATR_CATEGORIAS);
	Hashtable<Integer, Videojuego> games = (Hashtable<Integer, Videojuego>) request.getServletContext().getAttribute(Control.ATR_VIDEOJUEGOS);

	if (categorias != null){
		
		for (int i=0; i<categorias.size(); i++){
			out.println(categorias.get(i) + ": " +
			
			"<a href=\"" + request.getContextPath() + "/jsp/altaVideojuego.jsp?" + Control.PARAM_CATEGORIA + "=" + categorias.get(i) + "\">Añadir videojuego</a>  -  "
			
			+ "<a href=\"" + request.getContextPath() + "/control?" + Control.PARAM_ACTION_ID + "=BAJA_CATEGORIA&" + Control.CATEGORIA + "=" + categorias.get(i) + "\">Borrar Categoria</a>" + "<br>");
			
			if (games != null){
				
				for(Videojuego juego : games.values()){
					
					//out.println("<br>");
					
					if (categorias.get(i).equals(juego.getCategoria())){
						
						String estado;
						if (juego.isAlquilado() == true) {
							estado = "Alquilado";
						} else {
							estado = "No alquilado";
						}
						
						out.println(juego.getNombre() + " - " + juego.getPlataforma() + " - " + juego.getPrecio() + "$ - " + estado
								
						+ " <a href=\"" + request.getContextPath() + "/jsp/modificarVideojuego.jsp?" + Control.PARAM_ID +"=" + juego.getId() + "&" + Control.PARAM_CATEGORIA + "=" + categorias.get(i) + "\" >Modificar</a>"
					
						+ " <a href=\"" + request.getContextPath() + "/control?"
								
						+ Control.PARAM_ACTION_ID + "=BAJA_VIDEOJUEGO&"+ Control.PARAM_ID+"=" + juego.getId() 
						
						+ "\" >Eliminar</a>" + "<br>"); //+ " <a href=\"" + request.getContextPath() + "/jsp/altaVideojuego.jsp?" + Control.PARAM_CATEGORIA + "=" + categorias.get(i) + "\">Añadir videojuego</a><br>");
						
					}
					
				}
				
			} else{
				out.println("No hay videojuegos");
			}
			out.println("<br>");
			out.println("<br>");
		} 
		
		
	} else {
		out.println("No hay categorías");
		out.println("<br>");
	}

%>
<hr>
<a href= <%= request.getContextPath()  + "/logout"%> class="btn btn-outline-dark">Logout</a>

</div>

</body>
</html>