package acciones;

import java.io.IOException;
import java.util.Hashtable;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import clases.Videojuego;
import servlets.Control;

public class AccionBajaVideojuego implements Accion {

	public AccionBajaVideojuego() {
		System.out.println("Objeto baja videojuego creado");
	}


	public String ejecutar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Hashtable<Integer, Videojuego> videojuegos = (Hashtable<Integer, Videojuego>) request.getServletContext().getAttribute(Control.ATR_VIDEOJUEGOS);
		
		String paramID = request.getParameter(Control.PARAM_ID);
		int id = Integer.parseInt(paramID);
		
		videojuegos.remove(id);
		
		String jsp = "/jsp/crud.jsp"; //request.getContextPath() + 
		return jsp;
	}
	
}
