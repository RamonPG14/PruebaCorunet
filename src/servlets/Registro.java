package servlets;

import java.io.IOException;
import java.util.Hashtable;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/registro")
public class Registro extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String ATR_USUARIOS = "ATR_USUARIOS";
	
	public static final String PARAM_NAME = "PARAM_NAME";
	public static final String PARAM_PASS = "PARAM_PASS";
	public static final String PARAM_CONFPASS = "PARAM_CONFPASS";
	
	public static final String MSG_ERROR = "MSG_ERROR";
       
    public Registro() {
        super();
        // TODO Auto-generated constructor stub
    }

	public void init(ServletConfig config) throws ServletException {
		
		Hashtable<String, clases.Usuario> usuarios = (Hashtable<String, clases.Usuario>) config.getServletContext().getAttribute(Registro.ATR_USUARIOS);
		
		if (usuarios == null) {
			
			usuarios = new Hashtable<String, clases.Usuario>();
			usuarios.put("admin", new clases.Usuario("admin","admin"));
			
			config.getServletContext().setAttribute(Registro.ATR_USUARIOS, usuarios);
		}
		
		super.init(config);
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Hashtable<String, clases.Usuario> usuarios = (Hashtable<String, clases.Usuario>) request.getServletContext().getAttribute(Registro.ATR_USUARIOS);
		
		String paramN = (String) request.getParameter(Registro.PARAM_NAME);
		String paramP = (String) request.getParameter(Registro.PARAM_PASS);
		String paramCP = (String) request.getParameter(Registro.PARAM_CONFPASS);
		
		String jsp = "/jsp/registro.jsp";
		
		if((!"".equals(paramN) && !"".equals(paramP) && !"".equals(paramCP) )) {
		
			if (paramP.equals(paramCP)) {
				
				usuarios.put(paramN, new clases.Usuario(paramN,paramP));
				jsp = "/jsp/login.jsp";
				
			} else {
				request.setAttribute(Registro.MSG_ERROR, "Las contraseñas no coinciden");
			}
			
		} else {
			request.setAttribute(Registro.MSG_ERROR, "Ningún campo puede quedar en blanco");
		}
			
		request.getRequestDispatcher(jsp).forward(request, response);
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
