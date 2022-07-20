package com.Synoc.store.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name ="Productos")
public class Producto {
	
	//DEFINIMOS LOS ATRIBUTOS PARA LOS PRODUCTOS	
	//VAMOS HACER QUE EL ID SEA AUTOINCREMENTABLE
	@Id
	//HAREMOS UNA ESTRATEGIA PARA PODER GENERAR ESTE CAMPOCO DE FORMA INCREMEMNTABLE
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nombre;
	private String descripcion;
	private String imagen;
	private double precio;
	private int cantidad;
	//TIENE UNA RELACION CON EL USUARIO
	//INTERNAMENTE CREA UN CAMPO EN LA TABLA PRODUCTOS PARA MANDAR EL ID DEL USUARIO QUE SE MAPEE DIRECTAMENTE EN USUARIO
	@ManyToOne
	private Usuario usuario;
	
	
	
	//CONSTRUCTOR CON PARAMETROS
	public Producto(Integer id, String nombre, String descripcion, String imagen, double precio, int cantidad) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.imagen = imagen;
		this.precio = precio;
		this.cantidad = cantidad;
	}
	
	//CONSTRUCTOR SIN PARAMATROS
	public Producto() {
		
	}
	
	
	//CREAMOS GETTERS AND SETTERS-----------

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	
	//UN CONSTRUCTOR DE TODOS LOS CAMPOS----------------------------------------------------------------------
	public Producto(Integer id, String nombre, String descripcion, String imagen, double precio, int cantidad,
			Usuario usuario) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.imagen = imagen;
		this.precio = precio;
		this.cantidad = cantidad;
		this.usuario = usuario;
	}

	//GETTERS AND SETTERS DEL USUARIO--------
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	//GENERAMOS UN METODO TOSTRING PARA RETORNAR TODOS LOS CAMPOS DE LA CLASE COMO UN SOLO STRING 
	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", imagen=" + imagen
				+ ", precio=" + precio + ", cantidad=" + cantidad + "]";
	}
	
	
	
	

}
