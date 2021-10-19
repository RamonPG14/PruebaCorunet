package acciones;

import java.io.IOException;
import java.util.Hashtable;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import clases.Usuario;
import servlets.Control;
import servlets.Login;

public class AccionBajaUsuario implements Accion {

	public AccionBajaUsuario() {
		System.out.println("Objeto baja usuario creado");
	}
	

	public String ejecutar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Hashtable<String, Usuario> usuarios = (Hashtable<String, Usuario>) request.getServletContext().getAttribute(Login.ATR_USUARIOS);
		String param_name = request.getParameter(Login.PARAM_NAME);

		HttpSession sesion = request.getSession();
		sesion.removeAttribute(param_name);

		usuarios.remove(param_name);
		
		String jsp = "/jsp/crud.jsp?" + Login.PARAM_NAME + "=admin"; //request.getContextPath() + 
		return jsp;
	}
	
}
