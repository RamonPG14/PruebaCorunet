package acciones;

import java.io.IOException;
import java.util.Hashtable;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import clases.Videojuego;
import servlets.Control;

public class AccionAltaVideojuego implements Accion {

	public AccionAltaVideojuego() {
		System.out.println("Objeto alta usuario creado");
	}
	
	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Hashtable<Integer, Videojuego> videojuegos = (Hashtable<Integer, Videojuego>) request.getServletContext().getAttribute(Control.ATR_VIDEOJUEGOS);
		
		String paramNombre = request.getParameter(Control.PARAM_NOMBRE);
		String paramPlataforma = request.getParameter(Control.PARAM_PLAT);
		String paramPrecioS = request.getParameter(Control.PARAM_PRECIO);
		double paramPrecio = Double.parseDouble(paramPrecioS);
		String paramCategoria = request.getParameter(Control.PARAM_CATEGORIA);
		String paramEstado = request.getParameter(Control.PARAM_ESTADO);
		boolean estado;
		if (paramEstado.equals("true")) {
			estado = true;
		} else {
			estado = false;
		}
		
		String paramID = request.getParameter(Control.PARAM_ID);
		int id = Integer.parseInt(paramID);
		
		videojuegos.put(id, new Videojuego(id, paramNombre, paramPlataforma, paramPrecio, paramCategoria, estado));
		
		String jsp = "/jsp/crud.jsp"; // request.getContextPath() + 
		return jsp;
	}
}
