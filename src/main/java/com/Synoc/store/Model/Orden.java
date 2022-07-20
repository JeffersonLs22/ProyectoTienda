package com.Synoc.store.Model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name ="Ordenes")
public class Orden {

	//DEFINIMOS ATRIBUTOS Y UN PAQUETE ULTIL DATE
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String numero;
	private Date fechaCreacion; 
	private Date fechaRecibida; 
	
	private double total;
	
	
	//SABEMOS QUE ESTA RELACIONADO CON EL ORDEN 
	@ManyToOne
	private Usuario usuario;
	//MAPEAMOS COMO UNA RELACION DE UNO A UNO---
	@OneToOne(mappedBy = "orden")
	private DetalleOrden detalleOrden;
	
	
	
	
	
	//CONSTRUCTOR VACIO
	public Orden() {
		
	}
	
	//CONSTRUCTOR

	public Orden(Integer id, String numero, Date fechaCreacion, Date fechaRecibida, double total) {
		super();
		this.id = id;
		this.numero = numero;
		this.fechaCreacion = fechaCreacion;
		this.fechaRecibida = fechaRecibida;
		this.total = total;
	}

	
	//GETTER Y SETTERS------------------------------------
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaRecibida() {
		return fechaRecibida;
	}

	public void setFechaRecibida(Date fechaRecibida) {
		this.fechaRecibida = fechaRecibida;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	
	
	
	//GET AN SET DEL USUARIO
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	//GETTER AN SETTER
	public DetalleOrden getDetalleOrden() {
		return detalleOrden;
	}

	public void setDetalleOrden(DetalleOrden detalleOrden) {
		this.detalleOrden = detalleOrden;
	}
	
	

	//GENERAMOS UN METODO TOSTRING PARA RETORNAR TODOS LOS CAMPOS DE LA CLASE COMO UN SOLO STRING 
	@Override
	public String toString() {
		return "Orden [id=" + id + ", numero=" + numero + ", fechaCreacion=" + fechaCreacion + ", fechaRecibida="
				+ fechaRecibida + ", total=" + total + "]";
	}
	
	
	
	
}
