package servlets;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import acciones.Accion;
import acciones.AccionAltaVideojuego;
import acciones.AccionBajaUsuario;
import acciones.AccionBajaVideojuego;
import acciones.AccionModificarVideojuego;
import acciones.AccionesCategorias;
import clases.Videojuego;

@WebServlet("/control")
public class Control extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static final String PARAM_ACTION_ID = "PARAM_ACTION_ID";
	
	//Atributos de los videojuegos
	public static final String PARAM_NOMBRE = "PARAM_NOMBRE";
	public static final String PARAM_PLAT = "PARAM_PLAT";
	public static final String PARAM_PRECIO = "PARAM_PRECIO";
	public static final String PARAM_ID = "PARAM_ID";
	public static final String PARAM_ID2 = "PARAM_ID2";
	public static final String PARAM_CATEGORIA = "PARAM_CATEGORIA";
	public static final String PARAM_ESTADO = "PARAM_ESTADO";
	public static int PARAM_IDINT = 1;
	public static int contador = 0;
	
	public static final String ATR_VIDEOJUEGOS = "ATR_VIDEOJUEGOS";
	public static final String ATR_CATEGORIAS = "ATR_CATEGORIAS";

	public static final String ATR_USER = "ATR_USER";
	public static final String MSG_ERROR = "MSG_ERROR";
	public static final String CATEGORIA = "CATEGORIA";
       
	private Hashtable<String, Accion> acciones = null;

	
    public Control() {
        super();
        // TODO Auto-generated constructor stub
    }
	
	@Override
	public void init(ServletConfig config) throws ServletException {

		ArrayList<String> categorias= new ArrayList<String>();
		Hashtable<Integer, Videojuego> games = new Hashtable<Integer, Videojuego>();
		
		config.getServletContext().setAttribute(Control.ATR_CATEGORIAS, categorias);
		config.getServletContext().setAttribute(Control.ATR_VIDEOJUEGOS, games);
		//games.put(7, new Videojuego("GTA","PS4",10));
		
		
		
		if (this.acciones == null) {

			this.acciones = new Hashtable<String, Accion>();
			
			this.acciones.put("ALTA_CATEGORIA", new AccionesCategorias());
			this.acciones.put("BAJA_CATEGORIA", new AccionesCategorias());
			
			this.acciones.put("ALTA_VIDEOJUEGO", new AccionAltaVideojuego());
			this.acciones.put("BAJA_VIDEOJUEGO", new AccionBajaVideojuego());
			this.acciones.put("MODIFICAR_VIDEOJUEGO", new AccionModificarVideojuego());
			
			this.acciones.put("BAJA_USUARIO", new AccionBajaUsuario());
			
			
			/*String realPath = config.getServletContext().getRealPath("WEB-INF\\acciones.properties");
			Properties ficheroAcciones = new Properties();
			
			try {
				
				ficheroAcciones.load(new FileInputStream(new File(realPath)));	
				String propiedadIDS = ficheroAcciones.getProperty("IDS");
				String [] ids = propiedadIDS.split(" ");
				
				for(int i = 0; i < ids.length ; i++) {
				
					String idClase = ids[i];
					String nombreClase = ficheroAcciones.getProperty(idClase);

					Class<?> clase = (Class<?>) Class.forName(nombreClase);
					Constructor<?> constructor = clase.getConstructor();
							
					Accion accion = (Accion)constructor.newInstance();
					
					this.acciones.put(idClase,accion);
					
					System.out.println("Accion " 
										+ ficheroAcciones.getProperty(ids[i])
										+ " con id " + ids[i]);
				}
				
			} catch (IOException | ClassNotFoundException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
				e.printStackTrace();
			}*/
			
		} 
		super.init(config);
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		try {
			String paramNa = request.getParameter(Login.PARAM_NAME);
			
			String paramActionID = request.getParameter(Control.PARAM_ACTION_ID);
			Accion accion = this.acciones.get(paramActionID);
			String jsp = accion.ejecutar(request, response);
			request.getRequestDispatcher(jsp).forward(request, response);
			
		}catch(Exception e) {
			//System.out.println(e.getMessage());
			response.sendRedirect(request.getContextPath() + "/jsp/crud.jsp");
		}
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
