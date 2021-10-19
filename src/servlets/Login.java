package servlets;

import java.io.IOException;
import java.util.Hashtable;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import clases.Usuario;


@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static final String PARAM_NAME = "PARAM_NAME";
	public static final String PARAM_PASS = "PARAM_PASS";

	public static final String ATR_USUARIOS = "ATR_USUARIOS";

	public static final String ATR_USER = "ATR_USER";
	public static final String MSG_ERROR = "MSG_ERROR";
	
    
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	public void init(ServletConfig config) 
			throws ServletException {
		
		Hashtable<String, clases.Usuario> usuarios = (Hashtable<String, clases.Usuario>) config.getServletContext().getAttribute(Login.ATR_USUARIOS);
		
		if (usuarios == null) {
			
			usuarios = new Hashtable<String,Usuario>();
			usuarios.put("admin", new Usuario("admin","admin"));
			config.getServletContext().setAttribute(Login.ATR_USUARIOS, usuarios);
			
		}
		super.init(config);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		Hashtable<String,Usuario> usuarios = (Hashtable<String,Usuario>) request.getServletContext().getAttribute(Login.ATR_USUARIOS);
		
		String paramN = request.getParameter(Login.PARAM_NAME);
		String paramP = request.getParameter(Login.PARAM_PASS);
		
		String jsp = "/jsp/login.jsp"; //request.getContextPath() + 
		if((!"".equals(paramN) && !"".equals(paramP) )) {
			
			Usuario user = usuarios.get(paramN);
			
			if(user != null) {
				if(paramP.equals(user.getContra())) {
					request.getSession().setAttribute(Login.ATR_USER, user);
					jsp = "/jsp/crud.jsp"; // request.getContextPath() + 
					
				} else {
					request.setAttribute(Login.MSG_ERROR, "Contraseña incorrecta");
				}
				
			} else {
				request.setAttribute(Login.MSG_ERROR, "El usuario introducido no exite");
			}
		
		} else {
			request.setAttribute(Login.MSG_ERROR, "No puede dejar vacío uno de los campos");
		}
		
		request.getRequestDispatcher(jsp).forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
