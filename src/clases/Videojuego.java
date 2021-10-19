package clases;

import java.util.Hashtable;

public class Videojuego {

	private int id;
	private String nombre;
	private String plataforma;
	private double precio;
	private String categoria;
	private boolean alquilado;
	//Hashtable <String,Integer> valoraciones; //= new Hashtable <String,int>();
	
	public Videojuego(int id, String nombre, String plataforma, double precio, String categoria, boolean alquilado) {//, Hashtable<String, Integer> valoraciones) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.plataforma = plataforma;
		this.precio = precio;
		this.categoria = categoria;
		this.alquilado = alquilado;
		//this.valoraciones = valoraciones;
	}

	public boolean isAlquilado() {
		return alquilado;
	}

	public void setAlquilado(boolean alquilado) {
		this.alquilado = alquilado;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	/*public Hashtable<String, Integer> getValoraciones() {
		return valoraciones;
	}

	public void setValoraciones(Hashtable<String, Integer> valoraciones) {
		this.valoraciones = valoraciones;
	}*/
	
	
}
