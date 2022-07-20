package com.Synoc.store.Service;

import com.Synoc.store.Model.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoService {
	
	
//ENTONCES AQUI TENEMOS LA DEFINICION DE LOS SERVICIOS-----------------------------------------------------------------
	
	//METODOS CRUD
	//ESTO RETORNA UN PRODUCTO QUE SE LLAMA SAVE 
	public Producto save(Producto producto);
	//ESTO NOS PERMITE OBTENER UN PRODUCTO------
	//OPTINAL NOS DA LA OPCION DE VALIDAR SI ES QUE EL OBJETO QUE MANDAMOS A LLAMAR DE LA BASE DE DATOS EXISTE O NO
	public Optional<Producto> get(Integer id);
	//ESTO NOS PERMITE ACTUALIZAR LOS PRODUCTOS---
	public void update (Producto producto);
	//ESTA OPCION NOS PERMITE ELIMINAR ATRAVES DE EL ID-
	public void delete(Integer id);
	//metodo para traer un lista de todos los productos
	public List<Producto> findAll();
	
		
}
