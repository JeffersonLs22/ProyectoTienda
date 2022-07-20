package com.Synoc.store.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Detalles")
public class DetalleOrden {

	//DEFINIMOS PARAMETROS PARA EL DETALLE DE ORDEN DE COMPRA
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  Integer id;
	private String nombre;
	private double cantidad;
	private double precio;
	private double total;
	
	
	//ES UNA RELACION DE UNO A UNO
	@OneToOne 
	private Orden orden;
	
	
	
	@ManyToOne
	private Producto producto;
	
	
	//CONSTRUCTOS VACIO
	public DetalleOrden() {
		
	}

	//CONSTRUCTOR
	public DetalleOrden(Integer id, String nombre, double cantidad, double precio, double total) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.precio = precio;
		this.total = total;
	}

	//LOS GETTERS ANFD SETTERS

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


	public double getCantidad() {
		return cantidad;
	}


	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}


	public double getPrecio() {
		return precio;
	}


	public void setPrecio(double precio) {
		this.precio = precio;
	}


	public double getTotal() {
		return total;
	}


	public void setTotal(double total) {
		this.total = total;
	}

	
	//getter an setters

	public Orden getOrden() {
		return orden;
	}

	public void setOrden(Orden orden) {
		this.orden = orden;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
	

	//GENERAMOS UN METODO TOSTRING PARA RETORNAR TODOS LOS CAMPOS DE LA CLASE COMO UN SOLO STRING 
	@Override
	
	public String toString() {
		return "DetalleOrden [id=" + id + ", nombre=" + nombre + ", cantidad=" + cantidad + ", precio=" + precio
				+ ", total=" + total + "]";
	}
	
	
	
}
