package acciones;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import clases.Videojuego;
import servlets.Control;

public class AccionesCategorias implements Accion {
	
	public AccionesCategorias() {
		System.out.println("Objeto categoria creado");
	}

	public String ejecutar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ArrayList<String> categorias = (ArrayList<String>) request.getServletContext().getAttribute(Control.ATR_CATEGORIAS);
		Hashtable<Integer, Videojuego> videojuegos = (Hashtable<Integer, Videojuego>) request.getServletContext().getAttribute(Control.ATR_VIDEOJUEGOS);
		
		String paramActionID = request.getParameter(Control.PARAM_ACTION_ID);
		String paramC = request.getParameter(Control.CATEGORIA);
		String jsp = "/jsp/crud.jsp";
		
		if (paramActionID.equals("ALTA_CATEGORIA")) {
			categorias.add(paramC);
			return jsp;
		}
		
		if (paramActionID.equals("BAJA_CATEGORIA")) {
			boolean cat = false;
			for (Videojuego juego : videojuegos.values()) {
				if (juego.getCategoria().equals(paramC)) {
					cat = true;
				}
			}
			
			if (cat==true) {
				request.setAttribute(Control.MSG_ERROR, "No puede borrar una categoría si esta tiene videojuegos dentro");
				request.getRequestDispatcher( "/jsp/crud.jsp").forward(request, response);
			} else {
				categorias.remove(paramC);
				return jsp;
			}
		} 
		
		return jsp;
	}

}
